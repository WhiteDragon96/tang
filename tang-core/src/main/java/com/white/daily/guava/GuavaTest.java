package com.white.daily.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.RateLimiter;
import com.sun.corba.se.impl.orbutil.graph.Graph;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.concurrent.TimeUnit;

/**
 * @author tcs
 * @date Created in 2021-12-22
 */
@Component
public class GuavaTest {

    /**
     * 创建一个限速器，每1秒，产生2.5个令牌
     */
    RateLimiter rateLimiter = RateLimiter.create(2.5, 1, TimeUnit.SECONDS);

    /**
     * 尝试获取1个令牌，如果没有，会阻塞当前线程。直到获取成功返回。
     * 返回值是，阻塞的秒数
     */
    double waitSeconds = rateLimiter.acquire();

    /**
     * 尝试获取1个令牌，不会阻塞当前线程。
     * 立即返回是否获取成功。
     */
    boolean success = rateLimiter.tryAcquire();


}
