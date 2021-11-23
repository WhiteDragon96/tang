package com.white.daily.redis;

import com.white.daily.util.RedisUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;
import java.util.concurrent.Executor;

/**
 * @author tcs
 * @date Created in 2021-10-22
 */
@SpringBootTest
public class RedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Resource(name = "asyncServiceExecutor")
    private Executor executor;

    @Test
    public void testSet() {

        stringRedisTemplate.opsForValue().set("hello1", "world");
        stringRedisTemplate.opsForZSet().add("张三1","张",2);
        stringRedisTemplate.opsForZSet().add("李四1","李",1);

    }

    @Test
    public void testThread(){
        for (int i = 10; i < 20; i++) {
            stringRedisTemplate.opsForValue().set(i+"", 10000-i+"");
        }
        executor.execute(() ->{
            for (int i = 10; i < 20; i++) {
                stringRedisTemplate.opsForValue().set(i+"", 10000-i+"");
            }
        });
    }

}
