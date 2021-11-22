package com.white.daily.thread.p5yield;

public class SubThread6 extends Thread{
    @Override
    public void run() {
        long begin = System.currentTimeMillis();
        long sum = 0;
        for (int i = 0; i < 10000000; i++) {
            sum += i;
            Thread.yield();
        }
        long end = System.currentTimeMillis();
        System.out.println("用时：" + (end -begin));
    }
}
