package com.github.base.io.nioDemo.server;

import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Set;

/**
 * Created By Q.Hao
 * Description:
 * Created At 2019/11/26
 */
public class ChatServer {

    private static final int DEFAULT_PORT = 8888;

    private static final String QUIT = "quit";

    private static final int BUFFER = 1024;     // 声明Buffer容量

    private ServerSocketChannel server;
    private Selector selector;
    private ByteBuffer rBuffer = ByteBuffer.allocate(BUFFER);
    private ByteBuffer wBuffer = ByteBuffer.allocate(BUFFER);
    private Charset charset = Charset.forName("UTF-8");     // 统一编码格式为UTF-8
    private int port;

    public ChatServer() {
        this(DEFAULT_PORT);
    }

    public ChatServer(int port) {
        this.port = port;
    }

    private void start() throws Exception {
        try {
            // 设置server
            server = ServerSocketChannel.open();
            server.configureBlocking(false);        // 设置模式为非阻塞模式
            server.socket().bind(new InetSocketAddress(this.port));

            // 设置selector
            selector = Selector.open();
            server.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("启动服务器，监听端口：" + port + "...");

            while (true) {
                selector.select();      // 选择通道，如果没有通道的话，则此处一直处于阻塞状态
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                for (SelectionKey key : selectionKeys) {
                    // 处理被触发的事件
                    handles(key);
                }
                selectionKeys.clear();      // 由于事件已经被处理，所以删除Key
            }
        } finally {
            close(selector);
        }
    }

    /**
     * 处理事件
     *
     * @param key
     * @throws IOException
     */
    private void handles(SelectionKey key) throws IOException {
        if (key.isAcceptable()) {       // 处理客户端连接事件
            ServerSocketChannel server = (ServerSocketChannel) key.channel();
            SocketChannel client = server.accept();
            client.configureBlocking(false);        // 将阻塞式调用设置为非阻塞式调用
            client.register(selector, SelectionKey.OP_READ);        // 监听该客户端的读事件
            System.out.println(getClientName(client) + "已连接");
        } else if (key.isReadable()) {      // 客户端发送了消息
            SocketChannel client = (SocketChannel) key.channel();
            String fwdMsg = receive(client);        // 得到客户端发送的信息
            if (fwdMsg.isEmpty()) {     // 客户端异常
                key.cancel();
                selector.wakeup();      // 更新selector的状态
            } else {
                System.out.println(getClientName(client) + ":" + fwdMsg);
                forwardMessage(client, fwdMsg);

                // 检查用户是否要退出
                if (readyToQuit(fwdMsg)) {
                    key.cancel();
                    selector.wakeup();
                    System.out.println(getClientName(client) + "已断开");
                }
            }
        }
    }

    /**
     * 向其他用户广播消息
     *
     * @param client
     * @param fwdMsg
     */
    private void forwardMessage(SocketChannel client, String fwdMsg) throws IOException {
        // 遍历selector，得到所有连接的客户端
        for (SelectionKey key : selector.keys()) {
            Channel connectionClient = key.channel();
            // 排除服务器本身，因为服务器也注册到了这个selector
            if (connectionClient instanceof ServerSocketChannel) {
                continue;
            }

            if (key.isValid() && !client.equals(connectionClient)) {
                wBuffer.clear();
                // 组织要广播的信息
                wBuffer.put(charset.encode(getClientName(client) + ":" + fwdMsg));
                wBuffer.flip();     // 将写模式转换为读模式
                while (wBuffer.hasRemaining()) {
                    ((SocketChannel) connectionClient).write(wBuffer);
                }
            }
        }
    }

    /**
     * 关闭Selector
     *
     * @param closeable
     * @throws IOException
     */
    private void close(Closeable closeable) throws IOException {
        if (closeable != null) {
            closeable.close();
        }
    }

    /**
     * 得到客户端的信息
     *
     * @param client
     * @return
     */
    private String getClientName(SocketChannel client) {
        return "客户端[" + client.socket().getPort() + "]";
    }

    /**
     * 得到客户端发送的消息
     *
     * @param client
     * @return
     * @throws IOException
     */
    private String receive(SocketChannel client) throws IOException {
        rBuffer.clear();
        // 将发送的信息写到Buffer中
        while (client.read(rBuffer) > 0) {
        }
        rBuffer.flip();     // 将写模式转换为读模式，并解码后输出
        return String.valueOf(charset.decode(rBuffer));
    }

    /**
     * 判断用户是否要退出
     *
     * @param msg
     * @return
     */
    private boolean readyToQuit(String msg) {
        return QUIT.equals(msg);
    }

    public static void main(String[] args) throws Exception {
        ChatServer chatServer = new ChatServer(7777);
        chatServer.start();
    }
}
