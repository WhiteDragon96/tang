package com.tang.tangjuc.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.omg.PortableInterceptor.INACTIVE;

/**
 * @author tcs
 * @date Created in 2021-12-07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String name;
    private Integer age;
}
