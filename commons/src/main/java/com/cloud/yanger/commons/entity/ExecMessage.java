package com.cloud.yanger.commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class ExecMessage {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer type;
    private String params;
    private Integer status;
    private Date createTime;
}
