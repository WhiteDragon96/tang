package com.tang.tangjuc.function;

import java.util.function.Consumer;

/**
 * 只有输入没有返回值
 *
 * @author tcs
 * @date Created in 2021-12-07
 */
public class ConsumerDemo {
    public static void main(String[] args) {
        // 打印字符串
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String o) {
                System.out.println(o);
            }
        };
        consumer.accept("hello");
        Consumer<String> consumer1 = (str) -> {
            System.out.println(str);
        };
        consumer1.accept("world");
    }
}
