package com.tang.tangjuc.lock8;

import java.util.concurrent.TimeUnit;

/**
 * 8锁，关于锁的8个问题
 * 3、两个线程先打印 发短信还是hello？ 1-hello 2-发短信
 * 4、两个对象，两个同步方法，
 */
public class Test2 {
    public static void main(String[] args) {
        // 两个对象，两个调用者，两个调用者
        Phone2 phone = new Phone2();
        Phone2 phone2 = new Phone2();

        // 锁的存在
        new Thread(() -> {
            phone.sendSms();
        }, "A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            phone2.call();
        }, "B").start();
    }
}

class Phone2 {

    // synchronized 锁的对象是方法的调用者！
    // 两个方法用的是一个锁，谁先拿到谁先执行
    public synchronized void sendSms() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sendSms");
    }

    public synchronized void call() {
        System.out.println("call");
    }

    // 这里没有锁;不是同步方法，不受锁的影响
    public void hello() {
        System.out.println("hello");
    }
}
