package com.javashitang.wechat.handler.eventHandler;

import com.javashitang.wechat.msg.out.OutMsg;

import java.util.Map;

public interface EventHandler {

    OutMsg handlerEvent(Map<String, String> map);
}
