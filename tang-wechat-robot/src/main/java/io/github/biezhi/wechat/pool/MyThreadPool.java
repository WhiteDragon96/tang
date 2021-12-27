package io.github.biezhi.wechat.pool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author tcs
 * @date Created in 2021-11-24
 */
@Slf4j
public class MyThreadPool {

    public static ThreadPoolExecutor executor;

    static {
        int corePoolSize = 5;
        int maximumPoolSize = 5;
        long keepAliveTime = 0;
        TimeUnit unit = TimeUnit.SECONDS;
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(500);
        ThreadFactory threadFactory = new NameTreadFactory();
        RejectedExecutionHandler handler = new LogPolicy();
        executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit,
                workQueue, threadFactory, handler);
        printStats(executor);
    }

    static class NameTreadFactory implements ThreadFactory {

        private final AtomicInteger mThreadNum = new AtomicInteger(1);

        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, "tang-thread-" + mThreadNum.getAndIncrement());
        }

    }

    /**
     * 自定义拒绝策略
     */
    public static class LogPolicy implements RejectedExecutionHandler {

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
            doLog(r, e);
        }

        private void doLog(Runnable r, ThreadPoolExecutor e) {
            // 可做日志记录等
            log.error(r.toString() + " rejected");
        }
    }

    /**
     * 线程监控
     * <p>每分钟输出一次线程池的基本内部信息，包括线程数、活跃线程数、完成了多少任务，以及队列中还有多少积压</p>
     *
     * @param threadPool 线程池
     */
    private static void printStats(ThreadPoolExecutor threadPool) {
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(() -> {
            log.info("==============" + Thread.currentThread().getName() + "==============");
            log.info("Pool Size: {}", threadPool.getPoolSize());
            log.info("Active Threads: {}", threadPool.getActiveCount());
            log.info("Number of Tasks Completed: {}", threadPool.getCompletedTaskCount());
            log.info("Number of Tasks in Queue: {}", threadPool.getQueue().size());
            log.info("============================");
        }, 0, 30, TimeUnit.SECONDS);
    }
}
