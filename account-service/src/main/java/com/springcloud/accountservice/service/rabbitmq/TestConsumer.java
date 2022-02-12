package com.springcloud.accountservice.service.rabbitmq;

import com.springcloud.accountservice.config.rabbit.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = RabbitMQConfig.QUEUE_NAME, containerFactory = "containerFactory")
public class TestConsumer {
    @RabbitHandler
    public void process(Map<String, String> message) {
        System.out.println("consume message " + message.get("messageName"));
        System.out.println("consume message " + message.get("messageData"));
    }
}
