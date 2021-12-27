package com.white.daily.config;

import com.google.common.util.concurrent.RateLimiter;
import com.white.daily.guava.RateLimiterInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.TimeUnit;

/**
 * @author tcs
 * @date Created in 2021-12-22
 */
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /**
         * test接口，1秒钟生成1个令牌，也就是1秒中允许一个人访问
         */
        registry.addInterceptor(new RateLimiterInterceptor(RateLimiter.create(1, 1, TimeUnit.SECONDS)))
                .addPathPatterns("/blade-demo/account/test");
    }

}
