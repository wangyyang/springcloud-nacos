package com.cloud.yanger.commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class ResumeExpectedWorkPlace {
    @TableId(type = IdType.AUTO)
    private int id;
    private int rsmId;
    private String workplace;
    private String placeCode;
    private Date createTime;
}
