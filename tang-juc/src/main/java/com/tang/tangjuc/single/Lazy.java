package com.tang.tangjuc.single;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 *  懒汉式单列
 * @author tcs
 * @date Created in 2021-12-27
 */
public class Lazy {

    private static  boolean qinjiang = false;

    private Lazy(){
        System.out.println(Thread.currentThread().getName()+ "ok");
        synchronized (Lazy.class){
            if (LAZY !=null){
                throw new RuntimeException("不要试图用反射破坏单例");
            }
        }
    }
    private volatile static Lazy LAZY;

    // 双重监测锁模式的 懒汉式单例 DCL懒汉式
    public static Lazy getInstance(){
        if (LAZY == null){
            synchronized (Lazy.class) {
                if (LAZY == null) {
                    LAZY = new Lazy(); // 不是一个原子性操作
                    /**
                     * 1. 分配内存空间
                     * 2. 执行构造方法，初始化对象
                     * 3. 把这个对象指向这个空间
                     * 123
                     * 132
                     * 必须加volatile避免指令重排
                     */
                }
            }
        }
        return LAZY;
    }

    // 多线程并发
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        for (int i = 0; i < 10; i++) {
            new Thread(() ->{
                Lazy.getInstance();
            }).start();
        }
        // 反射 破坏单例
        Lazy instance = Lazy.getInstance();
        Constructor<Lazy> declaredConstructor = Lazy.class.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true); // 可访问私有方法
        Lazy lazy = declaredConstructor.newInstance();
        System.out.println(instance);
        System.out.println(lazy);

    }
}
