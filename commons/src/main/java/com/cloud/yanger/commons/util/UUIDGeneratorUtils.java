package com.cloud.yanger.commons.util;

import java.util.UUID;

public class UUIDGeneratorUtils {

    private UUIDGeneratorUtils() {
    }

    /**
     * 获取32位UUID
     */
    public static String get32UUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static String getUUIDUpper() {
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }

    public static String getUUIDLower() {
        return UUID.randomUUID().toString().replace("-", "").toLowerCase();
    }
}
