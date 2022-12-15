package com.tang.rabbit;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;

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
    @org.springframework.amqp.rabbit.annotation.RabbitListener(queues = "3301")
    public void simpleHandler(Message msg, Channel channel) throws IOException {
        try {
            System.out.println("接收到的消息是 ： " + new String(msg.getBody()));
            channel.basicAck(msg.getMessageProperties().getDeliveryTag(), false);
        } catch (IOException e) {
            channel.basicNack(msg.getMessageProperties().getDeliveryTag(), false, true);
        }
    }
}
