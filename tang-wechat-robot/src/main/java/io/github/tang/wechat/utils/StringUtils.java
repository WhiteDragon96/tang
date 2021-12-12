package io.github.tang.wechat.utils;

import java.util.Random;

/**
 * 字符串工具类
 *
 * @author tangcs
 * @date 2018/1/19
 */
public class StringUtils {

    public static boolean isEmpty(String value) {
        return null == value || value.isEmpty();
    }

    public static boolean isNotEmpty(String value) {
        return null != value && !value.isEmpty();
    }

    public static String random(int count) {
        RandomString gen = new RandomString(count, new Random());
        return gen.nextString();
    }

    public static boolean isBlank(String format) {
        return format == null || format.trim().isEmpty();
    }

}
