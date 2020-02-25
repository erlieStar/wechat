package com.javashitang.msg.event;

import java.util.Map;

public class InClickEvent extends InEvent{

    /*
     * 自定义菜单事件
     */
    private String eventKey;

    public InClickEvent(Map<String, String> map) {
        super(map);
        this.eventKey = map.get("EventKey");
    }

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        eventKey = eventKey;
    }
}
