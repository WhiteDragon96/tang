package com.white.daily.event;

import com.white.daily.pojo.LogApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author tcs
 * @date Created in 2021-04-25
 */
@Component
public class ApiLogListener {
    private static final Logger log = LoggerFactory.getLogger(ApiLogListener.class);

    @Async
    @Order
    @EventListener({ApiLogEvent.class})
    public void saveLog(ApiLogEvent event) throws InterruptedException {
        Map<String, LogApi> map = (Map<String, LogApi>) event.getSource();
        LogApi logApi = map.get("log");
        System.out.println(logApi);
    }
}
