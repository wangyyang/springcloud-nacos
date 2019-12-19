package com.cloud.yanger.commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class SysForcedUpdatingLog {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer clientType;
    private Integer updateType;
    private String content;
    private String linkAddress;
    private String version;
    private Integer sysUserId;
    private Date createTime;
}
