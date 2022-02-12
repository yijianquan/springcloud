package com.springcloud.accountservice.controller;


import com.springcloud.accountservice.service.BabyServiceClient;
import com.springcloud.accountservice.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/baby")
public class BabyController {

    @Autowired
    private BabyServiceClient babyServiceClient;

    @RequestMapping("/testeureka")
    public String testEureka() {
        return babyServiceClient.getBaby();
    }

    @RequestMapping("/testredis")
    public String testRedis(String key) {
        return RedisUtils.getStringByKey(key);
    }
}
