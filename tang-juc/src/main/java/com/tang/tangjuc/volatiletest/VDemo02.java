package com.tang.tangjuc.volatiletest;

import java.util.concurrent.atomic.AtomicInteger;

// 不保证原子性
public class VDemo02 {
//    private volatile static int num = 0;
    // 原子类的 Integer
    private volatile static AtomicInteger num = new AtomicInteger();

    public  static void add() {
       // num++; //不是一个原子性操作
        num.getAndIncrement();// AtomicInteger的+1方法 用的底层的CAS
    }

    public static void main(String[] args) {
        // 理论上num结果为2 万
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int i1 = 0; i1 < 1000; i1++) {
                    add();
                }
            }).start();
        }

        while (Thread.activeCount() > 2){// main gc 一定有两个线程存活，保证都执行完了
            Thread.yield();
        }
        System.out.println(num);
    }
}
