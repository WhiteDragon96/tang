package com.white.daily.event;

import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author tcs
 * @date Created in 2021-03-09
 */
@Component
public class OrderEventListener implements ApplicationListener<OrderEvent> {

    @Async
    @Override
    public void onApplicationEvent(OrderEvent orderEvent) {
        //真正做业务的地方
        try {
            System.out.println("开始做事"+ Thread.currentThread().getName());
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String s = orderEvent.getObject().toString();
        System.out.println("结束做事"+s);
    }
}
