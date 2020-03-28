package com.javashitang.wechat.handler;

import com.javashitang.wechat.msg.event.InClickEvent;
import com.javashitang.wechat.msg.event.InSubscribeEvent;
import com.javashitang.wechat.msg.in.InImageMsg;
import com.javashitang.wechat.msg.in.InLinkMsg;
import com.javashitang.wechat.msg.in.InTextMsg;
import com.javashitang.wechat.msg.out.OutMsg;
import com.javashitang.wechat.msg.out.OutTextMsg;

public class DefaultHandler extends MsgHandler{

    @Override
    protected OutMsg handlerTextMsg(InTextMsg inTextMsg) {
        OutTextMsg outTextMsg = new OutTextMsg(inTextMsg);
        outTextMsg.setMsgType(MsgTypes.TEXT.getType());
        outTextMsg.setContent("感谢您的留言，欢迎提供更好的意见或建议");
        return outTextMsg;
    }

    @Override
    protected OutMsg handlerLinkMsg(InLinkMsg inLinkMsg) {
        return null;
    }

    @Override
    protected OutMsg handlerImageMsg(InImageMsg inImageMsg) {
        return null;
    }

    @Override
    protected OutMsg handlerClickEvent(InClickEvent inClickEvent) {
        String eventKey = inClickEvent.getEventKey();
        OutMsg outMsg = null;
        if (eventKey.equals("button1")) {
            OutTextMsg outTextMsg = new OutTextMsg(inClickEvent);
            outTextMsg.setMsgType(MsgTypes.TEXT.getType());
            outTextMsg.setContent("抓紧筹备中");
            outMsg = outTextMsg;
        }
        return outMsg;
    }

    @Override
    protected OutMsg handlerViewEvent(InClickEvent inClickEvent) {
        return null;
    }

    //关注公众号时的事件
    @Override
    protected OutMsg handlerSubscribeEvent(InSubscribeEvent inSubscribeEvent) {

        OutTextMsg outTextMsg = new OutTextMsg(inSubscribeEvent);
        outTextMsg.setMsgType(MsgTypes.TEXT.getType());
        outTextMsg.setContent("感谢您的关注");
        return outTextMsg;
    }
}
