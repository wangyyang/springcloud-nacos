package com.cloud.yanger.commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class WorkCategory {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer parentId;
    private String workName;
    private Integer sort;
    private Integer status;
    private Integer level;
    private Integer type;
}
