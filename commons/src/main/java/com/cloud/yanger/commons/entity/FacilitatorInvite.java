package com.cloud.yanger.commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class FacilitatorInvite {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer facId;
    private Integer jobId;
    private Integer inviter;
    private Integer invitee;
    private Integer status;
    private Date createTime;
    private Date updateTime;
}
