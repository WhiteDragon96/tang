package com.white.daily.mock;

import com.white.daily.event.OrderEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author tcs
 * @date Created in 2021-03-09
 */
@Component
public class DemoEventPublisher {

    @Autowired
    private ApplicationContext applicationContext;

    public void pushlish(Object o){
        applicationContext.publishEvent(new OrderEvent(this,o));
    }
}
