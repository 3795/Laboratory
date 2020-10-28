package com.github.base.io.bioDemo2.client;

import java.io.*;
import java.net.Socket;

public class ChatClient {

    private final String DEFAULT_SERVER_HOST = "127.0.0.1";
    private final int DEFAULT_SERVER_PORT = 8888;
    private final String QUIT = "quit";

    private Socket socket;
    private BufferedReader reader;
    private BufferedWriter writer;

    // 发送消息到服务器
    public void send(String msg) {
        if (!socket.isOutputShutdown()) {
            try {
                writer.write(msg + "\n");
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 从服务器处接收信息
    public String receive() {
        String msg = null;
        if (!socket.isInputShutdown()) {
            try {
                msg = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return msg;
    }

    // 检测用户是否要退出
    public boolean readyToQuit(String msg) {
        return QUIT.equals(msg);
    }

    public void close() {
        if (writer != null) {
            try {
                writer.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("客户端断开连接");
        }
    }

    public void start() {
        try {
            socket = new Socket(DEFAULT_SERVER_HOST, DEFAULT_SERVER_PORT);
            System.out.println("连接到服务器成功");
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            // 处理用户的输入
            new Thread(new UserInputHandler(this)).start();

            // 读取服务器转发的消息
            String msg;
            while ((msg = receive()) != null) {
                System.out.println(msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public static void main(String[] args) {
        ChatClient chatClient = new ChatClient();
        chatClient.start();
    }
}
