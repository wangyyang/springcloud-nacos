package com.cloud.yanger.commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class Advertising {

    @TableId(type = IdType.AUTO)
    private int id;
    private String name;
    private String images;
    private Integer clientType;
    private Integer location;
    private String link;
    private String remark;
    private int clickNumber;
    private Integer status;
    private Integer sort;
    private Integer sysUserId;
    private Date createTime;
}
