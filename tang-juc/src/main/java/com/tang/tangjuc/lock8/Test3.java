package com.tang.tangjuc.lock8;

import java.util.concurrent.TimeUnit;

/**
 * 8锁，关于锁的8个问题
 * 5、增加两个静态的同步方法，只有一个对象，先打印 发短信？
 * 6、两个对象，增加两个静态的同步方法，只有一个对象，先打印 发短信？
 */
public class Test3 {
    public static void main(String[] args) {
        // 两个对象的Class类模板只有一个，static，锁的是Class
        Phone3 phone = new Phone3();
        Phone3 phone2 = new Phone3();

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

// Phone3唯一的一个 Class 对象

class Phone3 {

    // synchronized 所得对象是方法的调用者！
    // static 静态方法
    // 类一加载就有了 Class 模板，锁的是class
    public static synchronized void sendSms() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sendSms");
    }

    public static synchronized void call() {
        System.out.println("call");
    }
}
