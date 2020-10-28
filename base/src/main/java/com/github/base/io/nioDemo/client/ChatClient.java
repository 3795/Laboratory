package com.github.base.io.nioDemo.client;

import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Set;

public class ChatClient {

    private final static String DEFAULT_SERVER_HOST = "127.0.0.1";
    private final static int DEFAULT_SERVER_PORT = 8888;
    private final String QUIT = "quit";
    private final int BUFFER = 1024;
    private String host;
    private int port;
    private SocketChannel client;
    private ByteBuffer rBuffer = ByteBuffer.allocate(BUFFER);
    private ByteBuffer wBuffer = ByteBuffer.allocate(BUFFER);
    private Selector selector;
    private Charset charset = Charset.forName("UTF-8");     // 设置编码

    public ChatClient() {
        this(DEFAULT_SERVER_HOST, DEFAULT_SERVER_PORT);
    }

    public ChatClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void start() throws IOException {
        try {
            client = SocketChannel.open();
            client.configureBlocking(false);

            selector = Selector.open();
            client.register(selector, SelectionKey.OP_CONNECT);     // 注册连接事件
            client.connect(new InetSocketAddress(host, port));      // 连接到服务器

            // 监听发生的事件
            while (true) {
                selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                for (SelectionKey key : selectionKeys) {
                    handle(key);
                }
                selectionKeys.clear();
            }
        } finally {
            close(selector);
        }
    }

    /**
     * 处理监听的事件
     * @param key
     */
    private void handle(SelectionKey key) throws IOException {
        if (key.isConnectable()) {      // 连接事件
            SocketChannel client = (SocketChannel) key.channel();
            if (client.isConnectionPending()) {     // 与服务器的连接已建立完成
                client.finishConnect();
                System.out.println("已连接到聊天室");
                new Thread(new UserInputHandler(this)).start();
            }
            client.register(selector, SelectionKey.OP_READ);
        } else if (key.isReadable()) {
            SocketChannel client = (SocketChannel) key.channel();
            String msg = receive(client);
            if (msg.isEmpty()) {
                close(selector);
            } else {
                System.out.println(msg);
            }
        }
    }

    /**
     * 发送消息
     * @param msg
     * @throws IOException
     */
    public void send(String msg) throws IOException {
        if (msg.isEmpty()) {
            return;
        }
        wBuffer.clear();
        wBuffer.put(charset.encode(msg));
        wBuffer.flip();
        while (wBuffer.hasRemaining()) {
            client.write(wBuffer);
        }

        // 检查用户是否准备退出
        if (readyToQuit(msg)) {
            close(selector);
        }
    }

    /**
     * 从服务器接收消息
     *
     * @return
     */
    public String receive(SocketChannel client) throws IOException {
        rBuffer.clear();
        while (client.read(rBuffer) > 0);
        rBuffer.flip();
        return String.valueOf(charset.decode(rBuffer));
    }

    /**
     * 检查用户是否要退出
     *
     * @param msg
     * @return
     */
    public boolean readyToQuit(String msg) {
        return QUIT.equals(msg);
    }

    /**
     * 关闭资源
     *
     * @param closeable
     */
    private void close(Closeable closeable) throws IOException {
        if (closeable != null) {
            closeable.close();
        }
        System.out.println("已关闭与服务器的连接");
    }

    public static void main(String[] args) {
        ChatClient client = new ChatClient("127.0.0.1", 7777);
        try {
            client.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
