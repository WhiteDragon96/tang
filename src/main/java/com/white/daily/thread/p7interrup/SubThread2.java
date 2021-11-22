package com.white.daily.thread.p7interrup;

public class SubThread2 extends Thread{

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 1000; i++) {
            //判断线程中断标志 是否具有线程中断标志
            if (this.isInterrupted()){
                System.out.println("当前线程中断标志为true，我要推出了");
                break; //中断循环，run()方法体执行完毕，子线程运行完毕
            }
            System.out.println("sub thread -->" + i);
        }
    }
}
