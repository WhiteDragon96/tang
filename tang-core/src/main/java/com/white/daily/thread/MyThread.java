package com.white.daily.thread;

/**
 * @author tcs
 * @date Created in 2021-07-16
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "正在执行" + " id = " + Thread.currentThread().getId());
        long begin = System.currentTimeMillis();
        long sum = 0;
        for (long i = 0; i <= 10000000000L; i++) {
            sum += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("thread a : " + (end - begin));
    }
}
