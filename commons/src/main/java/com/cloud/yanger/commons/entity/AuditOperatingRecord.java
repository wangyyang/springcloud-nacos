package com.cloud.yanger.commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class AuditOperatingRecord {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer targetType;
    private Integer targetId;
    private Integer status;
    private String remark;
    private Integer operatorId;
    private Date createTime;
}
