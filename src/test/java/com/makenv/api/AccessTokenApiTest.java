package com.makenv.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.makenv.ui.Button;
import com.makenv.ui.Menu;
import org.junit.Test;

public class AccessTokenApiTest {


    /*
     刚开始测试jackson的读和写，后来在AccessToken对象加了date属性，AccessToken对象就不能直接序列化了
    @Test
    public void testRead() throws IOException {
        String result = "{\"access_token\":\"ACCESS_TOKEN\",\"expires_in\":7200}";
        ObjectMapper objectMapper = new ObjectMapper();
        AccessToken accessToken = objectMapper.readValue(result, AccessToken.class);
    }

    @Test
    public void testWrite() throws JsonProcessingException {
        AccessToken accessToken = new AccessToken("haha",10);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(accessToken);
        System.out.println(json);
    }*/

    @Test
    public void testUIComponent() throws JsonProcessingException {
        Menu menu = new Menu();
        Button button1 = new Button();
        button1.setName("woca");
        Button button2 = new Button();
        button1.setName("woca");
        Button button3 = new Button();
        button1.setName("woca");
        menu.setButton(new Button[] {button1, button2, button3});
        ObjectMapper objectMapper = new ObjectMapper();
        String str = objectMapper.writeValueAsString(menu);
        System.out.println(str);
    }
}
