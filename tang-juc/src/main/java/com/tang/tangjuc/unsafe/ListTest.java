package com.tang.tangjuc.unsafe;

import com.tang.tangjuc.pool.MyThreadPool;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

// java.util.ConcurrentModificationException
public class ListTest {
    public static void main(String[] args) {
        // 并发下 ArrayList 不安全的
        /**
         * 解决方案：
         * 1、List<String> list = new Vector<>();
         * 2、List<String> list = Collections.synchronizedList(new ArrayList<>());
         * 3、List<String> list = new CopyOnWriteArrayList<>();
         *  CopyOnWrite 写入时复制 COW 计算机程序设计领域的一种优化策略；
         *  多个线程调用的时候，list，读取的时候，固定的，写入（覆盖）
         *  在写入的时候避免覆盖，造成数据问题 读写分离
         *  CopyOnWriteArrayList 和 Vector 比较：
         *
         */
//        List<String> list = new ArrayList<>();
//        List<String> list = new Vector<>();
//        List<String> list = Collections.synchronizedList(new ArrayList<>());
        List<String> list = new CopyOnWriteArrayList<>();

        for (int i = 0; i < 10; i++) {
            MyThreadPool.executor.execute(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 5));
                System.out.println(Thread.currentThread().getName() + ": " + list);
            });
        }
    }
}
