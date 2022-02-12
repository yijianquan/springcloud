package com.springcloud.accountservice.service.impl;

import com.springcloud.accountservice.service.BabyServiceClient;
import org.springframework.stereotype.Component;

@Component
public class BabyClientFallBack implements BabyServiceClient {

    @Override
    public String getBaby() {
        return "熔断器生效";
    }
}
