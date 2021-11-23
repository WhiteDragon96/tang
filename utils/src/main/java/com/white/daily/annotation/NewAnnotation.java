package com.white.daily.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author tcs
 * @date Created in 2021-03-30
 */
@Target(ElementType.METHOD) // 使用地方 方法上、类上
@Retention(RetentionPolicy.RUNTIME) //注解保持策略，包括三种(编译器丢弃、保留在class文件中，但JVM会忽略它、保留在class文件中，JVM会读取它)
@Documented //让它定制文档化功能,使用此注解时必须设置RetentionPolicy为RUNTIME
@Inherited //允许被继承
public @interface NewAnnotation {

    public enum FontColor {
        // 蓝色
        BLUE,
        RED,
        GREEN
    };

    String value();

    FontColor fontColor() default FontColor.RED;
}
