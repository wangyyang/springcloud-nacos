package com.cloud.yanger.commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class ResumeWorkExperience {
	@TableId(type = IdType.AUTO)
	private Integer id;
    private Integer rsmId;
    private String companyName;
    private String workTitle;
    private Date startTime;
    private Date endTime;
    private Integer positionFirst;
    private Integer positionSecond;
    private Integer positionThird;
    private String monthlyPay;
    private String jobDescription;
    private Date createTime;
    private Date updateTime;
}
