package com.white.daily.source;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author tcs
 * @date Created in 2021-04-07
 */
public class SpringSourceTest {
    public static void main(String[] args) {
        Class[] classes = {SpringSourceTest.class};
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
        SimpleBean bean = context.getBean(SimpleBean.class);
        bean.send();
        //context.close();
    }
}
