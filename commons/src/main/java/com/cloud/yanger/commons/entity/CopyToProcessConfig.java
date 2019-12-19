package com.cloud.yanger.commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class CopyToProcessConfig {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer sysUserId;
    private Integer type;
    private Integer createUser;
    private Date createTime;
    private Integer modifier;
    private Date modifyTime;
}
