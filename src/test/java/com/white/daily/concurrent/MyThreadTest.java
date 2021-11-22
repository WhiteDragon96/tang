package com.white.daily.concurrent;

import static org.junit.jupiter.api.Assertions.*;

class MyThreadTest {
    public static void main(String[] args) {
        System.out.println("JVM启动main线程，main线程执行main方法");
        // 3)船舰子线程对象
        MyThread myThread = new MyThread();
        /* 4)启动线程
             start()方法调用结束并不意味子线程开始运行 只是告诉可以执行了
             新开启的线程会执行run()方法
             如果开启多个线程，start()调用的顺序并不一定就是线程启动的顺序
        */
        myThread.start();
    }
}