package com.white.daily.thread.p5yield;

public class YieldTest {
    public static void main(String[] args) {

        //现在开启一个子线程，计算累加和
        SubThread6 subThread6 = new SubThread6();
        subThread6.start();

        // 在main方法中计算累加和
        long begin = System.currentTimeMillis();
        long sum = 0;
        for (int i = 0; i < 10000000; i++) {
            sum += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("main方法用时：" + (end - begin));
    }
}
