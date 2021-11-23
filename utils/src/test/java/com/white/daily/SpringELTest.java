package com.white.daily;


import com.white.daily.constant.TestConstant;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author tcs
 * @date Created in 2021-04-27
 */
public class SpringELTest {
    /*
     * @Value注解等同于XML配置中的<property/>标签,
     * SpringEL同样支持在XML<property/>中编写
     */

    // 注入简单值,输出num为5
    @Value("#{5}")
    private Integer num;

    // 注入ID为testConstant的Bean
    @Value("#{testConstant}")
    private TestConstant Constant;

    // 注入ID为testConstant Bean中的STR常量/变量
    @Value("#{testConstant.test}")
    private String str;


}
