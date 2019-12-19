package com.cloud.yanger.commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class JobBrowse {
    @TableId(type = IdType.AUTO)
    private int id;
    private Integer jobId;
    private Integer userId;
    private Date createTime;
    private Date updateTime;
}
