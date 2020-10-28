package com.github.base.io.bioDemo1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        final String QUIT = "quit";

        final int DEFAULT_PORT = 8888;

        try (ServerSocket serverSocket = new ServerSocket(DEFAULT_PORT)) {
            System.out.println("服务器已成功建立，等待客户端连接");
            // 等待客户端连接
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("客户端已连接，端口 = " + socket.getPort());
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

                String msg;
                while ((msg = bufferedReader.readLine()) != null) {
                    // 从客户端处获取信息
                    System.out.println("客户端" + socket.getPort() + ": " + msg);
                    // 回复给客户端消息
                    bufferedWriter.write("服务器: " + msg + "\n");
                    bufferedWriter.flush();

                    if (QUIT.equals(msg)) {
                        System.out.println("客户端" + socket.getPort() + "已退出聊天室");
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
