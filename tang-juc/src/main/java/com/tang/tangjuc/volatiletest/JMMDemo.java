package com.tang.tangjuc.volatiletest;

import java.util.concurrent.TimeUnit;

public class JMMDemo {
    // 不加volatile程序会死循环
    private volatile static  int num = 0;

    public static void main(String[] args) {
        new Thread( () -> {
            //线程一
            while (num == 0){

            }
        }).start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 线程一不知道num变了
        num = num +1;
        System.out.println(num);
    }
}
