package com.tang.kafka;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@SpringBootTest
public class KfKTest {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Test
    public void proTest() throws ExecutionException, InterruptedException, TimeoutException {
        for (int i = 0; i < 10; i++) {
            kafkaTemplate.send("test", LocalDateTime.now().toString() + ": " + i);
        }
//同步发送其实就是发送时强制监听结果
        ListenableFuture<SendResult<String, Object>> sendResult = kafkaTemplate.send("test", "hello");
        //开始监听,设置一个时间，超过后放弃此处监听
        SendResult<String, Object> result = sendResult.get(3, TimeUnit.SECONDS);
        System.out.println("监听到的结果-------" + result.getProducerRecord().value());
    }
}