package com.white.daily.thread;

/**
 * 使用线程休眠 Thread.sleep 完成一个简易的计时器
 *
 * @author tcs
 * @date Created in 2021-07-16
 */
public class SimpleTimer {
    public static void main(String[] args) {
        int remaining = 60; // 从60s开始

        // 读取main方法的参数
        if (args.length == 1) {
            remaining = Integer.parseInt(args[0]);
        }

        while (true) {
            System.out.println("Remaining: " + remaining);
            remaining--;
            if (remaining<0){
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Done!!");
    }
}
