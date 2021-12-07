package com.tang.tangjuc.pool;

import java.io.IOException;
import java.util.concurrent.*;

//Executors 工具类、3大方法
// 使用线程池之后，使用线程池来创建线程
public class Demo1 {
    public static void main(String[] args) throws IOException {
//        ExecutorService pool = Executors.newSingleThreadExecutor();//单个线程
//        ExecutorService pool = Executors.newFixedThreadPool(5);//固定线程池
//        ExecutorService pool = Executors.newCachedThreadPool();//缓存线程池 可伸缩
        // 自定义线程池

        // 获取服务器核数
        System.out.println(Runtime.getRuntime().availableProcessors());
        Runtime.getRuntime().exec("ipconfig");
        ExecutorService pool = new ThreadPoolExecutor(
                2,
                5,
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());// 默认拒绝策略：不处理这个，直接抛异常

        try {
            for (int i = 0; i < 9; i++) {
                // 使用线程池之后，使用线程池来创建线程
                pool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "执行了");
                });
            }
        } finally {
                // 线程池用完，程序结束，关闭线程池
            pool.shutdown();
        }


    }
}
