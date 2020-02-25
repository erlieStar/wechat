package com.javashitang.handler;

public enum EventTypes {

    SUBSCRIBE("subscribe"),
    UNSUBSCRIBE("unsubscribe"),
    CLICK("CLICK"),
    VIEW("VIEW");

    private String type;

    EventTypes(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
