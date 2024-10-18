package com.white.daily.xxljob;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

/**
 * @author tcs
 * @date Created in 2021-04-06
 */
@Component
@Slf4j
public class MyJobHandler extends IJobHandler {

    /**
     * 1、简单任务示例（Bean模式）
     */

    public void demoJobHandler() throws Exception {
        System.out.println("生命不息");

        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            TimeUnit.SECONDS.sleep(2);
        }
        // default success
    }

    @XxlJob("testJobHandler")
    @Override
    public ReturnT<String> execute(String param) throws Exception {
        System.out.println("生命不息");
        return ReturnT.SUCCESS;
    }
}
