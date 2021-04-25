package com.white.daily;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author tcs
 * @date Created in 2021-04-25
 */
public class VolatileTest {
    private volatile static int a = 0;
    private static int cnt = 0;

    public synchronized static void test() {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        int andSet = atomicInteger.getAndSet(3);

        if (a == 0) {
            a = 1;
            cnt++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[2];
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 2; j++) {
                threads[j] = new Thread(VolatileTest::test);
            }
            for (Thread thread : threads) {
                thread.start();
            }
            for (Thread thread : threads) {
                thread.join();
            }
            if (cnt == 2) {
                System.out.println("false!");
            }
            a = 0;
            cnt = 0;
        }
        System.out.println("finish");
    }
}
