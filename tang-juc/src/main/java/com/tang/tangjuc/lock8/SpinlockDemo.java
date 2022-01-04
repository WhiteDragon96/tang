package com.tang.tangjuc.lock8;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁
 * @author tcs
 * @date Created in 2021-12-28
 */
public class SpinlockDemo {

    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    // 加锁
    public void myLock(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName()+"===> myLock");

        // 自旋锁
        while (atomicReference.compareAndSet(null,thread)){

        }
    }
    // 解锁
    public void myUnlock(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName()+"===> myUnLock");

        atomicReference.compareAndSet(thread,null);
    }
}
