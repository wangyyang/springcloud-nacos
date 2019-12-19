package com.cloud.yanger.job.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.yanger.commons.entity.Job;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface JobMapper extends BaseMapper<Job> {
}
