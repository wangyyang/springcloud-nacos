package com.cloud.yanger.commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class SuccessfulCase {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer jobId;
    private String interviewTrainingImg;
    private Date interviewTrainingTime;
    private String interviewPassUsersImg;
    private Date interviewPassUsersTime;
    private Integer clickCount;
    private Integer status;
    private Integer auditStatus;
    private Integer enable;
    private Integer iflag;
    private Date createTime;
    private Integer modifier;
    private Date modifyTime;
}
