package com.tang.tangjuc.blocking;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueTest  {
    public static void main(String[] args) throws Exception {
        // Collection
        // List
        // BlockingQueue
//        test1();
        test4();
    }

    /**
     * 抛出异常
     */
    public static void test1(){
        //队列大小
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));

        System.out.println("-----------------------");
        // 抛出异常  Queue full
//        System.out.println(blockingQueue.add("d"));
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());

        // 抛出异常  Queue empty
        //        System.out.println(blockingQueue.remove());
    }

    /**
     * 不抛出异常
     */
    public static void test2(){
        //队列大小
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        // 不跑出异常 fasle
        System.out.println(blockingQueue.offer("d"));

        System.out.println("-----------------------");

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        // 不抛出异常 null
        System.out.println(blockingQueue.poll());
    }

    /**
     * 等待，阻塞（一直阻塞）
     */
    public static void test3() throws Exception {
        //队列大小
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);

        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
        // 等待一直卡在这里
        blockingQueue.put("d");

        System.out.println("-----------------------");

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        // 不抛出异常 null
        System.out.println(blockingQueue.poll());
    }

    /**
     * 等待，阻塞（超时退出）
     */
    public static void test4() throws Exception {
        //队列大小
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);

        blockingQueue.offer("a");
        blockingQueue.offer("b");
        blockingQueue.offer("c");
        // 等待 2s 之后退出
        blockingQueue.offer("d",2, TimeUnit.SECONDS);

        System.out.println("-----------------------");

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        // 不抛出异常 null
        System.out.println(blockingQueue.poll(2,TimeUnit.SECONDS));
    }
}
