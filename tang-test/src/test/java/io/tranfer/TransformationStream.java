package io.tranfer;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TransformationStream {
    public static void main(String[] args) throws Exception {
        // 读取e:\\test.txt 文件到程序
        String filePath = "e:\\a1.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        // 1、默认是按照，UTF-8来读取的

        String s = bufferedReader.readLine();
        System.out.println("读取到的内容：" + s);
        bufferedReader.close();
    }

    @Test
    public void read() throws IOException {
        String filePath = "e:\\a1.txt";
        InputStreamReader gbk = new InputStreamReader(new FileInputStream(filePath), "gbk");
        BufferedReader bufferedReader = new BufferedReader(gbk);
        String s = bufferedReader.readLine();
        System.out.println(s);
        bufferedReader.close();
    }

    @Test
    public void readProperties() throws IOException {
        String filePath = "src\\main\\resources\\application.yml";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        String readLine;
        while ((readLine = bufferedReader.readLine()) != null) {
            String[] split = readLine.split(":");
            System.out.println(split[0]+": ");
        }
        bufferedReader.close();
    }
}
