package com.white.daily.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author tcs
 * @date Created in 2021-04-25
 */
public class ApiLogEvent extends ApplicationEvent {
    public ApiLogEvent(Object source) {
        super(source);
    }
}
