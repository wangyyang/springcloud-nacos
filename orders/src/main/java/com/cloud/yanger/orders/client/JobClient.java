package com.cloud.yanger.orders.client;

import com.cloud.yanger.orders.model.QueryStat;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "job")
public interface JobClient {

    @PostMapping("/job/getJobList")
    Object getJobList(@RequestBody QueryStat queryStat);

    @PostMapping("/job/getJobList")
    Object getJobListByStatus(@RequestParam Integer status);
}
