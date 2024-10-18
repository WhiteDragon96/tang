package com.white.daily.design.builder;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author tcs
 * @date Created in 2021-04-27
 */
class TaskTest {

    public static void main(String[] args) {
        Task task = new Task.TaskBuilder(1239878L,"迪丽热巴").build();
        Task task1 = new Task.TaskBuilder(9527L,"古力娜扎").status(1).type(2).build();
        System.out.println(task1);
        System.out.println(task);
    }

}