package com.white.daily.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author tcs
 * @date Created in 2021-03-30
 */
public class ReadAnnotationInfoTest {
    public static void main(String[] args) throws ClassNotFoundException {
        // 测试AnnotationTest类，得到此类的类对象
        Class<?> c = Class.forName("com.white.daily.annotation.AnnotationTest");
        // 获取该类所声明的方法
        Method[] declaredMethods = c.getDeclaredMethods();
        // 声明注解集合
        Annotation[] annotations;
        // 遍历所有方法得到各方法上的注解信息
        for (Method method : declaredMethods) {
            // 获取每个方法上面所声明的所有注解信息
            annotations = method.getDeclaredAnnotations();
            //再遍历所有注解，打印基本信息
            for (Annotation annotation : annotations) {
                System.out.println("方法名为： " + method.getName() + "上面的注解为： " + annotation.annotationType().getSimpleName());
                Method[] declaredMethods1 = annotation.annotationType().getDeclaredMethods();
                // 遍历注解所有变量
                for (Method method1 : declaredMethods1) {
                    System.out.println("注解的变量名为： " + method1.getName());
                }
            }
        }
    }
}
