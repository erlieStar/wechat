package com.makenv.controller;

import com.makenv.handler.DefaultHandler;
import com.makenv.util.CheckUtil;
import com.makenv.util.XMLUtil;
import org.dom4j.DocumentException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Map;

@Controller
@RequestMapping("server")
public class WeChatController {

    /*
     * 微信公众号服务器
     */

    private final String token = "erlie";

    @GetMapping("system")
    public void doGet(HttpServletRequest request, HttpServletResponse response) {

        //获取参数值
        String signature = request.getParameter("signature");
        String timeStamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");

        PrintWriter out = null;
        try {
            out = response.getWriter();
            //开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
            if (CheckUtil.checkSignature(token, timeStamp, nonce).equals(signature)) {
                //作出响应，即原样返回随机字符串
                out.println(echostr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            out.close();
        }
    }

    @PostMapping("system")
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, DocumentException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        Map<String, String> map = XMLUtil.xml2Map(request);
        PrintWriter out = response.getWriter();
        DefaultHandler defaultHandler = new DefaultHandler();
        String msg = defaultHandler.handler(map);
        out.println(msg);
        out.close();
    }

}
