package com.javashitang.wechat.handler;

import com.javashitang.wechat.msg.event.InClickEvent;
import com.javashitang.wechat.msg.event.InSubscribeEvent;
import com.javashitang.wechat.msg.in.InImageMsg;
import com.javashitang.wechat.msg.in.InLinkMsg;
import com.javashitang.wechat.msg.in.InTextMsg;
import com.javashitang.wechat.msg.out.OutMsg;

import java.util.Map;

public abstract class MsgHandler {

    public String handler(Map<String, String> map) {

        String msgType = map.get("MsgType");
        OutMsg outMsg = null;
        if (msgType.equals(MsgTypes.TEXT.getType())) {
            InTextMsg inTextMsg = new InTextMsg(map);
            outMsg = handlerTextMsg(inTextMsg);
        } else if (msgType.equals(MsgTypes.LINK.getType())) {
            InLinkMsg inLinkMsg = new InLinkMsg(map);
            outMsg = handlerLinkMsg(inLinkMsg);
        } else if (msgType.equals(MsgTypes.IMAGE.getType())) {
            InImageMsg inImageMsg = new InImageMsg(map);
            outMsg = handlerImageMsg(inImageMsg);
        } else if (msgType.equals(MsgTypes.EVENT.getType())) {
            String eventType = map.get("Event");
            if (eventType.equals(EventTypes.SUBSCRIBE.getType())) {
                InSubscribeEvent inSubscribeEvent = new InSubscribeEvent(map);
                outMsg = handlerSubscribeEvent(inSubscribeEvent);
            } else if (eventType.equals(EventTypes.CLICK.getType())) {
                InClickEvent inClickEvent = new InClickEvent(map);
                outMsg = handlerClickEvent(inClickEvent);
            } else if (eventType.equals(EventTypes.VIEW.getType())) {
                InClickEvent inClickEvent = new InClickEvent(map);
                outMsg = handlerViewEvent(inClickEvent);
            }
        }
        return outMsg == null ? "" : outMsg.toString();
    }

    protected abstract OutMsg handlerTextMsg(InTextMsg inTextMsg);
    protected abstract OutMsg handlerLinkMsg(InLinkMsg inLinkMsg);
    protected abstract OutMsg handlerImageMsg(InImageMsg inImageMsg);
    //点击菜单拉取消息时的事件推送
    protected abstract OutMsg handlerClickEvent(InClickEvent inClickEvent);
    //点击菜单跳转链接时的事件推送,因为消息类型和InClickEvent类结构相同，所以没有单独建一个类
    protected abstract OutMsg handlerViewEvent(InClickEvent inClickEvent);
    //关注公众号时的事件
    protected abstract OutMsg handlerSubscribeEvent(InSubscribeEvent inSubscribeEvent);
}
