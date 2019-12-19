package com.cloud.yanger.commons.constants;

import com.cloud.yanger.commons.util.MapUtils;

import java.util.Map;

public class EducationConstants {
    private static Map<Integer, String> constants = null;

    static {
        constants = MapUtils.create(
                0, "小学",
                1, "初中",
                2, "高中/中专",
                3,"大专",
                4,"大学本科",
                5,"研究生/硕士",
                6,"博士及以上"
        );
    }

    public static String name(Integer id) {
        return constants.get(id);
    }
}
