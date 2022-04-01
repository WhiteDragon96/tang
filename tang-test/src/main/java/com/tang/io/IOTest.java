package com.tang.io;

import java.io.File;
import java.io.IOException;

/**
 * @author tcs
 * @date Created in 2022-03-16
 */
public class IOTest {
    public static void main(String[] args) {
        create01();
    }

    private static void create01() {
        String filePath = "e:\\test01.txt";
        File file = new File(filePath);
        try {
            // 这里file对象，再java程序中，只是一个对象
            // 只有执行了 createNewFile，才会在池畔中创建中构建
            boolean newFile = file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
