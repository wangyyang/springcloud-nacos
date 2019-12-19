package com.cloud.yanger.commons.constants;

import com.cloud.yanger.commons.util.MapUtils;

import java.util.Map;

public class JobStatusConstants {

    //草稿
    public static final int PRESERVE = 0;
    //审核中
    public static final int AUDIT_PROGRESS = 1;
    //招聘中
    public static final int RECRUITMENT = 2;
    //审核未通过
    public static final int AUDIT_NOT_PASS = 3;
    //暂停招聘
    public static final int PAUSE_RECRUITMENT = 4;
    //结束招聘
    public static final int END_RECRUITMENT = 5;
    //培训中
    public static final int TRAINING = 6;
    //已出境
    public static final int OUTBOUND = 7;
    //删除
    public static final int DELETE = 8;


    private static Map<Integer, String> constants;

    static {
        constants = MapUtils.create(
                PRESERVE, "草稿",
                AUDIT_PROGRESS, "审核中",
                RECRUITMENT, "招聘中",
                AUDIT_NOT_PASS, "审核未通过",
                PAUSE_RECRUITMENT, "暂停招聘",
                END_RECRUITMENT, "结束招聘",
                TRAINING, "培训中",
                OUTBOUND, "已出境",
                DELETE, "删除"
        );
    }

    public static String name(Integer id) {
        return constants.get(id);
    }
}
