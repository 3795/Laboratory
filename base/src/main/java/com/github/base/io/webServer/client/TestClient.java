package com.github.base.io.webServer.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TestClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8888);
        System.out.println("客户端启动成功");
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("GET /index.html HTTP/1.1".getBytes());
//        outputStream.write("GET /servlet/TimeServlet HTTP/1.1".getBytes());
        socket.shutdownOutput();

        InputStream inputStream = socket.getInputStream();
        byte[] buffer = new byte[2048];
        int length = inputStream.read(buffer);
        StringBuilder response = new StringBuilder();
        for (int j=0; j<length; j++) {
            char c = (char) buffer[j];
            response.append(c);
        }
        System.out.println(response.toString());
        socket.shutdownInput();

        socket.close();
    }
}
