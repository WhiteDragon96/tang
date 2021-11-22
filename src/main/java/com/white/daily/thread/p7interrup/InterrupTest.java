package com.white.daily.thread.p7interrup;

public class InterrupTest {
    public static void main(String[] args) {
        SubThread2 subThread = new SubThread2();
        subThread.start(); //开启子线程

        // 当前线程是main线程
        for (int i = 0; i < 100; i++) {
            System.out.println("main ==>" +i);
        }
        //中断子线程
        subThread.interrupt();
    }
}
