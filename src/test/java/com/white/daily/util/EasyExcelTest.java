package com.white.daily.util;

import com.alibaba.excel.EasyExcel;
import com.white.daily.pojo.excel.StudentExcel;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author tcs
 * @date Created in 2021-03-19
 */
public class EasyExcelTest {

    @Test
    public void testExport(){
        List<StudentExcel> excelList = new ArrayList<>();
        StudentExcel studentExcel = new StudentExcel("迪丽热巴","female",19);
        StudentExcel studentExcel2 = new StudentExcel("古力娜扎","female",22);
        StudentExcel studentExcel3 = new StudentExcel("德玛西亚","male",25);
        excelList.add(studentExcel);
        excelList.add(studentExcel2);
        excelList.add(studentExcel3);
        String fileName = UUID.randomUUID().toString().replace("-","") + System.currentTimeMillis() + ".xlsx";
        EasyExcel.write(fileName, StudentExcel.class).sheet("sheet名字").doWrite(excelList);
    }
}
