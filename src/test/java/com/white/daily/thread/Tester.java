package com.white.daily.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author tcs
 * @date Created in 2021-07-19
 */
@Slf4j
public class Tester {
    private static Logger logger = LogManager.getLogger(Tester.class);

    public static void main(String[] args) {
        new Tester().doSome(10);
    }

    public  void doSome(int num){
        //启用线程池(最大不能超过500个)
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("findOrderWithScenePlatform-pool-%d").build();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors() * 2,//核心池大小
                5000,//最大池大小
                200,//线程最大空闲时间,超过此空闲时间可以被收回
                TimeUnit.MILLISECONDS, //最大空闲时间的单位
                new ArrayBlockingQueue<Runnable>(10)//用于保存执行任务的队列,可以选择其他不同的队列来做任务管理
                ,threadFactory
        );

        CountDownLatch n = new CountDownLatch(num);
        long begin = System.currentTimeMillis();
        for(int i=0;i<num;i++){
            //启动一个任务
            Task myTask = new Task(i,n);
            executor.execute(myTask);
        }
        long end = System.currentTimeMillis();

        long begin1 = System.currentTimeMillis();
        for (int j = 0; j < num; j++) {
            for (int i = 0; i < 1000; i++) {
                System.out.println(Thread.currentThread().getName() + "----->" + i);

            }
        }
        long end1 = System.currentTimeMillis();
        System.out.println("线程池用时：" + (end - begin));
        System.out.println("main方法用时：" + (end1 - begin1));


        logger.info("全部执行的任务数量:"+executor.getTaskCount());
        logger.info("已完成的任务数量:"+executor.getCompletedTaskCount());
        logger.info("曾经创建过最大的线程数量:"+executor.getPoolSize());
        logger.info("活动的线程数量:"+executor.getPoolSize());

        //等待所有线程完毕
        try {
            n.await();
        } catch (InterruptedException e) {
            logger.error(e);
        }
        //关闭线程池
        executor.shutdown();

    }

    class Task implements Runnable {

        private int taskNum;
        CountDownLatch n;

        public Task(int num, CountDownLatch n) {
            this.taskNum = num;
            this.n= n;
        }

        public void run() {
            try{
                //TODO 做你的事情,擦桌子
                for (int i = 0; i < 1000; i++) {
                    System.out.println(Thread.currentThread().getName() + "----->" + i);

                }
            }catch(Exception e){
                logger.error(e);
                logger.info("task "+taskNum+"执行失败");
            }

            //事情干完了
            n.countDown();
        }
    }
}
