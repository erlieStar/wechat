package com.javashitang.wechat.handler.eventHandler;

import com.javashitang.wechat.common.EnumDefine;
import com.javashitang.wechat.msg.event.InClickEvent;
import com.javashitang.wechat.msg.out.OutMsg;
import com.javashitang.wechat.msg.out.OutTextMsg;

import java.util.Map;

public class ClientEventHandler implements EventHandler {

    @Override
    public OutMsg handlerEvent(Map<String, String> map) {
        InClickEvent inClickEvent = new InClickEvent(map);
        String eventKey = inClickEvent.getEventKey();
        OutMsg outMsg = null;
        if (eventKey.equals("button1")) {
            OutTextMsg outTextMsg = new OutTextMsg(inClickEvent);
            outTextMsg.setMsgType(EnumDefine.MSG_TYPE.TEXT.getName());
            outTextMsg.setContent("抓紧筹备中");
            outMsg = outTextMsg;
        }
        return outMsg;
    }
}
