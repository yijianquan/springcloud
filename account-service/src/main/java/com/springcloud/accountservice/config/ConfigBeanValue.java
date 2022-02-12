package com.springcloud.accountservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConfigBeanValue {

    @Value("${rabbit.queue.name}")
    public static String QUEUE_NAME;
    @Value("${rabbit.exchange.name}")
    public static String EXCHANGE_NAME;
    @Value("${rabbit.routing.key}")
    public static String ROUTING_KEY;
    @Value("${rabbit.user.username}")
    public static String rabbitUsername;
    @Value("${rabbit.user.password}")
    public static String rabbitPassword;

}
