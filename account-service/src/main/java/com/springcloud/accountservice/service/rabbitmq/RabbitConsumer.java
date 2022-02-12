package com.springcloud.accountservice.service.rabbitmq;

import com.alibaba.fastjson.JSONObject;
import com.springcloud.accountservice.config.rabbit.RabbitMQConfig;
import org.apache.commons.lang.SerializationUtils;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class RabbitConsumer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    // 监听消费数据
    // 静态绑定
    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    // 动态绑定
//    @RabbitListener(queues = "#{queue.name}")
    public void consumeMessage(Map<String, String> message) {
        System.out.println("consume message " + message.get("messageName"));
        System.out.println("consume message " + message.get("messageData"));
    }

    // 主动消费数据
    public void consumeMessage() {
        while (true) {
            Message message = rabbitTemplate.receive(RabbitMQConfig.QUEUE_NAME, 1000);
            if (message == null) {
                System.out.println("数据消费完了");
                return;
            }
            Map<String, String> map = (Map<String, String>) SerializationUtils.deserialize(message.getBody());
//            JSONObject map = JSONObject.parseObject(message.getBody().toString());
            System.out.println(map.get("messageName"));
            System.out.println(map.get("messageData"));
        }
    }
}
