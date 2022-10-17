package com.tang.rabbit.five;

import com.rabbitmq.client.Channel;
import com.tang.rabbit.four.ConfirmMessage;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class EmitLog {
    // 交换机的名称
    public static final String EXCHANGE_NAME = "logs";

    public static void main(String[] args) throws Exception {
        Channel channel = ConfirmMessage.getChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String message = scanner.nextLine();
            channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes(StandardCharsets.UTF_8));
            System.out.println("生产者发送出消息：" + message);
        }
    }
}
