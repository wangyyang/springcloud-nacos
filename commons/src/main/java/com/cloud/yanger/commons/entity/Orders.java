package com.cloud.yanger.commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class Orders {
    @TableId(type = IdType.AUTO)
    private int id;
    private String orderNumber;
    private Integer userId;
    private Integer facId;
    private Integer jobId;
    private Integer status;
    private String serviceContractImg;
    private String outboundMaterialImg;
    private String facVisaImg;
    private String trainSceneUrl;
    private String visaUrl;
    private Double interviewGuarantee;
    private Integer marginStatus;
    private Double refundMoney;
    private String remark;
    private Date createTime;
    private Integer modifier;
    private Integer facModifier;
    private Date modifyTime;
    private Date facModifyTime;
    private Integer deleteStatus;
}
