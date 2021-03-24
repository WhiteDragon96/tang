package com.white.daily.exception;

/**
 * @author baihua
 * @date 2019/10/21
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
