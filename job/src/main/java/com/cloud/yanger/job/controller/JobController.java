package com.cloud.yanger.job.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cloud.yanger.commons.constants.JobStatusConstants;
import com.cloud.yanger.commons.entity.Job;
import com.cloud.yanger.job.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("job")
public class JobController {

    @Autowired
    private JobService jobService;


    @PostMapping("getJobList")
    public Object getJobList() {
        LambdaQueryWrapper<Job> lq = new LambdaQueryWrapper<>();
        lq.eq(Job::getStatus, JobStatusConstants.RECRUITMENT);
        return jobService.list(lq);
    }
}
