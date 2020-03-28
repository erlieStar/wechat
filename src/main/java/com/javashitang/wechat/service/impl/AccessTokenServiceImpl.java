package com.javashitang.wechat.service.impl;

import com.javashitang.wechat.common.StaticProperties;
import com.javashitang.wechat.common.WechatConfig;
import com.javashitang.wechat.domain.AccessToken;
import com.javashitang.wechat.service.inf.AccessTokenService;
import com.javashitang.wechat.util.JsonUtil;
import com.javashitang.wechat.util.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccessTokenServiceImpl implements AccessTokenService {

    @Autowired
    private WechatConfig wechatConfig;

    public AccessToken getAccessToken() {
        String url = StaticProperties.ACCESS_TOKEN_URL.replace("${APPID}", wechatConfig.getAppID())
                .replace("${APPSECRET}", wechatConfig.getAppSecret());
        String result = HttpUtil.sendGet(url, url);
        AccessToken accessToken = JsonUtil.string2Obj(result, AccessToken.class);
        return accessToken;
    }
}
