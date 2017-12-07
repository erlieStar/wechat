package com.makenv.view;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.makenv.api.AccessTokenApi;
import com.makenv.api.IdAndSecretApi;
import com.makenv.api.MenuApi;
import com.makenv.bean.AccessToken;
import com.makenv.ui.*;

import java.io.IOException;

public class MenuManager {

    public static void createMenu() throws IOException {

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
        AccessToken accessToken = null;
        accessToken = AccessTokenApi.getAccessToken(IdAndSecretApi.appID, IdAndSecretApi.appSecret);
        String token = accessToken.getAccessToken();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(menu);
        MenuApi.createMenu(token, json);
    }
}
