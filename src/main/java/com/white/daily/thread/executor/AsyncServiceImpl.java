package com.white.daily.thread.executor;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author tcs
 * @date Created in 2021-08-13
 */
@Service
@Slf4j
public class AsyncServiceImpl implements AsyncService {



    @Async("asyncServiceExecutor")
    @Override
    public void executeAsync() {
        log.info("start executeAsync");

        System.out.println("异步线程要做的事情");
        System.out.println("可以在这里执行批量插入等耗时的事情");

        log.info("end executeAsync");
    }
}
