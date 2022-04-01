package io.inputstream;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author tcs
 * @date Created in 2022-03-18
 */
public class BufferReaderTest {

    @SneakyThrows
    @Test
    public void reader(){
        BufferedReader bufferedReader = new BufferedReader(new FileReader("e:\\io\\test.txt"));
        String readLine;
        while ((readLine = bufferedReader.readLine()) !=null){
            System.out.println(readLine);
        }
        bufferedReader.close();
    }

    /**
     * BufferedWriter 的使用
     */
    @Test
    @SneakyThrows
    public void writerTest(){
        String filePath = "e:\\io\\writer.txt";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath,true));
        bufferedWriter.write("hello,writer!");
        // 插入一个和系统相关的换行符
        bufferedWriter.newLine();
        bufferedWriter.write("hello,writer!");
        bufferedWriter.newLine();
        bufferedWriter.write("hello,writer!");

        bufferedWriter.close();
    }

    /**
     * 拷贝文件
     */
    @Test
    @SneakyThrows
    public void cloneTest(){
        String filePath = "e:\\io\\image.jpg";
        String filePathClone = "e:\\io\\image_clone.jpg";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePathClone));

        String readLine;
        while ((readLine = bufferedReader.readLine()) != null){
            bufferedWriter.write(readLine);
            // 没写入一行就换行，读取一行内容不会读取换行符
//            bufferedWriter.newLine();
        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}
