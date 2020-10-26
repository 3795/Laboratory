package com.github.base.designPattern.mediationMode;

/**
 * 具体同事类
 * 普通会员
 */
public class CommonMember extends Member {

    public CommonMember(String name) {
        super(name);
    }

    @Override
    public void sendText(String to, String message) {
        System.out.println("普通用户发送文字");
        chatroom.sendText(name, to, message);
    }

    @Override
    public void sendImage(String to, String image) {
        System.out.println("普通用户不能发图片");
    }

}
