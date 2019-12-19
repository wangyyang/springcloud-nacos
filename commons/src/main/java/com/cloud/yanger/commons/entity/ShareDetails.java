package com.cloud.yanger.commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class ShareDetails {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer shareId;
    private Integer jobId;
}
