package com.tang.rabbit.two;

import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.tang.rabbit.RabbitMqUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author tcs
 * @date 2022/10/14  10:40
 */
@Slf4j
public class Work04 {
    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
        log.info("C1 等待接收消息处理时间较长");
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody());
            try {
                TimeUnit.SECONDS.sleep(30);
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
            log.info("C1接收到消息：{}", message);
            /**
             * 1.消息标记 tag
             * 2.是否批量应答未应答消息
             */
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
        };
        CancelCallback cancelCallback = var -> System.out.println("取消消费");
        channel.basicQos(2);
        //采用手动应答
        boolean autoAck = false;
        channel.basicConsume(RabbitMqUtils.QUEUE_NAME, autoAck, deliverCallback, cancelCallback);

    }
}
