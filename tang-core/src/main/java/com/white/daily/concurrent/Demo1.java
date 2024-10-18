package com.white.daily.concurrent;

/**
 * @author tcs
 * @date Created in 2021-04-15
 */
public class Demo1 {
    public static void main(String[] args) {

    }
}

class Pig implements Runnable{

    int n=0;
    int times=0;
    public Pig(int n)
    {
        this.n=n;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
            }catch (Exception e){

            }
        }
    }
}