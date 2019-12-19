package com.cloud.yanger.commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class SendResumeDetails {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer userId;
    private Integer jobId;
    private Integer type;
    private Integer verify;
    private Integer recommend;
    private Date createTime;
    private Integer sysUserId;
    private Integer deleteStatus;
}
