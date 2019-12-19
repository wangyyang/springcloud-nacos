package com.cloud.yanger.commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class WorkHot {
    @TableId(type = IdType.AUTO)
    private int id;
    private Integer type;
    private Integer targetId;
    private String backgroundImg;
    private Integer sysUserId;
    private Date createTime;
    private Integer sort;
}
