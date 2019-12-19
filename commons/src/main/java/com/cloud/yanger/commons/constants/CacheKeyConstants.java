package com.cloud.yanger.commons.constants;

public class CacheKeyConstants {

    public static final String USER_LOGIN_WEBAPP_TOKEN_KEY = "users:webapp:user_token:";

    public static final String USER_LOGIN_PC_TOKEN_KEY = "users:pc:user_token:";

    public static final String USER_VERIFY_CODE_KEY = "users:verify_code:";

    public static final String USER_EMAIL_CODE_KEY = "users:email_code:";

    public static final String SYSTEM_CONFIG_KEY="commons:system_config_key:";

    public static final String SYSTEM_CONFIG_TABLE_KEY="commons:system_config_key:table:";
    //系统省市区
    public static final String SYSTEM_AREAS_KEY = "commons:system_areas:";
    //国外职位
    public static final String WORK_CATEGORY_FOREIGN_KEY="commons:work:category:foreign:";
    //国内热门搜索
    public static final String HOT_WORK_INLAND_KEY = "commons:hot:work:inland:";
    //国外热门搜索
    public static final String HOT_WORK_FOREIGN_KEY = "commons:hot:work:foreign:";
    //热门国家
    public static final String HOT_WORK_COUNTRY_KEY = "commons:hot:work:country:";
    //海外国家
    public static final String CONTINENT_COUNTRY = "commons:continent:country:";
    //海外地区
    public static final String CONTINENT_COUNTRY_ADDRESS = "commons:continent:country:address:";
    //签证库
    public static final String VISA_LIBRARY_KEY = "commons:visa:library:";
    //语言库及其能力等级
    public static final String LANGUAGE_TAGS_KEY="commons:language:tags:";
    //消息锁
    public static final String MSG_LOCK = "commons:lock:msg:";
    //常用语
    public static final String CHAT_PHRASE_KEY = "commons:chat_phrase";

    /**
     * 职位招聘结束
     */
    public static final String JOB_AUTO_REFERRALS = "job:auto_referrals:@";
    /**
     * 职位预计出结果
     */
    public static final String JOB_INTER_RESULT_EXPIRE_KEY = "job:job_inter_result_expire:@";

    public static final String JOB_INTER_OVERSTEP_RESULT_TIME = "job:job_inter_overstep_result_time:@";
    /**
     * 面试违约
     */
    public static final String ORDER_VIOLATE_TREATY = "orders:violate_treaty:@";
    /**
     * 自动发送短信提醒求职者
     */
    public static final String ORDER_AUTO_SEND_SMG_TO_JOB_SEEKER = "order:auto_send_smg:job_seeker:@";


    public final static String SLIDING_VERIFY_KEY = "member:sliding_verify:";

    /* 运营后台 */
    /**
     * 用户登录token
     */
    public static final String USER_LOGIN_ADMIN_TOKEN_KEY = "users:admin:user_token:";

    /**
     * 用户审批权限
     */
    public static final String USER_LOGIN_ADMIN_AP_KEY = "users:admin:ap_config:";
}
