package com.tang.tangjuc.function;

import java.util.function.Predicate;

/**
 * 断定型接口：有一个输入参数，返回值只能是 布尔值！
 *
 * @author tcs
 * @date Created in 2021-12-07
 */
public class PredicateDemo {
    public static void main(String[] args) {
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.isEmpty();
            }
        };
        System.out.println(predicate.test(""));
        Predicate<String> predicate1 = (str) -> {return str.isEmpty();};
    }
}
