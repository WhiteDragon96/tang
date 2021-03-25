package com.white.daily;

import com.alibaba.fastjson.JSON;
import com.white.daily.pojo.Student;
import com.white.daily.pojo.Teacher;
import com.white.daily.util.HttpUtil;
import com.white.daily.util.PojoUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;

/**
 * @author tcs
 * @date Created in 2021-03-12
 */
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
}
