package com.tang.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * 读取目录下所有文件名并写入txt
 *
 * @author tcs
 * @date 2022/10/14  15:17
 */
public class ReadUtil {

    /**
     * 递归读取文件路径下的所有文件
     *
     * @param path
     * @param fileNameList
     * @return
     */

    public static List<String> readFiles1(String path, List<String> fileNameList) {
        File file = new File(path);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()) {
                    readFiles1(files[i].getPath(), fileNameList);
                } else {
                    String path1 = files[i].getPath();
                    String fileName = path1.substring(path1.lastIndexOf("\\") + 1);
                    fileNameList.add(fileName);
                }
            }
        } else {
            String path1 = file.getPath();
            String fileName = path1.substring(path1.lastIndexOf("\\") + 1);
            fileNameList.add(fileName);
        }
        return fileNameList;
    }

    /**
     * 将内容输出到(追加)txt文件保存
     *
     * @param content
     * @throws IOException
     */

    public static void outputToTxt(String content, String outputPath) throws IOException {
        //追加内容
        FileWriter fw = new FileWriter(outputPath, true);
        PrintWriter pw = new PrintWriter(fw);
        pw.println(content);
        pw.close();
        fw.close();
        pw.flush();
    }

    public static void main(String[] args) {
        String filePath = "E:\\Project";
        String outputPath1 = "D:\\__easyHelper__\\translate\\fileNameList.txt";
        try {
            List<String> fileNameList = readFiles1(filePath, new ArrayList<String>());
            System.out.println(fileNameList.size());
            for (int i = 0; i < fileNameList.size(); i++) {
                String replace = fileNameList.get(i).replace(".mp3", "");
                if (replace.length() > 4) {
                    outputToTxt(replace, outputPath1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
