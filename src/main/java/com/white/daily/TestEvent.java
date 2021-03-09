package com.white.daily;

import com.white.daily.config.EventConfig;
import com.white.daily.event.OrderEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author tcs
 * @date Created in 2021-03-09
 */
public class TestEvent {


        public static void main(String[] args) {
            AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(EventConfig.class);
            applicationContext.publishEvent(new OrderEvent(applicationContext,"ddddd"));
            applicationContext.publishEvent(new OrderEvent(applicationContext,"2222"));
            applicationContext.publishEvent(new OrderEvent(applicationContext,"3333"));
            applicationContext.publishEvent(new OrderEvent(applicationContext,"444"));
            applicationContext.publishEvent(new OrderEvent(applicationContext,"555"));
            applicationContext.publishEvent(new OrderEvent(applicationContext,"666"));
            applicationContext.publishEvent(new OrderEvent(applicationContext,"777"));

        }

}
