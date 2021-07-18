package com.white.daily.pojo.vo;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * @author tcs
 * @date Created in 2021-03-24
 */
@Data
public class BeanValidationVO {
    @Size(min = 6, max = 10)
    private String field1;

    private Integer number;

    private Long field2;

    @NotNull(message = "name不能为空")
    @Valid
    private Boolean name;

}
