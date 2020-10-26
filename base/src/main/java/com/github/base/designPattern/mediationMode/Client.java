package com.github.base.designPattern.mediationMode;

public class Client {

    public static void main(String[] args) {
        Member tom = new CommonMember("Tom");
        Member jarry = new DiamondMember("Jarry");
        AbstractChatroom chatroom = new ChatGroup();

        chatroom.register(tom);
        chatroom.register(jarry);

//        tom.sendText("Jarry", "Hello Jarry，你喜欢小狗狗吗");
//        tom.sendImage("Jarry", "好看的图片");

        jarry.sendText("Tom", "你好");
        jarry.sendImage("tom", "这是一张很好看的图片");
    }
}
