package com.cloud.yanger.commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class JobOperatingRecord {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer jobId;
    private Integer status;
    private Integer boutique;
    private String remark;
    private Integer operatorId;
    private Date createTime;
}
