package com.cloud.yanger.orders.client;

import com.cloud.yanger.orders.model.QueryStat;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "job")
public interface JobClient {

    @PostMapping("/job/getJobList")
    Object getJobList(@RequestBody QueryStat queryStat);
}
