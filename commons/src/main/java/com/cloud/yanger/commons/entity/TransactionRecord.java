package com.cloud.yanger.commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class TransactionRecord {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer type;
    private Integer targetId;
    private Integer userType;//0用户1服务商
    private Double amount;
    private String orderNumber;
    private Integer accountType;
    private Double serviceCharge;
    private Integer status;
    private Integer busType;
    private String remark;
    private String params;
    private String checkColumn;
    private Date createTime;
    private Date updateTime;
}
