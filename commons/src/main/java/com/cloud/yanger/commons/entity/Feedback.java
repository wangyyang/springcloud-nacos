package com.cloud.yanger.commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class Feedback {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer userId;
    private Integer feedType;
    private String feedDescription;
    private String feedImg;
    private Integer sysUserId;
    private Date createTime;
    private Date processingTime;
    private Integer feedResult;
    private String feedRemark;
    private Integer feedSource;
}
