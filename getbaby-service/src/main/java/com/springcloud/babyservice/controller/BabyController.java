package com.springcloud.babyservice.controller;


import com.springcloud.babyservice.service.BabyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/baby")
public class BabyController {

    @Resource
    private BabyService babyService;

    @RequestMapping("/getbaby")
    public String getBaby() {
        return babyService.getBaby();
    }

    @RequestMapping("/getmap")
    public Map<String, String> getMap() {
        Map<String, String> map = new HashMap<>();
        map.put("测试", "123");
        return map;
    }

}
