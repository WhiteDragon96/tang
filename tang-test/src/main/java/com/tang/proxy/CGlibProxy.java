package com.tang.proxy;

import com.tang.proxy.bean.UserService;
import com.tang.proxy.bean.UserServiceImpl;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * CGLIB 代理模式
 * 代理就是在原始对象外部加了一层，执行方法时还是调用原有方法
 *
 * @author tcs
 * @date 2023/03/09  15:18
 */
public class CGlibProxy implements MethodInterceptor {

    public static void main(String[] args) {
        // 创建原始对象
        UserService userService = new UserServiceImpl();

        // 创建代理对象
        UserService proxy = (UserService) new CGlibProxy(userService).getProxyInstance();

        // 调用代理对象的方法
        proxy.addUser("Alice", "123456");
    }

    private Object target;

    public CGlibProxy(Object target) {
        this.target = target;
    }

    // 创建代理对象
    public Object getProxyInstance() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("Before method " + method.getName());
        // 调用原始对象的方法
        Object result = proxy.invoke(target, args);
        System.out.println("After method " + method.getName());
        return result;
    }
}
