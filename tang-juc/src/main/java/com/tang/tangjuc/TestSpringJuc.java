package com.tang.tangjuc;

import com.tang.tangjuc.pool.MyThreadPool;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author tcs
 * @date Created in 2022-03-04
 */
public class TestSpringJuc {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();

        run();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static void run() throws ExecutionException, InterruptedException {
        //supplyAsync方法无入参，但是返回一个String对象。此方法使用了默认的线程池执行异步任务
        CompletableFuture<Long> future = CompletableFuture.supplyAsync(() -> {
            //长时间的计算任务
            try {
                for (int i = 0; i < 1000; i++) {
                    System.out.println(Thread.currentThread().getName());
                }
                TimeUnit.SECONDS.sleep(10);

            } catch (InterruptedException e) {
                    e.printStackTrace();
            }
            System.out.println(1/0);
            return 100L;
        }, MyThreadPool.executor).exceptionally(throwable -> {
            System.out.println(Thread.currentThread().getName());
            return 0L;
        });
        //supplyAsync方法无入参，但是返回一个String对象。此方法使用了默认的线程池执行异步任务
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            //长时间的计算任务
            try {
                for (int i = 0; i < 1000; i++) {
                    System.out.println(Thread.currentThread().getName());
                }
                TimeUnit.SECONDS.sleep(10);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return UUID.randomUUID().toString();
        });

        CompletableFuture.allOf(future).join();
        /*Long s = future.get();
        String s1 = future2.get();
        System.out.println(s);
        System.out.println(s1);*/
    }
}
