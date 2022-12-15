package com.tang.rabbit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @author tcs
 * @date 2022/10/14  10:28
 */
public class RabbitMqUtils {

    public final static String QUEUE_NAME = "hello";

    /**
     * 得到一个连接的 channel
     */
    public static Channel getChannel() throws Exception {
        //创建一个连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("119.91.204.244");
        Connection connection = factory.newConnection();
        return connection.createChannel();
    }
}
