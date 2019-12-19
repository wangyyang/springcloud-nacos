package com.cloud.yanger.commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class Facilitator {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer userId;
    private String logo;
    private Integer type;
    private String workDate;
    private String licenseImg;
    private String companyName;
    private String companyShortName;
    private String companyProvince;
    private String companyCity;
    private String companyDistrict;
    private String companyAddress;
    private String companyPhone;
    private String legalName;
    private String legalIdCard;
    private String legalCardImg;
    private Date cardStartTime;
    private Date cardEndTime;
    private String companyProfiles;
    private String cooperationImg;
    private String companyEnvironmentVideo;
    private String sendQualificationImg;
    private Date qualificationStartTime;
    private Date qualificationEndTime;
    private Integer status;
    private Date createTime;
}
