package com.tang.tangjuc.lock8;

import java.util.concurrent.TimeUnit;

/**
 * 8锁，关于锁的8个问题
 * 7、1个静态同步方法，一个普通同步方法，一个对象，先打印 发短信？打电话？
 */
public class Test4 {
    public static void main(String[] args) {
        // 两个对象的Class类模板只有一个，static，锁的是Class
        Phone4 phone = new Phone4();
        Phone4 phone2 = new Phone4();

        // 锁的存在
        new Thread(() -> {
            phone.sendSms();
        }, "A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(phone2::call, "B").start();
    }
}

class Phone4 {

    // 静态同步方法 锁的是Class 类模板
    public static synchronized void sendSms() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sendSms");
    }

    // 普通同步方法 锁的是调用者
    public synchronized void call() {
        System.out.println("call");
    }
}
