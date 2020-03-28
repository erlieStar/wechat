package com.javashitang.wechat.handler.msgHandler;

import com.javashitang.wechat.annotation.MsgTypeHandler;
import com.javashitang.wechat.common.EnumDefine;
import com.javashitang.wechat.msg.in.InTextMsg;
import com.javashitang.wechat.msg.out.OutMsg;
import com.javashitang.wechat.msg.out.OutTextMsg;

import java.util.Map;

@MsgTypeHandler(EnumDefine.MSG_TYPE.TEXT)
public class TextMsgHandler implements MsgHandler {

    @Override
    public OutMsg handlerMsg(Map<String, String> map) {
        InTextMsg inTextMsg = new InTextMsg(map);
        OutTextMsg outTextMsg = new OutTextMsg(inTextMsg);
        outTextMsg.setMsgType(EnumDefine.MSG_TYPE.TEXT.name());
        outTextMsg.setContent("感谢您的留言，欢迎提供更好的意见或建议");
        return outTextMsg;
    }
}
