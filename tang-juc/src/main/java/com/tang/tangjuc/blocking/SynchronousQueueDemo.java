package com.tang.tangjuc.blocking;

import com.tang.tangjuc.pool.MyThreadPool;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * 同步队列
 * 和其他BlockingQueue 不一样 SynchronousQueue 不存储元素
 * put一个元素必须take出来才能在put
 */
public class SynchronousQueueDemo {
    public static void main(String[] args) {
        SynchronousQueue<String> queue = new SynchronousQueue<>();

        MyThreadPool.executor.execute(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " put 1");
                queue.put("1");
                System.out.println(Thread.currentThread().getName() + " put 2");
                queue.put("2");
                System.out.println(Thread.currentThread().getName() + " put 3");
                queue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        MyThreadPool.executor.execute(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + " take " + queue.take());
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + " take " + queue.take());
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + " take " + queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

    }
}
