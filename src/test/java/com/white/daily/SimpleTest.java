package com.white.daily;

import com.white.daily.pojo.Student;
import com.white.daily.pojo.Teacher;
import com.white.daily.utils.PojoUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.cglib.beans.BeanCopier;

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
}
