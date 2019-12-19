package com.cloud.yanger.commons.constants;

public class ExecMessageConstants {
    public static final int ORDER_AUTO_SEND_SMG_TO_JOB_SEEKER = 1;//订单-自动发送短信提醒求职者
    public static final int ORDER_AUTO_REFUND_TO_WALLET = 2;//订单-自动退款到用户钱包
    public static final int ORDER_VIOLATE_TREATY = 3;//订单-面试违约未到场
    public static final int JOB_AUTO_FINISH = 4;//职位-自动停止招聘
    public static final int JOB_INTER_RESULT = 5;//职位-面试出结果几天自动给结果
    public static final int CHAT_EXPIRED = 6;//聊天信息过期存储到服务器中
    public static final int JOB_INTER_OVERSTEP_RESULT_TIME = 7;//超过预计出面试结果时间


    public static final String CHANNEL_ORDER_NAME = "channel_order";
}
