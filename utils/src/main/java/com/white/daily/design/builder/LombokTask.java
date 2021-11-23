package com.white.daily.design.builder;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * @author tcs
 * @date Created in 2021-04-27
 */
@Builder(builderMethodName = "hiddenBuilder")
@ToString
@Data
public class LombokTask {
    private Long id;
    private String name;
    private String content;
    private int type;

    /**
     * 当使用注解，又需要必填参数时
     *
     * @param id
     * @param name
     * @return
     */
    public static LombokTaskBuilder builder(Long id, String name) {
        return hiddenBuilder().id(id).name(name);
    }
}
