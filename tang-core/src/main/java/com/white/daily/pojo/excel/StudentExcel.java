package com.white.daily.pojo.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tcs
 * @date Created in 2021-03-19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ContentRowHeight(20)
@HeadRowHeight(20)
@ColumnWidth(25)
public class StudentExcel {

    @ExcelProperty("字符串标题")
    private String name;

    @ExcelProperty("性别标题")
    private String sex;

    @ExcelProperty("年龄")
    private Integer age;
}
