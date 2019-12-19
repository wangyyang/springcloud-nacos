package com.cloud.yanger.commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class OrderDetails {
    @TableId(type = IdType.AUTO)
    private int id;
    private Integer orderId;
    private Integer facId;
    private Integer jobId;
    private Integer status;
    private String remark;
    private Date createTime;
    private Integer modifier;
    private Date modifyTime;
}
