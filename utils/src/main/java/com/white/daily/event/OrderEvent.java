package com.white.daily.event;

import org.springframework.context.ApplicationEvent;

/**
 *
 * 1.先自定义事件：你的事件需要继承 ApplicationEvent
 *
 * 2.定义事件监听器: 需要实现 ApplicationListener
 *
 * 3.使用容器对事件进行发布
 *
 * @author tcs
 * @date Created in 2021-03-09
 */
public class OrderEvent extends ApplicationEvent {

    private Object object;
    public OrderEvent(Object source,Object t) {
        super(source);
        this.object=t;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
