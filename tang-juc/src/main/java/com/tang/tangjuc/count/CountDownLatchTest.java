package com.tang.tangjuc.count;

import java.util.concurrent.CountDownLatch;

// 计数器
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        // 总数是6
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " Go out");
                countDownLatch.countDown(); //数量-1
            }, "线程" + i).start();
        }
        countDownLatch.await(); //等待计数器归零，然后再向下执行
        System.out.println("close the door");
    }
}
