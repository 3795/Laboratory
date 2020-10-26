package com.github.base.designPattern.mediationMode;

import java.util.Hashtable;

/**
 * 聊天室
 * 具体中介者
 */
public class ChatGroup extends AbstractChatroom {

    private Hashtable<String, Member> members = new Hashtable<>();

    @Override
    public void register(Member member) {
        if (!members.contains(member)) {
            members.put(member.getName(), member);
            member.setChatroom(this);
        }
    }

    @Override
    public void sendText(String from, String to, String message) {
        Member member = members.get(to);
        checkMemberExists(member);
        message = message.replaceAll("狗", "*");
        member.receiveText(from, message);
    }

    @Override
    public void sendImage(String from, String to, String image) {
        Member member= members.get(to);
        checkMemberExists(member);
        if(image.length()>5)
        {
            System.out.println("图片太大，发送失败！");
        }
        else
        {
            member.receiveImage(from,image);
        }
    }

    /**
     * 检测Member是否在线
     * @param member
     */
    private void checkMemberExists(Member member) {
        if (member == null) {
            System.out.println("该用户不存在");
            return;
        }
    }
}
