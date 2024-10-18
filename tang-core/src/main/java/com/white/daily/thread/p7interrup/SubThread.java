package com.white.daily.thread.p7interrup;

public class SubThread extends Thread{

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 1000; i++) {
            System.out.println("sub thread -->" + i);
        }
    }
}
