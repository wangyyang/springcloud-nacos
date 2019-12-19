package com.cloud.yanger.commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class CopyToRecords {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer receiver;//接收方
    private Integer initiator;//发起方
    private Integer type;
    private Integer status;
    private Integer result;
    private String params;
    private Date submitTime;
    private Date createTime;
}
