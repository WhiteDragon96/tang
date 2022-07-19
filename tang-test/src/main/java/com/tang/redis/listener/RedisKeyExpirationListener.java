package com.tang.redis.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;

import java.util.Arrays;


/**
 * @author tangcs
 */
@Slf4j
@Component
public class RedisKeyExpirationListener extends KeyExpirationEventMessageListener {

    public RedisKeyExpirationListener(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }

    /**
     * 针对redis数据失效事件，进行数据处理
     *
     * @param message
     * @param pattern
     */
    @Override
    public void onMessage(Message message, byte[] pattern) {
        try {
            String key = message.toString();
            System.out.println(Arrays.toString(pattern));
            //从失效key中筛选代表订单失效的key
            System.out.println(key + " 失效了");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("【修改支付订单过期状态异常】：" + e.getMessage());
        }
    }
}