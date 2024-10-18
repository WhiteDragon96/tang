package com.white.daily.concurrent;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 测试实现Runnable接口的形式创建线程
 */
class MyRunnableTest {
    public static void main(String[] args) {

        System.out.println("args: "+ Arrays.toString(args));
        //3)创建Runnable接口的实现类对象
        MyRunnable myRunnable = new MyRunnable();
        // 4)创建线程他对象
        Thread thread = new Thread(myRunnable);
        // 5)开启线程
        thread.start();

        //当前是main线程
        for (int i = 0; i < 100; i++) {
            System.out.println("main ==>" + i);
        }

        // 有时调用Thread(Runnable)构造方法时，实参也会传递匿名内部类对象
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("sub thread1 -----> " + i);
                }
            }
        });
        thread1.start();
    }

}