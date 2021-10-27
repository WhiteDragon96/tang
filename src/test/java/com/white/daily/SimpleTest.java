package com.white.daily;

import com.alibaba.fastjson.JSON;
import com.white.daily.mock.entity.Account;
import com.white.daily.mock.entity.User;
import com.white.daily.netty.NettyOioServer;
import com.white.daily.netty.PlainNioServer;
import com.white.daily.netty.PlainOioServer;
import com.white.daily.pojo.Student;
import com.white.daily.pojo.Teacher;
import com.white.daily.util.HttpUtil;
import com.white.daily.util.PojoUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author tcs
 * @date Created in 2021-03-12
 */
@SpringBootTest
public class SimpleTest {

    @Test
    public void testGetClass() {
        Student student = new Student("张三", 10, "男");
        Student student1 = new Student();
        Student student2 = new Student();
        Student student3 = new Student();
        Teacher teacher = new Teacher("迪丽热巴",20,"女",1000);
        PojoUtils.mergeObject(student, student1);
        PojoUtils.mergeObject(student, teacher);
        BeanUtils.copyProperties(teacher, student3);
//        teacher.setSalary(10000.0);

        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);
    }

    @Test
    public void testHttpUtil(){
        String s = HttpUtil.doGet("https://zhly.lyj.zj.gov.cn:8081/api/wap/getrgfys","2020-10-1","2021-3-16");
        Object parse = JSON.parse(s);

        System.out.println(parse);
        System.out.println(s);
    }

    @Test
    public void testFor() throws Exception {
        for (int i = 0; i < 100; i++) {
            if (i == 10){
                continue;
            }
            System.out.println(i);
        }
    }

    @Test
    public void testGrouping(){
        List<Account> accounts = new ArrayList<>();
        Account account = new Account(1,"张三",11.0);
        Account account1 = new Account(2,"张三",2.2);
        Account account2 = new Account(1, "张三", 5.0);
        accounts.add(account);
        accounts.add(account1);
        accounts.add(account2);
        List<Integer> collect = accounts.stream().map(Account::getId).collect(Collectors.toList());
        String s = collect.toString();
        System.out.println(s);
        List<Account> accountList = new ArrayList<>();

        accounts.parallelStream().collect(Collectors.groupingBy(a ->(a.getName() + a.getId()),Collectors.toList())).forEach(
                (id,transfer) -> {
                    transfer.stream().reduce((a,b)-> new Account(a.getId(),a.getName(),a.getMoney()+b.getMoney())).ifPresent(accountList::add);
                }
        );
        System.out.println(accountList);
    }


    @Test
    public void testBio() throws IOException {
        new PlainOioServer().serve(2);
    }

    @Test
    public void testNio() throws IOException {
        new PlainNioServer().serve(3);
    }


    @Test
    public void testNetty() throws Exception {
        new NettyOioServer().server(444);
    }
}
