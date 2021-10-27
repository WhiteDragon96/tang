package com.white.daily.lambda;

import com.white.daily.mock.entity.User;
import com.white.daily.netty.PlainOioServer;
import com.xxl.job.core.util.DateUtil;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 *
 * 测试链接：https://mp.weixin.qq.com/s/66_D3kiT9UQdaORYEDcVKw
 * @author tcs
 * @date Created in 2021-10-18
 */
public class LambdaTest {

    @Test
    public void test(){
        Predicate<Integer> predicate = x -> x>18;
        User user = new User(1, "ttt", 19, new Date());
        boolean test = predicate.test(user.getAge());
        System.out.println("ttt的年龄大于18吗"+ test);

        Consumer<String> consumer = System.out::println;
        consumer.accept("我命由我不由天");

        Function<User, String> function = User::getUsername;
        String name = function.apply(user);
        System.out.println(name);

        Supplier<Integer> supplier =
                () -> Integer.valueOf(BigDecimal.TEN.toString());
        System.out.println(supplier.get());
    }

}
