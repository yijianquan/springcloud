package com.springcloud.accountservice.utils;
import redis.clients.jedis.Jedis;

public class RedisUtils {

    private final static Jedis jedis = new Jedis("localhost");

    public static String getStringByKey(String key) {
        return jedis.get(key);
    }

}
