package com.tang.websocket.client;


import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author tcs
 * @date 2023/03/14  15:13
 */
@Component
public class MyWebSocketClient extends TextWebSocketHandler {

    private final URI uri;
    private final WebSocketClient webSocketClient;
    private WebSocketSession webSocketSession;

    public MyWebSocketClient() throws URISyntaxException {
        this.uri = new URI("ws://localhost:6699/websocket");
        this.webSocketClient = new StandardWebSocketClient();
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        this.webSocketSession = session;
        this.webSocketSession.sendMessage(new TextMessage("Hello, Server!"));
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println("received Message:" + message.getPayload());
    }

    public void connect() {
        this.webSocketClient.doHandshake(this, new WebSocketHttpHeaders(), this.uri);
    }

    public void disconnect() throws IOException {
        this.webSocketSession.close();
    }
}
