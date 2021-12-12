package io.github.tang.wechat;

import io.github.tang.wechat.robot.WebBotTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationStartup
{

    public static void main(String[] args) {
        SpringApplication.run(ApplicationStartup.class, args);
//        WebBotTest.main (null);
    }
}