package com.tang.rabbit;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author tcs
 * @date 2022-08-04  15:28
 */
@SpringBootTest
public class RabbitTest {

    @Autowired
    RabbitTemplate rabbitTemplate;  //使用RabbitTemplate,这提供了接收/发送等等方法

    @Test
    public void proTest() throws InterruptedException {
        int threadNum = 60;
        ExecutorService executorService = Executors.newFixedThreadPool(threadNum);
        for (;;) {
            String messageId = String.valueOf(UUID.randomUUID());
            String messageData = "test message, hello!";
            String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            Map<String, Object> map = new HashMap<>();
            map.put("messageId", messageId);
            map.put("messageData", messageData);
            map.put("createTime", createTime);
            //将消息携带绑定键值：TestDirectRouting 发送到交换机TestDirectExchange
            rabbitTemplate.convertAndSend("TestDirectExchange", "TestDirectRouting", map);
            CountDownLatch countDownLatch = new CountDownLatch(threadNum);
            for (int i = 0; i < threadNum; i++) {
                executorService.execute(() ->{
                    rabbitTemplate.convertAndSend("TestDirectExchange", "TestDirectRouting", map);
                    try {
                        Thread.sleep(100);
                        countDownLatch.countDown();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
            countDownLatch.await();
            Thread.sleep(100);
        }

    }
}
