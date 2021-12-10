package com.tang.tangjuc.stream;


import java.util.Arrays;
import java.util.List;

/**
 *  题目要求：一分钟内完成此题，只能用一行代码实现！
 *  现在有5个用户！筛选；
 *  1、ID 必须是偶数
 *  2、年龄必须大于23岁
 *  3、用户名转为大写字母率
 *  4、用户名字母倒着排序
 *  5、只输出一个用户!
 */
public class StreamDemo {
    public static void main(String[] args) {
        User user1 = new User(1,"a",21);
        User user2 = new User(2,"b",22);
        User user3 = new User(3,"c",23);
        User user4 = new User(4,"d",24);
        User user5 = new User(6,"e",25);
        User user6 = new User(6,"e",20);
        List<User> list = Arrays.asList(user1, user2, user3, user4,user5,user6);

        list.stream()
                .filter(user -> {return user.getId()%2==0;})
                .filter(user -> {return user.getAge()>23;})
                .map(user -> {return user.getName().toUpperCase();})
                .sorted((u1,u2) -> { return ((String) u1).compareTo(u2);})
                .forEach(System.out::println);

        long count = list.stream()
                .mapToInt(User::getAge)
                .distinct()
                .count();
        list.stream().forEach(user -> {
            System.out.println(user.getAge());
        });
        list.stream().forEachOrdered(user -> {
            System.out.println(user.getAge());
        });



    }
}
