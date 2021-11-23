package com.white.daily.thread;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 线程的getId()
 * @author tcs
 * @date Created in 2021-07-16
 */
class TaskDemoTest {
    public static void main(String[] args) {
        System.out.println("thread name:" + Thread.currentThread().getName() +" id = " + Thread.currentThread().getId());
        for (int i = 0; i < 10; i++) {
            new MyThread().start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * setPriority() 线程优先级
     */
    @Test
    public void test(){
        MyThread myThread = new MyThread();
        myThread.setPriority(1);
        myThread.setName("优先级为1");
        myThread.start();
        MyThread myThread1 = new MyThread();
        myThread1.setPriority(10);
        myThread1.setName("优先级为10");
        myThread1.start();
    }
}