package com.makenv.msg;

import com.makenv.msg.in.InTextMsg;
import com.makenv.msg.out.OutTextMsg;
import com.thoughtworks.xstream.XStream;

import java.util.HashMap;
import java.util.Map;

public class MsgTest {

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        InTextMsg inTextMsg = new InTextMsg(map);
        inTextMsg.setFromUserName("from");
        inTextMsg.setToUserName("to");
        OutTextMsg outTextMsg = new OutTextMsg(inTextMsg);
        outTextMsg.setMsgType("haha");
        XStream xStream = new XStream();
        xStream.alias("xml", outTextMsg.getClass());
        String msg = xStream.toXML(outTextMsg);
        System.out.println(msg);

//        XStream xStream = new XStream();
//        xStream.alias("xml", InTextMsg.class);
//        InTextMsg inTextMsg = (InTextMsg)xStream.fromXML("<xml>" +
//                " <ToUserName>hahd</ToUserName>" +
//                " <FromUserName>dafds</FromUserName>" +
//                " <CreateTime>1348831860</CreateTime>" +
//                " <MsgType>text</MsgType>" +
//                " <Content>content</Content>" +
//                " <MsgId>1234567890123456</MsgId>" +
//                " </xml>");
//        System.out.println("haha");
    }
}
