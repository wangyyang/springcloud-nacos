package com.cloud.yanger.commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class Strategy {
    @TableId(type = IdType.AUTO)
    private int id;
    private Integer scId;
    private String title;
    private String subhead;
    private String content;
    private String cover;
    private Integer sort;
    private Integer status;
    private Integer pageview;
    private Integer choiceness;
    private Integer sysUserId;
    private Date createTime;
    private Integer modifier;
    private Date modifyTime;
}
