package com.tang.tangjuc.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallAbleTest {
    public static void main(String[] args) {
        // new Thread(new Runnable)).start();
        // new Thread(new FutureTask<String>(new Callable<String>()).start();
        // new THread(new FutureTask<V>(new Callable<V>()).start();
        new Thread().start();// 怎么启动Callable
        MyThread myThread = new MyThread();
        FutureTask futureTask = new FutureTask(myThread);
        new Thread(futureTask,"A").start();

        try {
            // 获取返回结果
            String o = String.valueOf(futureTask.get());
            System.out.println(o);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class MyThread implements Callable<String>{

    // Callable<V> 的 V 是什么类型就返回什么类型
    @Override
    public String call() throws Exception {
        System.out.println("call()");
        return "call";
    }
}