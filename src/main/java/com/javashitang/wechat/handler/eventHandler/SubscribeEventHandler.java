package com.javashitang.wechat.handler.eventHandler;

import com.javashitang.wechat.annotation.EventTypeHandler;
import com.javashitang.wechat.common.EnumDefine;
import com.javashitang.wechat.msg.event.InClickEvent;
import com.javashitang.wechat.msg.out.OutMsg;
import com.javashitang.wechat.msg.out.OutTextMsg;

import java.util.Map;

/**
 * 关注公众号时的事件
 */
@EventTypeHandler(EnumDefine.EVENT_TYPE.SUBSCRIBE)
public class SubscribeEventHandler implements EventHandler {

    @Override
    public OutMsg handlerEvent(Map<String, String> map) {
        InClickEvent inClickEvent = new InClickEvent(map);
        OutTextMsg outTextMsg = new OutTextMsg(inClickEvent);
        outTextMsg.setMsgType(EnumDefine.MSG_TYPE.TEXT.name());
        outTextMsg.setContent("感谢您的关注");
        return outTextMsg;
    }
}
