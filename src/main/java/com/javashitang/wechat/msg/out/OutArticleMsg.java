package com.javashitang.wechat.msg.out;

import com.javashitang.wechat.msg.in.InMsg;

public class OutArticleMsg extends OutMsg{

    private String title;
    private String description;
    private String picurl;
    private String url;

    public OutArticleMsg(InMsg inMsg) {
        super(inMsg);
    }

    @Override
    public String toString() {
        String template = "<xml>\n" +
                "<ToUserName><![CDATA[toUser]]></ToUserName>\n" +
                "<FromUserName><![CDATA[fromUser]]></FromUserName>\n" +
                "<CreateTime>createTime</CreateTime>\n" +
                "<MsgType><![CDATA[msgType]]></MsgType>\n" +
                "<ArticleCount>1</ArticleCount>\n" +
                "<Articles>\n" +
                "<item>\n" +
                "<Title><![CDATA[title]]></Title> \n" +
                "<Description><![CDATA[description]]></Description>\n" +
                "<PicUrl><![CDATA[picurl]]></PicUrl>\n" +
                "<Url><![CDATA[url]]></Url>\n" +
                "</item>\n" +
                "</Articles>\n" +
                "</xml>";
        String xmlStr = template.replace("toUser", toUserName)
                .replace("fromUser", fromUserName)
                .replace("createTime", createTime)
                .replace("msgType", msgType)
                .replace("title", title)
                .replace("description", description)
                .replace("picurl", picurl)
                .replace("url", url);
        return xmlStr;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}