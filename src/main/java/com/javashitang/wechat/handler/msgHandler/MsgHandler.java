package com.javashitang.wechat.handler.msgHandler;

import com.javashitang.wechat.msg.out.OutMsg;

import java.util.Map;

public interface MsgHandler {

    OutMsg handlerMsg(Map<String, String> map);
}
