package com.white.daily.benchmark;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.white.daily.mock.entity.User;
import com.white.daily.mock.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author tcs
 * @date Created in 2021-04-02
 */
@SpringBootTest
public class DataBaseTest {

    @Autowired
    private UserMapper userMapper;

    /**
     * 测试 sql中使用foreach 和 foreach插入速度对比
     * 1000轮结果如下
     *  sql foreach result is: 478ms
     * foreach result is: 7132ms
     */
    @Test
    public void addUserTest(){
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            User user = new User();
            user.setUsername(UUID.randomUUID().toString().replace("-",""));
            user.setAge(i);
            users.add(user);
        }
        long sqlForeachStart = System.currentTimeMillis();
        userMapper.addUserList(users);
        long sqlForeachEnd = System.currentTimeMillis();

        long foreachStart = System.currentTimeMillis();
        users.forEach(user -> {
            userMapper.insert(user);
        });
        long foreachEnd = System.currentTimeMillis();

        System.out.println("sql foreach result is: " + (sqlForeachEnd - sqlForeachStart));
        System.out.println("foreach result is: " + (foreachEnd - foreachStart));
    }

    @Test
    public void selectUserTest(){
        User user = new User();
        user.setUsername("10498841f9ec4fb482bf30fb8b00b420");

        long start = System.currentTimeMillis();
//        for (int i = 0; i < 1000; i++) {
            List<User> users = userMapper.selectUser(user);
//        }
        long end = System.currentTimeMillis();

        System.out.println("sum result: " + (end -start));
        System.out.println("result : " + ((end - start )/1000.0));
    }

    @Test
    public void selectUser() {
        List<User> users = userMapper.selectList(new QueryWrapper<User>().last("limit 1"));
        List<User> users1 = userMapper.selectList(new QueryWrapper<User>().lambda().eq(User::getId, 3));
        System.out.println(users1);
    }
}
