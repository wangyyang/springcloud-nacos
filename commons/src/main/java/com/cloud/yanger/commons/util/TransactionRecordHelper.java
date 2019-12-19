package com.cloud.yanger.commons.util;

import com.cloud.yanger.commons.entity.TransactionRecord;

import java.util.Date;

public class TransactionRecordHelper {

    public static TransactionRecord create(double amount, int type, int busType, Integer accountType, int targetId, int userType, int status,
                                           String orderNumber, String remark, String params, String column, Date createTime) {
        TransactionRecord a = new TransactionRecord();
        a.setAmount(amount);//交易金额
        a.setType(type);//交易类型：0=支出；1=收入；2=退款；3=充值；4=提现
        a.setOrderNumber(orderNumber);//订单id
        a.setStatus(status);//交易状态: 0待处理 1通过 2未通过
        a.setTargetId(targetId);//服务商/普通会员id
        a.setUserType(userType);
        a.setBusType(busType);
        a.setRemark(remark);//交易内容
        a.setParams(params);
        a.setAccountType(accountType);
        a.setCheckColumn(EncryptUtils.MD5(column));//校验列（账户id+订单+交易金额+余额）组成校验串，防止篡改记录
        a.setCreateTime(createTime);//用于校验
        return a;
    }
}
