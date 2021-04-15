package com.white.daily.collection;

import com.white.daily.pojo.User;
import lombok.var;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.Stack;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author tcs
 * @date Created in 2021-04-14
 */
public class StreamDemo {
    public static void main(String[] args) throws IOException {

//        StreamToObject();
        intermediate();
    }

    private static User print(User user){
        System.out.println(user);
        return user;
    }

    private static void streamInit(){
        // 1. Individual values

        Stream stream = Stream.of("a", "b", "c");

        // 2. Arrays

        String [] strArray = new String[] {"a", "b", "c"};

        stream = Stream.of(strArray);

        stream = Arrays.stream(strArray);

        // 3. Collections

        List<String> list = Arrays.asList(strArray);

        stream = list.stream();
    }

    private static void StreamToObject(){

        Stream stream = Stream.of("a", "b", "c");

        // 1. Array
        String[] strArray = (String[]) stream.toArray(String[]::new);

        // 2. Collection
        List<String> list = (List<String>) Arrays.stream(strArray).collect(Collectors.toList());

        List<String> list2 = (List<String>) list.stream().collect(Collectors.toCollection(ArrayList::new));

        Set set1 = (Set) list.stream().collect(Collectors.toSet());

        Stack stack1 = (Stack) list.stream().collect(Collectors.toCollection(Stack::new));

        // 3. String
        String str = list.stream().collect(Collectors.joining()).toString();

    }

    private static void intermediate() throws IOException {
        User user1 = new User(1,"张三",18);
        User user2 = new User(2,"李四",19);
        User user3 = new User(3,"王五",20);
        List<User> userList = new ArrayList<>();
        userList.add(user1);

        userList.add(user3);
        userList.add(user2);

        // map/flatMap
        List<User> collect = userList.stream().map(StreamDemo::fixUser).collect(Collectors.toList());

        // filter
        userList.stream().filter(user -> user.getAge()<20).forEach(user -> System.out.println("filter" + user));
        // foreach
        userList.stream().filter(user -> user.getAge()>18).forEach(System.out::println);
        // peek
        userList.stream().peek(System.out::println).peek(System.out::println);
        //findFirst 这是一个 terminal 兼 short-circuiting 操作，它总是返回 Stream 的第一个元素，或者空。
        Optional<User> first = userList.stream().findFirst();
        /*boolean present = first.isPresent();
        var user = first.get();
        Optional.of(first).ifPresent(System.out::println);
*/
        // limit 返回 Stream 的前面 n 个元素；skip 则是扔掉前 n 个元素
        userList.stream().limit(1).forEach(user -> System.out.println("limit: " + user));
        userList.stream().skip(2).forEach(user -> System.out.println("skip: " + user));
        userList.stream().forEach(System.out::println);
        userList.stream().sorted(Comparator.comparing(User::getAge)).limit(2).forEach(user -> System.out.println("sorted: " + user));

        userList.stream().map(User::getUsername).collect(Collectors.toList()).forEach(System.out::println);
        User user10 = userList.stream().max(Comparator.comparing(User::getAge)).get();
        System.out.println(user1);
        BufferedReader bufferedReader = new BufferedReader(new FileReader("E:\\文档\\笔记\\node的安装及使用.md"));
        int asInt = bufferedReader.lines().mapToInt(String::length).max().getAsInt();

        BufferedReader br = new BufferedReader(new FileReader("E:\\文档\\笔记\\node的安装及使用.md"));
        List<String> strings = br.lines().flatMap(line -> Stream.of(line.split(" ")))
                .filter(word -> word.length() > 0).map(String::toUpperCase).distinct().sorted()
                .collect(Collectors.toList());

        boolean b = userList.stream().allMatch(uesr -> uesr.getAge() > 18);
        boolean b1 = userList.stream().anyMatch(user -> user.getAge() > 18);
        System.out.println(b1);
        System.out.println(b);
    }

    private static User fixUser(User user){
        if (user.getAge()<20){
            user.setUsername("未成年");
        }
        return user;
    }
}
