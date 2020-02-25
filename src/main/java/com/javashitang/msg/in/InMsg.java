package com.javashitang.msg.in;

import java.util.Map;

public abstract class InMsg {

    protected String toUserName;
    protected String fromUserName;
    protected long createTime;
    protected String msgType;

    public InMsg(Map<String, String> map) {
        this.toUserName = map.get("ToUserName");
        this.fromUserName = map.get("FromUserName");
        this.createTime = Long.parseLong(map.get("CreateTime"));
        this.msgType = map.get("MsgType");
    }

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }
}
