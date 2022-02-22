package com.white.daily.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author tcs
 * @date Created in 2021-03-09
 */
@Configuration
@ComponentScan("com.white.daily.event")
public class EventConfig {

    /**
     * spring 启动后执行
     */
    @PostConstruct
    public void test(){

        System.out.println("生命不息");
    }
}
