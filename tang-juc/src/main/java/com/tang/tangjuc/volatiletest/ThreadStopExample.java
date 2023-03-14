package com.tang.tangjuc.volatiletest;

import java.util.concurrent.TimeUnit;

/**
 * @author tcs
 * @date 2022/12/20  10:18
 */
public class ThreadStopExample {
    private static boolean stop;

    public static void main(String[] args) throws InterruptedException {
        Thread workThread = new Thread(new Runnable() {
            public void run() {
                int i= 0;
                while (!stop) {
                    i++;
                    try{
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        workThread.start();
        TimeUnit.SECONDS.sleep(3);
        stop = true;
    }
}
