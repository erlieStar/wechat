package com.makenv.msg.event;

import com.makenv.msg.in.InMsg;

import java.util.Map;

public class InSubscribeEvent extends InMsg{

    /*
     * 关注/取消事件
     */
    public InSubscribeEvent(Map<String, String> map) {
        super(map);
    }

}
