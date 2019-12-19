package com.cloud.yanger.commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ApprovalRecords {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer sysUserId;
    private Integer type;
    private Integer targetId;
    private Integer disLevel;
    private Integer visLevel;
    private Integer visUserId;
    private Integer status;
    private Integer isLast;
}
