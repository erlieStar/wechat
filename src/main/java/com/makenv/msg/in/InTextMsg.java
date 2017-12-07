package com.makenv.msg.in;

import java.util.Map;

public class InTextMsg extends InMsg{

    private String content;
    private long msgId;

    public InTextMsg(Map<String, String> map) {
        super(map);
        this.content = map.get("Content");
        this.msgId = Long.parseLong(map.get("MsgId"));
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getMsgId() {
        return msgId;
    }

    public void setMsgId(long msgId) {
        this.msgId = msgId;
    }
}
