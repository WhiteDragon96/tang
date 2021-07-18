package com.white.daily.pojo;

/**
 * @author tcs
 * @date Created in 2021-03-25
 */
public interface BaseReturnCode {
    /**
     * 获取系统码
     *
     * @return
     */
    String getCode();

    /**
     * 获取描述信息
     *
     * @return
     */
    String getDesc();
}
