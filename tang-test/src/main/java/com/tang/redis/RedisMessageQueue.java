package com.tang.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @author tcs
 * @date Created in 2022-02-09
 */
public class RedisMessageQueue {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
}
