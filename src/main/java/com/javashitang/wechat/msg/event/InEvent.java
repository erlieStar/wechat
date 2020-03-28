package com.javashitang.wechat.msg.event;

import com.javashitang.wechat.msg.in.InMsg;

import java.util.Map;

public class InEvent extends InMsg{

    /*
     * 事件类型的基类
     */

    private String Event;

    public InEvent(Map<String, String> map) {
        super(map);
        this.Event = map.get("Event");
    }

    public String getEvent() {
        return Event;
    }

    public void setEvent(String event) {
        Event = event;
    }
}
