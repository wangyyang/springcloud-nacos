package com.cloud.yanger.commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class Job {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer facId;
    private Integer userId;
    private String jobName;
    private Integer continent;
    private Integer country;
    private Integer region;
    private Integer wageMin;
    private Integer wageMax;
    private Integer basePay;
    private Integer payPeriods;
    private Integer yearWageMin;
    private Integer yearWageMax;
    private Integer visaId;
    private Integer workExper;
    private Integer education;
    private Integer languageId;
    private Integer abilityGradeId;
    private Integer recruitingNumbers;
    private Integer contractExpirationTime;
    private Integer inviteAgeMin;
    private Integer inviteAgeMax;
    private Integer inviteGender;
    private Double chargeService;
    private Double chargeRebate;
    private String jobRequir;
    private String interTime;
    private Integer interType;
    private String interProvince;
    private String interCity;
    private String interDistrict;
    private String interAddress;
    private Integer browseNum;
    private Integer invitePassNum;
    private String expInterResultTime;
    private String workEnvironmentPhotos;
    private String workEnvironmentVideos;
    private Integer boutique;
    private String photoDispatchQualification;
    private String workLabel;
    private String workLabelDefined;
    private Integer status;
    private String remark;
    private Double amountFirst;
    private Double amountSecond;
    private Double amountPayment;
    private Integer trafficAllowanc;
    private Integer roomAndBoard;
    private Date createTime;
    private Date pushTime;
    private String validityDate;
}
