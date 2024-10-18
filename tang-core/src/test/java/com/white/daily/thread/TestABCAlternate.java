package com.white.daily.thread;

/**
 * @author tcs
 * @date Created in 2021-07-16
 */
public class TestABCAlternate {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("A");
            }
        },"A");

    }
}
