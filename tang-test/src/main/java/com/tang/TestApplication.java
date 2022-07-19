package com.tang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.CountDownLatch;

/**
 * @author tangcs
 */
@SpringBootApplication
public class TestApplication {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(TestApplication.class, args);
        new CountDownLatch(1).await();
    }

}
