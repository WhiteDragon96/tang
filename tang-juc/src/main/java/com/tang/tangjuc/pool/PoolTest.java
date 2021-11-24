package com.tang.tangjuc.pool;


/**
 * @author tcs
 * @date Created in 2021-11-24
 */
public class PoolTest {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            MyThreadPool.executor.execute(() -> {
                String name = Thread.currentThread().getName();
                System.out.println(name + " start");
                MyThreadPool.executor.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + " end");
                });
            });
        }
        for (int i = 0; i < 10; i++) {
            final int temp = i;
            MyThreadPool.executor.execute(() -> {
                System.out.println(Thread.currentThread().getName() + temp);
            });
        }
    }
}
