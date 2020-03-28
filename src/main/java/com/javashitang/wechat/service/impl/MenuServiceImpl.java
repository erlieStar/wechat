package com.javashitang.wechat.service.impl;

import com.javashitang.wechat.common.StaticProperties;
import com.javashitang.wechat.common.WechatConfig;
import com.javashitang.wechat.service.inf.MenuService;
import com.javashitang.wechat.util.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private WechatConfig wechatConfig;

    @Override
    public void createMenu(String accessToken, String param) {
        String url = StaticProperties.CREATE_MENU_URL.replace("ACCESS_TOKEN", accessToken);
        HttpUtil.sendPost(url, param);
    }
}
