package com.white.daily.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author tcs
 * @date Created in 2021-07-09
 */
public class TestRun {
    public static void main(String[] args) throws InterruptedException {
        Runner1 r1 = new Runner1();
        Thread thread = new Thread(r1);
        thread.setName("改名线程");
        Runner1 r2= new Runner1();
        Runner1 r3= new Runner1();
//        r.run();
        /*Thread thread = new Thread(r);
        thread.start();
        // 线程池创建线程
        ExecutorService executorService = Executors.newCachedThreadPool();
        Thread.sleep(1000);
        executorService.execute(r);*/

        // 创建数组型缓冲等待队列
        BlockingQueue<Runnable> bq = new ArrayBlockingQueue<Runnable>(10);
        // ThreadPoolExecutor:创建自定义线程池，池中保存的线程数为3，允许最大的线程数为6
        ThreadPoolExecutor tpe = new ThreadPoolExecutor(3, 6, 50, TimeUnit.MILLISECONDS, bq);
        tpe.execute(r1);
        tpe.execute(r2);
        tpe.execute(r3);
        tpe.execute(() ->{
            for (int i = 0; i < 100; i++) {
                System.out.println("线程： " + Thread.currentThread().getName());
            }
        });
        thread.start();



        // 关闭自定义线程池
        tpe.shutdown();
        for (int i = 0; i < 100; i++) {
            System.out.println("进入Main Thread运行状态");
        }
    }
}

class Runner1 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "正在被执行");
        }
    }
}
