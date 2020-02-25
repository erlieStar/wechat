package com.javashitang.api;

import com.javashitang.util.ResponseUtil;

public class MenuApi {

    /*
     * 菜单创建接口
     */

    public static String CREATE_MENU = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

    public static void createMenu(String accessToken, String params) {
        CREATE_MENU  = CREATE_MENU.replace("ACCESS_TOKEN", accessToken);
        ResponseUtil.sendPost(CREATE_MENU, params);
    }
}
