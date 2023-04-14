package com.tang.proxy;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * CGLIB 代理模式
 *
 * @author tcs
 * @date 2023/03/09  15:18
 */
public class CGlibProxy implements MethodInterceptor {

    private Object target;

    public CGlibProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("Before method " + method.getName());
        Object result = proxy.invoke(target, args);
        System.out.println("After method " + method.getName());
        return result;
    }
}
