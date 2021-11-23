package com.tang.tangjuc.unsafe;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * 同理可证 java.util.ConcurrentModificationException
 *
 * 1、Set<String> set = Collections.synchronizedSet(new HashSet<>());
 */
public class SetTest {
    public static void main(String[] args) {
//        Set<String> set = new HashSet<>();
        Set<String> set = Collections.synchronizedSet(new HashSet<>());
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(set);
            }, "t" + i).start();
        }
    }
}
