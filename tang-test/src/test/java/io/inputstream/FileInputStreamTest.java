package io.inputstream;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author tcs
 * @date Created in 2022-03-16
 */
public class FileInputStreamTest {

    /**
     * 单个字节读取，效率比较低
     */
    @Test
    public void readFile01() {
        String filePath = "e:\\hello.txt";
        FileInputStream fileInputStream = null;
        int readData = 0;
        try {
            fileInputStream = new FileInputStream(filePath);
            // 读取一个字节 如果返回-1表示读取完毕
            while ((readData = fileInputStream.read()) != -1) {
                System.out.print((char) readData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭文件流，释放资源
            try {
                assert fileInputStream != null;
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 使用 read(byte[] byte)读取提高效率
     */
    @Test
    public void readFile02() {
        String filePath = "e:\\hello.txt";
        FileInputStream fileInputStream = null;
        int readLen = 0;
        // 一次读取8个字节
        byte[] bytes = new byte[1024];
        try {
            fileInputStream = new FileInputStream(filePath);
            // 读取bytes.length字节到字节数组 如果返回-1表示读取完毕
            // 如果读取正常返回实际读取字节数
            while ((readLen = fileInputStream.read(bytes)) != -1) {
                // 显示
                System.out.print(new String(bytes, 0, readLen));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭文件流，释放资源
            try {
                assert fileInputStream != null;
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 使用fileOutPutStream 将数据写入文件
     * 如果该文件不存在，则创建改文件
     */
    @Test
    public void FileOutputStreamTest() {
        String filePath = "e:\\io\\test.txt";
        FileOutputStream fileOutputStream = null;
        try {
            // 不加true是覆盖写入
            fileOutputStream = new FileOutputStream(filePath, true);
            // 写入一个字符
            fileOutputStream.write('a');
            // 写入一个字符串
            fileOutputStream.write("hello,world".getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 文件拷贝
     */
    @Test
    public void cloneFile() {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream("E:\\Java开发手册(泰山版).pdf");
            fileOutputStream = new FileOutputStream("e:\\io\\test.pdf");
            byte[] bytes = new byte[1204];
            int readLen = 0;
            while ((readLen = fileInputStream.read(bytes)) != -1) {
                fileOutputStream.write(bytes, 0, readLen);
            }
            System.out.println("拷贝成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
