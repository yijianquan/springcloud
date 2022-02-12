package com.springcloud.accountservice.service;

import com.springcloud.accountservice.service.impl.BabyClientFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "getbaby-service", path = "/baby", fallback = BabyClientFallBack.class)
@Component
public interface BabyServiceClient {

    @RequestMapping(value = "getbaby")
    String getBaby();

}
