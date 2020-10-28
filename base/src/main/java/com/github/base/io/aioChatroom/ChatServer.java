package com.github.base.io.aioChatroom;

import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatServer {

    private static final String LOCALHOST = "127.0.0.1";

    private static final int DEFAULT_PORT = 8888;

    private static final String QUIT = "quit";

    private static final int BUFFER = 1024;

    private static final int THREADPOOL_SIZE = 8;

    private AsynchronousChannelGroup channelGroup;

    private AsynchronousServerSocketChannel serverChannel;

    private Charset charset = Charset.forName("UTF-8");

    private List<ClientHandler> connectedClients;

    private int port;

    public ChatServer() {
        this(DEFAULT_PORT);
    }

    public ChatServer(int port) {
        this.connectedClients = new ArrayList<>();
        this.port = port;
    }

    private void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean readyToQuit(String msg) {
        return QUIT.equals(msg);
    }

    private void start() throws IOException {
        ExecutorService executorService = Executors.newFixedThreadPool(THREADPOOL_SIZE);
        channelGroup = AsynchronousChannelGroup.withThreadPool(executorService);
        serverChannel = AsynchronousServerSocketChannel.open(channelGroup);
        serverChannel.bind(new InetSocketAddress(LOCALHOST, port));
        System.out.println(String.format("服务器已启动，监听端口：%d", port));

        while (true) {
            serverChannel.accept(null, new AcceptHandler());
            System.in.read();       // 阻塞式调用，

        }
    }

    /**
     * 处理服务器端的Channel
     */
    private class AcceptHandler implements CompletionHandler<AsynchronousSocketChannel, Object> {

        @Override
        public void completed(AsynchronousSocketChannel clientChannel, Object attachment) {
            if (serverChannel.isOpen()) {
                serverChannel.accept(null, this);
            }

            if (clientChannel != null && clientChannel.isOpen()) {
                ClientHandler clientHandler = new ClientHandler(clientChannel);
                ByteBuffer buffer = ByteBuffer.allocate(BUFFER);
                addClient(clientHandler);
                clientChannel.read(buffer, buffer, clientHandler);
            }
        }


        @Override
        public void failed(Throwable exc, Object attachment) {
            System.out.println("连接失败" + exc.getMessage());
        }
    }

    /**
     * 处理客户端的Channel
     */
    private class ClientHandler implements CompletionHandler<Integer, Object> {

        private AsynchronousSocketChannel clientChannel;

        private ClientHandler(AsynchronousSocketChannel clientChannel) {
            this.clientChannel = clientChannel;
        }

        @Override
        public void completed(Integer result, Object attachment) {
            ByteBuffer buffer = (ByteBuffer) attachment;
            if (buffer != null) {
                if (result <= 0) {
                    // 客户端异常，将客户端移出在线用户列表
                    removeClient(this);
                    close(clientChannel);
                    System.out.println("客户端异常");
                } else {
                    buffer.flip();
                    String fwdMsg = receive(buffer);
                    System.out.println(getClientName(clientChannel) + ":" + fwdMsg);
                    forwardMessage(clientChannel, fwdMsg);
                    buffer.clear();

                    if (readyToQuit(fwdMsg)) {
                        removeClient(this);
                    } else {
                        // 继续监听该客户端发送的信息
                        clientChannel.read(buffer, buffer, this);
                    }
                }
            }
        }

        @Override
        public void failed(Throwable exc, Object attachment) {
            System.out.println("客户端读写失败");
        }
    }

    /**
     * 将一个客户端的信息广播到其他的客户端
     *
     * @param clientChannel
     * @param fwdMsg
     */
    private synchronized void forwardMessage(AsynchronousSocketChannel clientChannel, String fwdMsg) {
        for (ClientHandler clientHandler : connectedClients) {
            if (!clientChannel.equals(clientHandler.clientChannel)) {
                ByteBuffer byteBuffer = charset.encode(getClientName(clientHandler.clientChannel) + ":" + fwdMsg);
                clientHandler.clientChannel.write(byteBuffer, null, clientHandler);
            }
        }
    }

    /**
     * 将客户端移除在线客户列表
     *
     * @param clientHandler
     */
    private synchronized void removeClient(ClientHandler clientHandler) {
        connectedClients.remove(clientHandler);
        System.out.println(getClientName(clientHandler.clientChannel) + "已断开连接");
        close(clientHandler.clientChannel);
    }

    /**
     * 将客户端加入在线客户列表
     *
     * @param clientHandler
     */
    private synchronized void addClient(ClientHandler clientHandler) {
        connectedClients.add(clientHandler);
        System.out.println(getClientName(clientHandler.clientChannel) + "已连接到服务器");

    }

    /**
     * 客户客户端的信息
     *
     * @param clientChannel
     * @return
     */
    private String getClientName(AsynchronousSocketChannel clientChannel) {
        try {
            InetSocketAddress address = (InetSocketAddress) clientChannel.getRemoteAddress();
            return "用户" + address.getPort();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "异常用户";
    }

    /**
     * 将接受的消息解码出来
     *
     * @param buffer
     * @return
     */
    private String receive(ByteBuffer buffer) {
        CharBuffer charBuffer = charset.decode(buffer);
        return String.valueOf(charBuffer);
    }

    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer();
        try {
            chatServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
