package com.springcloud.gateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testcase")
public class TestGatewayController {

    @RequestMapping("/testcase1")
    public String getUsername() {
        return "测试gateway失败!";
    }
}
