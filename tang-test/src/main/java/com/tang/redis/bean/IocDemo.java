package com.tang.redis.bean;

import java.io.Console;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * @author tangcs
 * @Date 2022/4/7
 */
public class IocDemo {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader("E:\\文档\\笔记\\code\\tang\\tang-test\\src\\main\\resources\\mysql.properties"));
        String port = properties.getProperty("username");
        properties.setProperty("password","123456");
        properties.store(new FileWriter("E:\\文档\\笔记\\code\\tang\\tang-test\\src\\main\\resources\\mysql.properties"),null);
        System.out.println(port);
    }
}
