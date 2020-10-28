package com.github.base.io.bioDemo1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        final String QUIT = "quit";
        final String DEFAULT_SERVER_HOST = "127.0.0.1";
        final int DEFAULT_SERVER_PORT = 8888;
        BufferedWriter bufferedWriter;

        try (Socket socket = new Socket(DEFAULT_SERVER_HOST, DEFAULT_SERVER_PORT)) {
            System.out.println("已成功连接服务器");
            System.out.println("请输入内容:");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                String input = consoleReader.readLine();
                // 将控制台的输入发送给服务器
                bufferedWriter.write(input + "\n");
                bufferedWriter.flush();

                // 读取服务器返回的消息
                String msg = bufferedReader.readLine();
                System.out.println(msg);

                if (QUIT.equals(input)) {
                    System.out.println("客户端退出");
                    socket.close();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
