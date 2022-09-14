package com.tang.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author tcs
 * @date 2022-08-04  15:46
 */
@Component
public class RabbitListener {
    /**
     * 接受消息，业务处理
     *
     * @param msg
     */
    @RabbitHandler
    @org.springframework.amqp.rabbit.annotation.RabbitListener(queues = "TestDirectQueue")
    public void simpleHandler(Map<String, Object> msg) {
        System.out.println("接收到的消息是 ： " + msg);
    }
}
