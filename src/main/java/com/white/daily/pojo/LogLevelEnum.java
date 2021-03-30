package com.white.daily.pojo;

import lombok.Getter;

/**
 * @author cmx
 * 日志定义的级别 级别越高的日志越需要监控
 */
@Getter
public enum LogLevelEnum {

    /**
     * 可忽略日志
     */
    P4("P4", "可忽略日志", 4),

    /**
     * 排查问题日志
     */
    P3("P3", "排查问题日志", 3),

    /**
     * 警告类日志
     */
    P2("P2", "警告类日志", 2),

    /**
     * 错误类日志
     */
    P1("P1", "错误类日志", 1),

    /**
     * 严重错误类日志
     */
    P0("P0", "严重错误类日志", 0);


    LogLevelEnum(String name, String info, Integer code){
        this.name = name;
        this.info = info;
        this.code = code;
    }

    private String name;
    private String info;
    private Integer code;

}
