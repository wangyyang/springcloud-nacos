package com.cloud.yanger.commons.util;

import java.security.MessageDigest;

public class EncryptUtils {

    /**
     * MD5加密
     */
    public static String MD5(String s) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        if (s == null || s.equals("")) {
            return "";
        }
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String encryptName(String name) {
        if (name != null && name.length() > 1) {
            StringBuilder sb = new StringBuilder(name);
            int s = name.length() - 2;
            if (s <= 0) s = 1;
            for (int i = 1; i <= s; i++) {
                sb.setCharAt(i, '※');
            }
            return sb.toString();
        }
        return null;
    }
}
