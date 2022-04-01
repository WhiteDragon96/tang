package io.inputstream;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author tcs
 * @date Created in 2022-03-17
 */
public class FileReaderAndFileWriter {

    @Test
    public void FileReaderTest(){
        FileReader fileReader = null;
        int data = ' ';
        try {
            fileReader = new FileReader("e:\\io\\test.txt");
            // 循环读取
            while ((data = fileReader.read()) !=-1){
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void FileReaderChar(){
        FileReader fileReader = null;
        int data = ' ';
        try {
            fileReader = new FileReader("e:\\io\\test.pdf");
            char[] chars = new char[8];
            // 循环读取
            while ((data = fileReader.read(chars)) !=-1){
                System.out.print(new String(chars,0,data));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * FileWriter写入
     */
    @Test
    public void FileWriterTEst(){
        FileWriter fileWriter = null;
        char[] chars = {'A','B','C'};
        try {
            fileWriter = new FileWriter(".\\写入.txt");
            fileWriter.write('H');
            fileWriter.write(chars);
            fileWriter.write("最后一定要关闭，不然写入不成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 最后一定要关闭，不然写入不成功
            try {
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
