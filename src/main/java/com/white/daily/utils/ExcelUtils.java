package com.white.daily.utils;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.read.listener.ReadListener;
import com.white.daily.listener.DataListener;
import org.apache.commons.codec.CharEncoding;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.List;

/**
 * 基于easyExcel 文档地址 https://www.yuque.com/easyexcel/doc/easyexcel
 * @author tcs
 * @date Created in 2021-03-19
 */
public class ExcelUtils {

    /**
     * 导出数据
     *
     * @param response
     * @param fileName  文件名
     * @param sheetName sheet名 默认是第一个
     * @param dataList  要导出的数据
     * @param clazz     导出实体类的Class
     * @param <T>       导出的实体类
     * @throws IOException
     */
    public static <T> void export(HttpServletResponse response, String fileName, String sheetName, List<T> dataList, Class<T> clazz) throws IOException {
        try {
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding(CharEncoding.UTF_8);
            fileName = URLEncoder.encode(fileName, CharEncoding.UTF_8);
            response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
            EasyExcel.write(response.getOutputStream(), clazz).sheet(sheetName).doWrite(dataList);
        } catch (Throwable e) {
            throw e;
        }
    }

    public static <T> List<T> read(MultipartFile excel, Class<T> clazz) {
        DataListener<T> dataListener = new DataListener();
        ExcelReaderBuilder builder = getReaderBuilder(excel, dataListener, clazz);
        if (builder == null) {
            return null;
        } else {
            builder.doReadAll();
            return dataListener.getDataList();
        }
    }

    public static <T> ExcelReaderBuilder getReaderBuilder(MultipartFile excel, ReadListener<T> readListener, Class<T> clazz) {
        String filename = excel.getOriginalFilename();
        if (StringUtils.isEmpty(filename)) {
            //throw new Exception("请上传文件!");
            return null;
        } else if (!StringUtils.endsWithIgnoreCase(filename, ".xls") && !StringUtils.endsWithIgnoreCase(filename, ".xlsx")) {
            // throw new ExcelException("请上传正确的excel文件!");
            return null;
        } else {
            try {
                InputStream inputStream = new BufferedInputStream(excel.getInputStream());
                return EasyExcel.read(inputStream, clazz, readListener);
            } catch (IOException var6) {
                var6.printStackTrace();
                return null;
            }
        }
    }
}
