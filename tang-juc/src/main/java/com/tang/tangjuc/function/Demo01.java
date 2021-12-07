package com.tang.tangjuc.function;

import java.util.function.Function;

/**
 * Function 函数型接口,有一个输入，一个输出
 * 只要是函数式接口 可以用 Lambda表达式简化
 *
 * @author tcs
 * @date Created in 2021-12-07
 */
public class Demo01 {
    public static void main(String[] args) {
        // 工具类：输出输入的值
        Function function = new Function<String,String>() {
            @Override
            public String apply(String o) {
                return o;
            }
        };
        System.out.println(function.apply("hello"));
        // Lambda 表达式
        Function<String,String> function1 = (str) -> {return str;};
    }
}
