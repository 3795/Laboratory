package com.github.base.designPattern.mediationMode;

/**
 * 抽象中介类
 */
public abstract class AbstractChatroom {

    // 注册
    public abstract void register(Member member);
    // 发送文字
    public abstract void sendText(String from, String to, String message);
    // 发送图片
    public abstract void sendImage(String from, String to, String message);
}
