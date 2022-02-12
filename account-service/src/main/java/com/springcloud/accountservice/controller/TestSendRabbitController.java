package com.springcloud.accountservice.controller;

import com.springcloud.accountservice.service.rabbitmq.RabbitConsumer;
import com.springcloud.accountservice.config.rabbit.RabbitMQConfig;
import org.joda.time.DateTime;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
@ResponseBody
public class TestSendRabbitController {

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Resource
    private RabbitConsumer rabbitConsumer;

    @GetMapping("/sendMessage")
    public Object sendMessage() {
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                Map<String, String> map = new HashMap<>();
                map.put("messageName", "name" + i);
                map.put("messageData", new DateTime().toString("yyyy-MM-dd HH:mm:ss"));
                System.out.println("send message " + map.get("messageName"));
                rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.ROUTING_KEY, map);
            }
        }).start();
        return "ok";
    }

    @GetMapping("/beginconsumer")
    public String getName() {
        rabbitConsumer.consumeMessage();
        return "consume ok";
//        return RabbitMQConfig.username;
    }
}
