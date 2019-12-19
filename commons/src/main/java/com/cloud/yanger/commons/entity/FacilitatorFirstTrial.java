package com.cloud.yanger.commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class FacilitatorFirstTrial {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer facId;
    private String companyProfiles;
    private Integer type;
    private String workDate;
    private String workRange;
    private String cooperationPlatform;
    private String introducer;
    private String demand;
    private String remark;
    private Integer sysUserId;
    private Date createTime;
    private Integer modifier;
    private Date modifyTime;
}
