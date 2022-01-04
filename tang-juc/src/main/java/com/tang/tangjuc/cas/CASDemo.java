package com.tang.tangjuc.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author tcs
 * @date Created in 2021-12-27
 */
public class CASDemo {

    // CAS compareAndSet：比较并交换！
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(2020);

        // 对于我们平时写的SQL：乐观锁
        // 期望、更新
        // public final boolean compareAndSet(int expect, int update)
        // 如果我期望的值达到了，那么就更新，否则，就不更新
        // ============捣乱的线程============
        /*System.out.println(atomicInteger.compareAndSet(2020, 2021));
        System.out.println(atomicInteger.get());

        System.out.println(atomicInteger.compareAndSet(2021, 2020));
        System.out.println(atomicInteger.get());

        // ==============期待的线程==============
        System.out.println(atomicInteger.compareAndSet(2020, 6666));
        System.out.println(atomicInteger.get());*/

        // 如果泛型是一个包装类，注意对象的引用问题
        AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(1,1);

        new Thread(() ->{
            int stamp = atomicStampedReference.getStamp(); //获得版本号
            System.out.println("a1=>"+stamp);

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(atomicStampedReference.compareAndSet(1,2,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1));
            System.out.println("a2=>"+atomicStampedReference.getStamp());
            System.out.println(atomicStampedReference.compareAndSet(2,1,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1));
            System.out.println("a3=>"+atomicStampedReference.getStamp());

        },"a").start();

        new Thread(() ->{
            int stamp = atomicStampedReference.getStamp(); //获得版本号
            System.out.println("b1=>"+stamp);
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(atomicStampedReference.compareAndSet(1,66,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1));
            System.out.println("b2=>"+atomicStampedReference.getStamp());
        },"b").start();
    }
}
