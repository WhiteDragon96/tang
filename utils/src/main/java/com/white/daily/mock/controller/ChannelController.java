package com.white.daily.mock.controller;

import com.white.daily.mock.service.MyJedisPubSub;
import com.white.daily.util.JedisPoolUtils;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author tcs
 * @date Created in 2022-02-09
 */
@RestController
@AllArgsConstructor
public class ChannelController {

    public static final String CHANNEL_KEY = "channel:1";

    /**
     * 发送消息到redis队列
     */
    @PostMapping("/send-message")
    public Long sendMessage(@RequestBody String message) {
        Jedis jedis = JedisPoolUtils.getJedis();
        return jedis.publish(CHANNEL_KEY, message);
    }

    @GetMapping("/receive-message")
    public String receiveMessage(HttpServletResponse response) throws IOException {
        while (true) {
            MyJedisPubSub myJedisPubSub = new MyJedisPubSub(response);
            Jedis jedis = JedisPoolUtils.getJedis();
            jedis.subscribe(myJedisPubSub, CHANNEL_KEY);
        }
    }

}
