package com.cloud.yanger.commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class ResumeOverseasExperience {
    @TableId(type = IdType.AUTO)
    private int id;
    private Integer rsmId;
    private String countryName;
    private String visaName;
    private Date createTime;
}
