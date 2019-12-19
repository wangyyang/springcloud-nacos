package com.cloud.yanger.commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class ResumeMedicalRecords {
    @TableId(type = IdType.AUTO)
    private int id;
    private Integer rsmId;
    private String remark;
    private Date createTime;
}
