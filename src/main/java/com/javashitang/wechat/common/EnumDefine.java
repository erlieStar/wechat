package com.javashitang.wechat.common;

public class EnumDefine {

    public static enum EVENT_TYPE {

        SUBSCRIBE("subscribe"),
        UNSUBSCRIBE("unsubscribe"),
        CLICK("click"),
        VIEW("view");

        private final String name;

        EVENT_TYPE(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static enum MSG_TYPE {

        TEXT("text"),
        IMAGE("image"),
        VOICE("voice"),
        VIDEO("video"),
        MINI_VIDEO("mini_video"),
        LINK("link");

        private final String name;

        MSG_TYPE(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}