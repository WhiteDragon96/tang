package com.white.daily.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author tcs
 * @date Created in 2021-05-13
 */
@Configuration
@MapperScan("com.white.daily.**.mapper.**")
public class MybatisPlusConfiguration {
}
