package com.cloud.yanger.commons.util;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;

public class CodeGenerateUtils {

    /**
     * 生成订单号
     *
     * @param type 类别
     * @param uid  用户ID
     */
    public static String getOrderNumber(int type, Integer uid) {
        if (uid != null) {
            String source;
            switch (type) {
                case 1://微信中生成的订单
                    source = "W";
                    break;
                case 2://APP中生成的订单
                    source = "A";
                    break;
                case 3://PC中生成的订单
                    source = "Z";
                    break;
                default://平台订单
                    source = "P";
                    break;
            }
            int rand = RandomUtils.nextInt(1000, 9999);
            String date = DateFormatUtils.format(new Date(), "yyMMddHHmmss");
            return String.format("%s%s%08d%03d", source, date, uid, rand);
        }
        return null;
    }

    public static String getWithdrawOrderNumber(int accountType) {
        if (accountType == 0)
            return "Z" + UUIDGeneratorUtils.getUUIDUpper().substring(0, 5) + System.currentTimeMillis();
        else
            return "W" + UUIDGeneratorUtils.getUUIDUpper().substring(0, 5) + System.currentTimeMillis();
    }

    /**
     * 自定义进制（选择你想要的进制数，不能重复且最好不要0、1、I、O这些容易混淆的字符）
     */
    private static final char[] r = new char[]{'x', '9', 'm', 'j', 'u', 'p', '5', 'k', '3', 'q', 'v', 'y', 't', 'n', '6', 'b', 'g', 'h', 'w', 'e', '8', 's', '2', 'a', 'z', 'f', 'c', '7', 'd', '4'};

    /**
     * 定义一个字符用来补全邀请码长度（该字符前面是计算出来的邀请码，后面是用来补全用的）
     */
    private static final char b = 'r';

    /**
     * 进制长度
     */
    private static final int binLen = r.length;

    /**
     * 邀请码长度
     */
    private static final int s = 6;

    /**
     * 根据ID生成六位随机码
     * 可支持最大728999999个id
     * @param id ID
     * @return 随机码
     */
    public static String getSerialCode(long id) {
        char[] buf = new char[32];
        int charPos = 32;

        while ((id / binLen) > 0) {
            int ind = (int) (id % binLen);
            buf[--charPos] = r[ind];
            id /= binLen;
        }
        buf[--charPos] = r[(int) (id % binLen)];
        String str = new String(buf, charPos, (32 - charPos));
        // 不够长度的自动随机补全
        if (str.length() < s) {
            StringBuilder sb = new StringBuilder();
            sb.append(b);
            for (int i = 1; i < s - str.length(); i++) {
                sb.append(r[RandomUtils.nextInt(0, binLen)]);
            }
            str += sb.toString();
        }
        return str;
    }

    /**
     * 根据随机码生成ID
     *
     * @param code 随机码
     * @return ID
     */
    public static long serialCodeToId(String code) {
        char chs[] = code.toCharArray();
        long res = 0L;
        for (int i = 0; i < chs.length; i++) {
            int ind = 0;
            for (int j = 0; j < binLen; j++) {
                if (chs[i] == r[j]) {
                    ind = j;
                    break;
                }
            }
            if (chs[i] == b) {
                break;
            }
            if (i > 0) {
                res = res * binLen + ind;
            } else {
                res = ind;
            }
        }
        return res;
    }
}
