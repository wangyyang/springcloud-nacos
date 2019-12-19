package com.cloud.yanger.commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class SysDepartment {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer parentId;
    private String departmentName;
    private Integer sysUserId;
    private String createTime;
}
