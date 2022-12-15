package com.tang.rabbit.two;

import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.tang.rabbit.RabbitMqUtils;
import lombok.extern.slf4j.Slf4j;

/**
 * rabbitMQ消费者手动应答
 *
 * @author tcs
 * @date 2022/10/14  10:28
 */
@Slf4j
public class Work03 {
    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
        log.info("C1 等待接收消息处理时间较短");
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody());
            log.info("C1接收到消息：{}", message);
            /**
             * 1.消息标记 tag
             * 2.是否批量应答未应答消息
             */
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
        };
        CancelCallback cancelCallback = var -> System.out.println("取消消费");
        /**
         * 设置分发权重 1为不公平分发，谁消费快就多发
         */
        channel.basicQos(4);
        //采用手动应答
        boolean autoAck = false;
        channel.basicConsume(RabbitMqUtils.QUEUE_NAME, autoAck, deliverCallback, cancelCallback);

    }
}
