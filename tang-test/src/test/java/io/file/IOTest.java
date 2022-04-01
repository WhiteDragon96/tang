package io.file;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author tcs
 * @date Created in 2022-03-16
 */
public class IOTest {

    File file ;
    @BeforeEach
    public void test(){
        String filePath = "e:\\test01.txt";
        file = new File(filePath);
    }

    @Test
    public void create01() {
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

    @Test
    public void infoFile() {
        String filePath = "e:\\test01.txt";
        File file = new File(filePath);
        System.out.println("文件路径： " + file.getPath());
        System.out.println("绝对路径： " + file.getAbsolutePath());
        System.out.println("文件大小（字节）： " + file.length());
    }

    /**
     * 删除目录
     */
    @Test
    public void deleteFile(){
        if (file.exists()){
            if (file.delete()){
                System.out.println("删除成功");
            }else {
                System.out.println("删除失败");
            }
        }
    }
}
