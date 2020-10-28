package com.github.base.io.nioDemo.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 处理用户输入
 */
public class UserInputHandler implements Runnable {

    private ChatClient chatClient;

    public UserInputHandler(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @Override
    public void run() {
        try {
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                String input = consoleReader.readLine();
                // 向服务器发送消息
                chatClient.send(input);

                if (chatClient.readyToQuit(input)) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
