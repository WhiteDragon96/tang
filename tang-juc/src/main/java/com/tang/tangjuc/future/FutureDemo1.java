package com.tang.tangjuc.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class FutureDemo1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 没有返回值的异步回调
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() ->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+ "runAsync=>Void");
        });
        System.out.println("1111");
        completableFuture.get(); //获取执行结果
        System.out.println("2222");

        // 有返回值的异步回调 supplyAsync
        // 失败返回的是错误信息
        CompletableFuture<Integer> completableFuture1 = CompletableFuture.supplyAsync( () -> {
            System.out.println(Thread.currentThread().getName()+ "runAsync=>Integer");
//            int i= 1/0;
            return 1024;
        });

        Integer integer = completableFuture1.whenComplete((t, u) -> {
            System.out.println("t=>" + t); //正常返回结果
            System.out.println("u=>" + u); // 错误信息 u=>java.util.concurrent.CompletionException: java.lang.ArithmeticException: / by zero
        }).exceptionally((e) -> {
            e.getMessage();
            return 233;
        }).get();
        System.out.println(integer);
    }
}
