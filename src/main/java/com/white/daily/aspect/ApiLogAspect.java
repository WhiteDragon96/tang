package com.white.daily.aspect;

import com.white.daily.annotation.ApiLog;
import com.white.daily.publisher.ApiLogPublisher;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author tcs
 * @date Created in 2021-04-25
 */
@Component
@Aspect
public class ApiLogAspect {
    private static final Logger log = LoggerFactory.getLogger(ApiLogAspect.class);

    public ApiLogAspect() {
    }

    @Around("@annotation(apiLog)")
    public Object around(ProceedingJoinPoint point, ApiLog apiLog) throws Throwable {
        String className = point.getTarget().getClass().getName();
        String method = point.getSignature().getName();
        System.out.println("===========   ");
        log.info(method);
        long beginTime = System.currentTimeMillis();
        Object result = point.proceed();
        long time = System.currentTimeMillis() - beginTime;
        System.out.println("===========   " + time);
        ApiLogPublisher.publishEvent(method, className, apiLog, time);
        return result;
    }

}
