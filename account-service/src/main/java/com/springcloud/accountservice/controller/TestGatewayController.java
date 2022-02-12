package com.springcloud.accountservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testcase")
public class TestGatewayController {

    @RequestMapping("/getusername")
    public String getUsername() {
        return "测试gateway成功!";
    }
}
