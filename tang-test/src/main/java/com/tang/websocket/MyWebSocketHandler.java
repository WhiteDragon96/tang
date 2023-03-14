package com.tang.websocket;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import java.util.concurrent.TimeUnit;

/**
 * @author tangcs
 */
@Component
public class MyWebSocketHandler extends AbstractWebSocketHandler {
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // 处理接收到的消息
        String payload = message.getPayload();
        System.out.println("Received message: " + payload);

        // 发送回复消息
        for (int i = 0; i < 10; i++) {
            TimeUnit.SECONDS.sleep(5);
            session.sendMessage(new TextMessage( payload ));
        }

    }
}
