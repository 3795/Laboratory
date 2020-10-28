package com.github.base.io.aioEchoWall;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.Future;

public class Client {

    final String LOCALHOST = "127.0.0.1";

    final int DEFAULT_PORT = 8888;

    AsynchronousSocketChannel clientChannel;

    private void close(Closeable closeable) throws IOException {
        if (closeable != null) {
            closeable.close();
            System.out.println("断开与服务器的连接");
        }
    }

    public void start() throws Exception {
        try {
            clientChannel = AsynchronousSocketChannel.open();
            Future<Void> future = clientChannel.connect(new InetSocketAddress(LOCALHOST, DEFAULT_PORT));
            future.get();

            // 等待用户输入
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                String input = consoleReader.readLine();
                byte[] inputBytes = input.getBytes();
                ByteBuffer buffer = ByteBuffer.wrap(inputBytes);
                Future<Integer> writeResult = clientChannel.write(buffer);
                writeResult.get();
                buffer.flip();
                Future<Integer> readResult = clientChannel.read(buffer);
                readResult.get();
                String echo = new String(buffer.array());
                buffer.clear();

                System.out.println(echo);
            }
        } finally {
            close(clientChannel);
        }
    }

    public static void main(String[] args) throws Exception {
        Client client = new Client();
        client.start();
    }

}
