package com.cloud.yanger.commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class TradeInfo {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String orderNumber;
    private Integer accountType;
    private Integer targetId;
    private Integer userType;
    private Double amount;
    private Integer status;
    private Integer type;
    private Double serviceCharge;
    private Integer busType;
    private String busObject;
    private Date toaccTime;
    private Date createTime;

}
