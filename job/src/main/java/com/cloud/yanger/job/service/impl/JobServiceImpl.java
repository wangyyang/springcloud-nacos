package com.cloud.yanger.job.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.yanger.commons.entity.Job;
import com.cloud.yanger.job.mapper.JobMapper;
import com.cloud.yanger.job.service.JobService;
import org.springframework.stereotype.Service;

@Service
public class JobServiceImpl extends ServiceImpl<JobMapper, Job> implements JobService {
}
