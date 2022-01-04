package com.tang.tangjuc.lock8;

import java.util.concurrent.TimeUnit;

/**
 * @author tcs
 * @date Created in 2021-12-28
 */
// synchronized
public class Test5 {
    public static void main(String[] args) {
        Phone5 phone = new Phone5();
        new Thread(() ->{
            phone.sms();
        },"A").start();

        new Thread(() ->{
            phone.sms();
        },"B").start();
    }


}
class Phone5 {

    public synchronized void sms() {
        System.out.println(Thread.currentThread().getName() + "sms");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        call();
    }

    public synchronized void call() {
        System.out.println(Thread.currentThread().getName() + "call");
    }
}
