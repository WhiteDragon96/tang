package com.tang.rabbit.sxi;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.tang.rabbit.four.ConfirmMessage;

public class ReceiveLogsDirect01 {

    public static final String EXCHANGE_NAME = "direct_logs";

    public static void main(String[] args) throws Exception {
        Channel channel = ConfirmMessage.getChannel();
        //声明一个交换机
        channel.exchangeDeclare(EXCHANGE_NAME, "direct");
        /**
         * 生成一个临时队列、队名名称是随机的
         * 当消费者断开与队列的连接的时候，队列就自动删除
         */
        String queue = channel.queueDeclare().getQueue();
        channel.queueBind(queue, EXCHANGE_NAME, "info");
        channel.queueBind(queue, EXCHANGE_NAME, "warning");
        System.out.println("等待接受消息，把接受到的消息打印在屏幕上....");
        DeliverCallback deliverCallback = (consumerTag, message) -> {
            System.out.println("ReceiveLogsDirect01接受到的消息是：" + new String(message.getBody()));
        };
        channel.basicConsume(queue, true, deliverCallback, consumerTag -> {
        });
    }
}
