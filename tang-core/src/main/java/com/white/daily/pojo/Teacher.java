package com.white.daily.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author tcs
 * @date Created in 2021-03-12
 */
@Data
public class Teacher extends Student{

    private double salary;

    public Teacher(String name, Integer age, String sex, double salary) {
        super(name, age, sex);
        this.salary = salary;
    }

    public Teacher() {
        this.salary = salary;
    }
}
