package com.cloud.yanger.commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class Resume {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer userId;
    private String workStartTime;
    private String liveInProvince;
    private String liveInCity;
    private String liveInDistrict;
    private String liveInAddress;
    private Integer education;
    private Integer maritalStatus;
    private Integer expectedSalaryMin;
    private Integer expectedSalaryMax;
    private Integer expectedWorkType;
    private Integer jobSeekingStatus;
    private String selfIntroduction;
    private Integer withTattoo;
    private Integer withPassport;
    private Integer userSource;
    private Date createTime;
    private Date updateTime;
}
