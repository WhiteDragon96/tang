package com.white.daily.thread;

/**
 * @author tcs
 * @date Created in 2021-07-07
 */
public class TaskDemo {
    public static void main(String[] args) {
        //创建三个任务
        Runnable printA = new PrintChar('a', 10);
        Runnable printB = new PrintChar('b', 10);
        Runnable print100 = new PrintNum(10);
        //创建三个线程
        Thread thread1 = new Thread(printA);
        Thread thread2 = new Thread(printB);
        Thread thread3 = new Thread(print100);
        //启动三个线程，将同时执行创建的三个任务
        thread1.start();
        thread2.start();
        thread3.start();
    }
}


//此任务将一个字符打印指定次数
class PrintChar implements Runnable {

    private char charToPrint;
    private int times;
    //构造函数
    public PrintChar(char charToPrint, int times) {
        this.charToPrint = charToPrint;
        this.times = times;
    }
    //重写接口Runable中的run方法，告诉系统此任务的内容
    @Override
    public void run() {
        for (int i = 0; i < times; i++) {
            System.out.print(charToPrint);
        }
    }
}
//此任务打印1~n
class PrintNum implements Runnable {
    private int lastNum;

    public PrintNum(int lastNum) {
        this.lastNum = lastNum;
    }

    @Override
    public void run() {
        for (int i = 0; i < lastNum; i++) {
            System.out.print(" " + i);
        }
    }
}