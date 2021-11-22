package com.white.daily.thread.p8daemon;

public class SubDaemonThread extends Thread{
    @Override
    public void run() {
        super.run();
        while (true){
            System.out.println("sub thread...");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
