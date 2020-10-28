package com.github.base.io.bioDemo2.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 聊天室会话处理
 */
public class ChatHandler implements Runnable {

    private ChatServer server;

    private Socket socket;

    public ChatHandler(ChatServer server, Socket socket) {
        this.server = server;
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // 存储新加入的用户
            server.addClient(socket);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String msg = null;
            while ((msg = reader.readLine()) != null) {
                // 将该消息转发给其他用户
                String fwdMsg = "客户端[" + socket.getPort() + "]:" + msg + "\n";
                System.out.print(fwdMsg);
                server.forwardMessage(socket, fwdMsg);

                if (server.readyToQuit(msg)) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 将该客户端从注册表中删除
            server.removeClient(socket);
        }
    }
}
