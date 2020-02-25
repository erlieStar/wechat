package com.javashitang.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javashitang.bean.AccessToken;
import com.javashitang.util.ResponseUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AccessTokenApi {

    /*
     * 获取access_token的api，以get方式发送https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET
     * 返回的json格式如下{"access_token":"ACCESS_TOKEN","expires_in":7200}
     */
    public static final String URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

    public static AccessToken getAccessToken(String appId, String appSecret) throws IOException {
        String url = URL.replace("APPID", appId).replace("APPSECRET", appSecret);
        String[] temp = url.split("\\?");
        String result = ResponseUtil.sendGet(temp[0], temp[1]);

        ObjectMapper objectMapper = new ObjectMapper();

        Map map = objectMapper.readValue(result, HashMap.class);
        String value1 = (String)map.get("access_token");
        int value2 = (Integer)map.get("expires_in");
        AccessToken accessToken = new AccessToken((String)map.get("access_token"), (Integer) map.get("expires_in"));

        return accessToken;
    }
}
