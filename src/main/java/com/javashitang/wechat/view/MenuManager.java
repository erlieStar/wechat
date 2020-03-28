package com.javashitang.wechat.view;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javashitang.wechat.service.inf.AccessTokenService;
import com.javashitang.wechat.service.inf.MenuService;
import com.javashitang.wechat.ui.*;
import com.javashitang.wechat.domain.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Component
public class MenuManager {

    @Autowired
    private AccessTokenService accessTokenService;

    @Autowired
    private MenuService menuService;

    @PostConstruct
    public void createMenu() throws IOException {

        ViewButton viewButton = new ViewButton();
        viewButton.setName("北京PM2.5");
        viewButton.setType("view");
        viewButton.setUrl("http://www.86pm25.com/city/beijing.html");
        ComplexButton complexButton = new ComplexButton();
        complexButton.setName("小工具");
        complexButton.setSub_button(new Button[] {viewButton});

        ClickButton clickButton2 = new ClickButton();
        clickButton2.setName("获取书单");
        clickButton2.setType("click");
        clickButton2.setKey("button1");

        ViewButton viewButton1 = new ViewButton();
        viewButton1.setName("个人网站");
        viewButton1.setType("view");
        viewButton1.setUrl("http://www.erlie.cc");
        ComplexButton complexButton1 = new ComplexButton();
        complexButton1.setName("关于作者");
        complexButton1.setSub_button(new Button[] {viewButton1});
        Menu menu = new Menu();
        menu.setButton(new Button[] {complexButton, clickButton2, complexButton1});
        AccessToken accessToken = accessTokenService.getAccessToken();
        String token = accessToken.getAccessToken();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(menu);
        menuService.createMenu(token, json);
    }
}
