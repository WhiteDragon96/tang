package com.tang;

import com.tang.websocket.client.MyWebSocketClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

import java.util.concurrent.CountDownLatch;

/**
 * @author tangcs
 */
@SpringBootApplication
@EnableWebSocket
public class TestApplication implements CommandLineRunner {

    @Autowired
    private MyWebSocketClient webSocketClient;

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(TestApplication.class, args);
        new CountDownLatch(1).await();
    }

    @Override
    public void run(String... args) throws Exception {
        this.webSocketClient.connect();
        Thread.sleep(5000);
        this.webSocketClient.disconnect();
    }
}
