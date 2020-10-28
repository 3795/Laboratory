package com.github.base.io.webServer.connector;

import io.webServer.processor.ServletProcess;
import io.webServer.processor.StaticProcessor;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Connector implements Runnable {

    private static final int DEFAULT_PORT = 8888;

    private ServerSocket server;

    private int port;

    public Connector() {
        this(DEFAULT_PORT);
    }

    public Connector(int port) {
        this.port = port;
    }

    public void start() {
        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            server = new ServerSocket(port);
            System.out.println("启动服务器，端口" + port);

            while (true) {
                Socket socket = server.accept();
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();

                Request request = new Request(inputStream);
                request.parse();

                Response response = new Response(outputStream);
                response.setRequest(request);

                if (request.getRequestURI().startsWith("/servlet/")) {      // 处理动态请求
                    ServletProcess process = new ServletProcess();
                    process.process(request, response);
                } else {        // 处理静态请求
                    StaticProcessor processor = new StaticProcessor();
                    processor.process(request, response);
                }
                close(socket);      // 释放资源
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(server);
        }
    }

    /**
     * 关闭资源
     *
     * @param closeable
     */
    private void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Connector connector = new Connector();
        connector.start();
    }
}
