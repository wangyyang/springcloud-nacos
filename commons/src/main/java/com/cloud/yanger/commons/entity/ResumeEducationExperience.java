package com.cloud.yanger.commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class ResumeEducationExperience {
    @TableId(type = IdType.AUTO)
    private int id;
    private Integer rsmId;
    private String schoolName;
    private String major;
    private Integer education;
    private Integer associateEnrolled;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date startTime;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date endTime;
    private Date createTime;
    private Date updateTime;
}
