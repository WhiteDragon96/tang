package com.white.daily.thread;

import org.junit.jupiter.api.Test;

/**
 * @author tcs
 * @date Created in 2021-07-16
 */
public class SubDaemonThread extends Thread {
    @Override
    public void run() {
        super.run();
        while (true) {
            System.out.println("sub thread.....");
        }
    }

    /**
     * Java 中的线程分为用户线程与守护线程
     * 守护线程是为其他线程提供服务的线程,如垃圾回收器(GC)就是一 个典型的守护线程
     * 守护线程不能单独运行, 当 JVM 中没有其他用户线程,只有守护线 程时,守护线程会自动销毁, JVM 会退出
     */
    public static void main(String[] args) {
        SubDaemonThread subDaemonThread = new SubDaemonThread();
        subDaemonThread.setDaemon(true); //设置守护线程  在线程启动前
        subDaemonThread.start();

        //当前线程为 main 线程
        for (int i = 1; i <= 10; i++) {
            System.out.println("main== " + i);
        }
        // 当 main 线程结束, 守护线程 thread 也销毁了
    }

    @Test
    public void getStateTest(){
        MyThread myThread = new MyThread();
        System.out.println(myThread.getState());
        myThread.start();
        System.out.println(myThread.getState());
    }
}
