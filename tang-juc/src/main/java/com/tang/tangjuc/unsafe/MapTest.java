package com.tang.tangjuc.unsafe;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * java.util.ConcurrentModificationException
 *
 * 1、 Map<String, String> map = Collections.synchronizedMap(new HashMap<>(16, 0.75f));
 * 2、 Map<String, String> map = new ConcurrentHashMap<>(16, 0.75f);
 */
public class MapTest {
    public static void main(String[] args) {
        // map 是这样用的吗？ 不是 工作中不用HashMap
        // 默认等价于什么? new HashMap<>(16, 0.75f);
//        Map<String, String> map = new HashMap<>(16, 0.75f);
//        Map<String, String> map = Collections.synchronizedMap(new HashMap<>(16, 0.75f));
        Map<String, String> map = new ConcurrentHashMap<>(16, 0.75f);
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 5));
                System.out.println(map);
            },"t" + i).start();
        }
    }
}
