package com.makenv.msg.out;

import com.makenv.msg.in.InMsg;

public class OutTextMsg extends OutMsg{

    private String content;

    public OutTextMsg(InMsg inMsg) {
        super(inMsg);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        String template = "<xml>\n" +
                "<ToUserName><![CDATA[toUser]]></ToUserName>\n" +
                "<FromUserName><![CDATA[fromUser]]></FromUserName>\n" +
                "<CreateTime>createTime</CreateTime>\n" +
                "<MsgType><![CDATA[msgType]]></MsgType>\n" +
                "<Content><![CDATA[content]]></Content>\n" +
                "</xml>";

        String xmlStr = template.replace("toUser", toUserName)
                .replace("fromUser", fromUserName)
                .replace("createTime", createTime)
                .replace("msgType", msgType)
                .replace("content", content);
        return xmlStr;
    }
}
