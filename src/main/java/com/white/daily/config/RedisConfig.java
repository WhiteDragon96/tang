package com.white.daily.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author tcs
 * @date Created in 2021-10-22
 */
@Component
public class RedisConfig {

    @Bean
    public RedisTemplate xxlJobExecutor(RedisTemplate redisTemplate) {
        redisTemplate.opsForValue().set("spring-r-cluster-1", 123);
        redisTemplate.opsForValue().set("spring-r-cluster-2", 456);
        redisTemplate.opsForValue().set("spring-r-cluster-3", 789);
        return redisTemplate;
    }
}
