package com.cloud.yanger.commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class UserTrackRecord {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer userId;
    private String remark;
    private Integer sysUserId;
    private String sysUserName;
    private Date createTime;
}
