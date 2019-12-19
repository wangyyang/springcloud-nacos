package com.cloud.yanger.commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class OrderOperatingRecord {
    @TableId(type = IdType.AUTO)
    private int id;
    private Integer orderId;
    private Integer status;
    private Integer reason;
    private String evidenceFile;
    private String remark;
    private Integer operatorId;
    private Date createTime;
}
