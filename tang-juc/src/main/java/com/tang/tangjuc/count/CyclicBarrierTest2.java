package com.tang.tangjuc.count;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 同步屏障
 * <p>
 * CyclicBarrier的字面意思是可循环使用（Cyclic）的屏障（Barrier）。
 * 它要做的事情是，让一 组线程到达一个屏障（也可以叫同步点）时被阻塞，
 * 直到最后一个线程到达屏障时，屏障才会开门，所有被屏障拦截的线程才会继续运行。
 *
 * @author tcs
 * @date 2023/03/16  15:56
 */
public class CyclicBarrierTest2 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        final String count = "0";
        CyclicBarrier barrier = new CyclicBarrier(2, () -> {
            System.out.println("All threads have arrived at the barrier.");
        });

        executorService.execute(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " is waiting at the barrier.");
                barrier.await();
                System.out.println(Thread.currentThread().getName() + " has passed the barrier.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        executorService.execute(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " is waiting at the barrier.");
                barrier.await();
                System.out.println(Thread.currentThread().getName() + " has passed the barrier.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        int numberWaiting = barrier.getNumberWaiting();
        System.out.println(numberWaiting);
    }


}
