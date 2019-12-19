package com.cloud.yanger.commons.constants;

import com.cloud.yanger.commons.util.MapUtils;

import java.util.Map;

public class OrdersStatusConstants {

    //面试•等待
    public static final int INTERVIEW_AWAIT = 0;
    //面试•未通过
    public static final int INTERVIEW_NOT_PASS = 1;
    //面试•未到场
    public static final int INTERVIEW_NOT_PRESENT = 2;
    //面试•通过
    public static final int INTERVIEW_PASS = 3;
    //签证·二期款待支付
    public static final int VISA_SECOND_PAY_AWAI = 4;
    //签证·二期款已支付
    public static final int VISA_SECOND_PAY_SUCCEED = 5;
    //签证·尾款待支付
    public static final int VISA_FINAL_PAY_AWAT = 6;
    //签证·尾款已支付
    public static final int VISA_FINAL_PAY_SUCCEED = 7;
    //签证批复·申请解冻资金
    public static final int VISA_REPLY_THAW_FUNDS_AWAT = 8;
    //签证批复·确认解冻资金
    public static final int VISA_REPLY_THAW_FUNDS_SUCCEED = 9;
    //出境·申请出境
    public static final int PARTIDA_LEAVE_COUNTRY_AWAT = 10;
    //出境·已出境
    public static final int PARTIDA_LEAVE_COUNTRY_REPLY=11;
    //出境·出境不通过
    public static final int PARTIDA_LEAVE_COUNTRY_NO_PASS=12;
    //退款·审核中
    public static final int REFUND_AUDIT = 13;
    //退款·企业审核成功
    public static final int REFUND_FAC_SUCCEED = 14;
    //退款·企业审核拒绝
    public static final int REFUND_FAC_FAILED = 15;
    //面试•未到场申诉中
    public static final int INTERVIEW_NOT_PRESENT_AWAT = 16;
    //面试•未到场申诉成功
    public static final int INTERVIEW_NOT_PRESENT_PASS = 17;
    //面试•未到场申诉失败
    public static final int INTERVIEW_NOT_PRESENT_FAILED = 18;
    //退款·取消
    public static final int REFUND_CANCEL = 19;
    //解冻一期款
    public static final int DEFROST_INTERVIEW_GUARANTEE = 20;
    //删除订单
    public static final int ORDER_DELETE = 21;

    private static Map<Integer, String> constants;

    static {
        constants = MapUtils.create(
                INTERVIEW_AWAIT, "面试·等待",
                INTERVIEW_NOT_PASS, "面试·未通过",
                INTERVIEW_NOT_PRESENT, "面试·未到场",
                INTERVIEW_PASS, "面试·通过",
                VISA_SECOND_PAY_AWAI, "签证·二期款待支付",
                VISA_SECOND_PAY_SUCCEED, "签证·二期款已支付",
                VISA_FINAL_PAY_AWAT, "签证·尾款待支付",
                VISA_FINAL_PAY_SUCCEED, "签证·尾款已支付",
                VISA_REPLY_THAW_FUNDS_AWAT, "签证批复·资金待解冻",
                VISA_REPLY_THAW_FUNDS_SUCCEED, "签证批复·资金已解冻",
                PARTIDA_LEAVE_COUNTRY_AWAT, "出境·申请出境",
                PARTIDA_LEAVE_COUNTRY_REPLY, "出境·已出境",
                PARTIDA_LEAVE_COUNTRY_NO_PASS, "出境·出境不通过",
                REFUND_AUDIT, "退款·审核中",
                REFUND_FAC_SUCCEED, "退款·审核成功",
                REFUND_FAC_FAILED, "退款·审核拒绝",
                INTERVIEW_NOT_PRESENT_AWAT,"面试•未到场申诉中",
                INTERVIEW_NOT_PRESENT_PASS, "面试•未到场申诉通过",
                INTERVIEW_NOT_PRESENT_FAILED, "面试•未到场申诉不通过",
                REFUND_CANCEL, "退款·取消",
                DEFROST_INTERVIEW_GUARANTEE, "解冻一期款",
                ORDER_DELETE, "删除订单"
        );
    }

    public static String name(Integer id) {
        return constants.get(id);
    }
}
