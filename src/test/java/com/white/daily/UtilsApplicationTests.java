package com.white.daily;

import com.taobao.api.ApiException;
import com.white.daily.config.DingRobotConfig;
import com.white.daily.config.EventConfig;
import com.white.daily.event.OrderEvent;
import com.white.daily.mock.DemoEventPublisher;
import com.white.daily.util.DingUtils;
import com.white.daily.util.SpringUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
class UtilsApplicationTests {

    @Autowired
    DingRobotConfig dingRobotConfig;

    @Autowired
    DemoEventPublisher demoEventPublisher;

    @Test
    void contextLoads() throws ApiException {
        DingUtils.sendMsg("hello DD");
    }

    @Test
    public void testEvent(){
       // demoEventPublisher.pushlish("hello");
        SpringUtil.publishEvent(new OrderEvent("hello","event"));
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
