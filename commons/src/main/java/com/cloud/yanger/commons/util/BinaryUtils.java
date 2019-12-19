package com.cloud.yanger.commons.util;

import java.math.BigInteger;

public class BinaryUtils {
    /**
     * 十进制转换成二进制 ()
     */
    public static String decimalToBinary(int decimalSource) {
        BigInteger bi = new BigInteger(String.valueOf(decimalSource));    //转换成BigInteger类型
        return bi.toString(2);    //参数2指定的是转化成X进制，默认10进制
    }

    /**
     * 二进制转换成十进制
     */
    public static int binaryToDecimal(String binarySource) {
        BigInteger bi = new BigInteger(binarySource, 2);    //转换为BigInteger类型
        return Integer.parseInt(bi.toString());        //转换成十进制
    }
}
