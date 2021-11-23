package com.white.daily.thread.p8daemon;

public class DaemonTest {
    public static void main(String[] args) {
        SubDaemonThread subDaemonThread = new SubDaemonThread();
        subDaemonThread.setDaemon(true);
        subDaemonThread.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("main ==>" + i);
        }
    }
}
