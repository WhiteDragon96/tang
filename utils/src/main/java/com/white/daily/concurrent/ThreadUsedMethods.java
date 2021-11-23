package com.white.daily.concurrent;

/**
 * 线程常用方法
 */
public class ThreadUsedMethods {
    /**
     * 1) currentThread
     *      Thread.currentThread()方法可以获得当前线程
     *      Java中的任何一段代码都是执行在某个线程当中的，执行当前代码的线程就是当前线程
     */
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main方法打印当前线程名称：" + Thread.currentThread().getName());
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("run方法打印当前线程的名称：" + Thread.currentThread().getName());
            }
        });
        thread.start();
        thread.run(); // run方法打印当前线程的名称：main 直接调用是主线程调用的没有开启新线程
        thread.setName("设置线程名称");
        Thread thread1 = new Thread(thread);
        thread1.start();
        // isAlive
        Thread thread2 = new Thread(thread);
        System.out.println("begin==" + thread2.isAlive());
        thread2.start(); //这里面线肯定是活的
        System.out.println("end==" + thread2.isAlive()); //这里结果不一定

    }
}
