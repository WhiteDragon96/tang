package com.tang.rabbit.seven;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.tang.rabbit.four.ConfirmMessage;

public class ReceiveLogsTopic02 {
    private static final String EXCHANGE_NAME = "topic_logs";

    public static void main(String[] argv) throws Exception {
        Channel channel = ConfirmMessage.getChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, "topic");
        //声明 Q2 队列与绑定关系
        String queueName = "Q2";
        channel.queueDeclare(queueName, false, false, false, null);
        channel.queueBind(queueName, EXCHANGE_NAME, "*.*.rabbit");
        channel.queueBind(queueName, EXCHANGE_NAME, "lazy.#");
        System.out.println("等待接收消息.....");
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" 接收队列 :" + queueName + " 绑 定键:"+delivery.getEnvelope().getRoutingKey()+", 消息:"+message);
        };
        channel.basicConsume(queueName, true, deliverCallback, consumerTag -> {
        });
    }

}
