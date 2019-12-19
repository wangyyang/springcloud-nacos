package com.cloud.yanger.commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class ResumeExpectedPosition {
    @TableId(type = IdType.AUTO)
    private int id;
    private int rsmId;
    private Integer positionSecond;
    private String positionSecondName;
    private Integer positionThird;
    private String positionThirdName;
    private Date createTime;
}
