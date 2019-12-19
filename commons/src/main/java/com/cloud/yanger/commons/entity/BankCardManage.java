package com.cloud.yanger.commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class BankCardManage {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer targetId;
    private Integer userType;
    private String cardName;
    private String cardNumber;
    private Integer cardType;
    private Date createTime;
}
