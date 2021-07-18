package com.white.daily.benchmark;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.white.daily.mock.entity.User;
import com.white.daily.mock.mapper.UserMapper;
import com.white.daily.mock.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Mybatis-plus测试
 *
 * @author tcs
 * @date Created in 2021-05-14
 */
@SpringBootTest
public class WrapperTest {
    @Resource
    private UserMapper userMapper;

    @Resource
    private UserService userService;

    @Test
    public void testSelect() {

        System.out.println("----- 普通查询 lambda------");
        List<User> users = userMapper.selectList(new QueryWrapper<User>().lambda().eq(User::getId, 8));

        System.out.println("----- 带子查询(sql注入) ------");
        List<User> id = userMapper.selectList(new QueryWrapper<User>().inSql("id", "select id from user where username = '德玛西亚'"));
        System.out.println(id);

        System.out.println("----- 带嵌套查询 ------");
        List<User> users1 = userMapper.selectList(new QueryWrapper<User>().nested(i -> i.eq("id", 5).or().eq("id", 10)));

        System.out.println(users1);

        System.out.println("----- 自定义(sql注入) ------");
        List<User> order_by_age_desc = userMapper.selectList(new QueryWrapper<User>().apply("id = 11"));
        List<User> plainUsers5 = userMapper.selectList(new QueryWrapper<User>().apply("id = {0}", 12));
        System.out.println(order_by_age_desc);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setUsername("mybatis-plus");
        user.setAge(21);
        user.setCreateTime(new Date());
        userMapper.update(user,new UpdateWrapper<User>().eq("id",25));
        //不创建User对象
        userMapper.update(null,new UpdateWrapper<User>().lambda().set(User::getUsername,"not Object").set(User::getAge,25).set(User::getCreateTime,LocalDateTime.now()).eq(User::getId,26));

        //使用lambda
        userMapper.update(null,new LambdaUpdateWrapper<User>().set(User::getUsername,"LambdaUpdate").set(User::getAge,26).set(User::getCreateTime,LocalDateTime.now()).eq(User::getId,27));
    }

    @Test
    public void testInsert(){
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            User user = new User();
            user.setUsername(UUID.randomUUID().toString().replace("-",""));
            user.setAge(i);
            user.setCreateTime(new Date());
            users.add(user);
        }
//        userService.insert
    }
}
