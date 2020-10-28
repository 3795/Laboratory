package com.github.base.io.aioChatroom;

import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.Charset;
import java.util.concurrent.Future;

public class ChatClient {

    private static final String LOCALHOST = "localhost";
    private static final int DEFAULT_PORT = 8888;
    private static final String QUIT = "quit";
    private static final int BUFFER = 1024;

    private String host;
    private int port;
    private AsynchronousSocketChannel clientChannel;
    private Charset charset = Charset.forName("UTF-8");

    public ChatClient() {
        this(LOCALHOST, DEFAULT_PORT);
    }

    public ChatClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    private void close(Closeable closeable) throws IOException {
        if (closeable != null) {
            closeable.close();
        }
    }

    public boolean readyToQuit(String msg) {
        return QUIT.equals(msg);
    }

    private void start() throws Exception {
        clientChannel = AsynchronousSocketChannel.open();
        Future<Void> future = clientChannel.connect(new InetSocketAddress(host, port));
        future.get();       // 阻塞直到服务器接受请求
        System.out.println("已连接到服务器");
        // 处理用户输入事件
        new Thread(new UserInputHandler(this)).start();

        ByteBuffer buffer = ByteBuffer.allocate(BUFFER);
        while (true) {
            Future<Integer> readResult = clientChannel.read(buffer);
            int result = readResult.get();
            if (result <= 0) {
                close(clientChannel);
                System.out.println("与服务器连接异常");
                System.exit(1);
            } else {
                buffer.flip();
                String message = String.valueOf(charset.decode(buffer));
                buffer.clear();
                System.out.println(message);
            }
        }

    }

    /**
     * 向服务器发送消息
     * @param message
     * @throws Exception
     */
    public void send(String message) throws Exception {
        if (message.isEmpty()) {
            return;
        }
        ByteBuffer byteBuffer = charset.encode(message);
        Future<Integer> writeResult = clientChannel.write(byteBuffer);
        writeResult.get();

    }

    public static void main(String[] args) {
        ChatClient chatClient = new ChatClient();
        try {
            chatClient.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
