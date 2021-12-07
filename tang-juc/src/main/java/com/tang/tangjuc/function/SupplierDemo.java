package com.tang.tangjuc.function;

import java.util.function.Supplier;

/**
 * 没有参数只有返回值
 *
 * @author tcs
 * @date Created in 2021-12-07
 */
public class SupplierDemo {
    public static void main(String[] args) {
        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return "1024";
            }
        };
        System.out.println(supplier.get());
        Supplier<String> supplier1 = () -> {return "1024";};
        System.out.println(supplier1.get());
    }
}
