package com.liaoyb.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author ybliao2
 */
public class MD5Util {
    public static String MD5(String str){
        if(str==null)
            return str;
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        try {
            byte[]bytes=str.getBytes();
            MessageDigest messageDigest=MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            messageDigest.update(bytes);

            //获得密文
            byte[]md=messageDigest.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char chars[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                chars[k++] = hexDigits[byte0 >>> 4 & 0xf];
                chars[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(chars);


        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }

    }
}
