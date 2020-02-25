package com.javashitang.util;

import java.security.MessageDigest;
import java.util.Arrays;

public class CheckUtil {

    /*
     * 微信校验的帮助类
     */

    public static String checkSignature(String token, String timeStamp, String nonce) {

        String[] arr = new String[]{token, timeStamp, nonce};

        //将token、timestamp、nonce三个参数进行字典序排序
        Arrays.sort(arr);

        //生成字符串
        StringBuffer sb = new StringBuffer();
        for (int i=0;i<arr.length;i++){
            sb.append(arr[i]);
        }

        //将三个参数字符串拼接成一个字符串进行sha1加密
        String temp = getSha1(sb.toString());

        return temp;

    }


    public static String getSha1(String str) {

        if (str == null || str.length() == 0) {
            return null;
        }
        char hexDigite[] = {'0','1','2','3','4','5','6','7','8','9','a',
                'b','c','d','e','f'};

        try {
            MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
            mdTemp.update(str.getBytes("UTF-8"));

            byte[] md = mdTemp.digest();
            int j = md.length;
            char buf[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++){
                byte byte0 = md[i];
                buf[k++] = hexDigite[byte0 >>> 4 & 0xf];
                buf[k++] = hexDigite[byte0 & 0xf];
            }
            return new String(buf);
        }catch (Exception e){
            return null;
        }
    }
}
