package com.tang.redis;

import com.tang.redis.bean.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author tcs
 * @date Created in 2022-03-03
 */
@RequiredArgsConstructor
public class BeanFactory {
    private final AutowireCapableBeanFactory beanFactory;
    private final DefaultListableBeanFactory defaultListableBeanFactory;

    public  void testSetBean() {
        User user = new User();
        defaultListableBeanFactory.registerSingleton("user", user);
        beanFactory.autowireBean(user);
        System.out.println(defaultListableBeanFactory.getBean("user").equals(user));
    }

    public static void main(String[] args) {

    }
}
