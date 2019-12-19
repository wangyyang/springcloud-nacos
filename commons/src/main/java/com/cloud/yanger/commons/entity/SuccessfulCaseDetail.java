package com.cloud.yanger.commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class SuccessfulCaseDetail {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer scId;
    private Integer userId;
    private String interviewImg;
    private Date interviewTime;
    private String outboundMaterialImg;
    private Date outboundMaterialTime;
    private String visaImg;
    private Date visaTime;
    private String departuresImg;
    private Date departuresTime;
    private String remark;
    private Integer status;
    private Integer auditStatus;
    private Date createTime;
}
