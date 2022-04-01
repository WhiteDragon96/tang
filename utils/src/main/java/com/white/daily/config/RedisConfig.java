package com.white.daily.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author tcs
 * @date Created in 2021-10-22
 */
@Configuration
public class RedisConfig {

    // 编写自己的redisTemplate
    @Bean
    public RedisTemplate<String,Object> xxlJobExecutor(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        // 序列化配置
//        template.setKeySerializer();
        return template;
    }
}
