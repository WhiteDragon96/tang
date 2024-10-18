package com.white.daily.pojo;

/**
 * 通用的业务异常枚举
 *
 * @author tcs
 * @date Created in 2021-03-04
 */
public enum BaseErrorEnum implements BaseReturnCode {
    /**
     * 成功
     */
    SUCCESS("0000", "success"),
    /**
     * 暂时规定
     * 1xx 留给common模块使用
     */
    PARAM_CHECK_ERROR("10001", "参数校验失败"),
    // 签名验证失败
    CHECK_SIGN_ERROR("0002", "签名验证失败"),
    // 文件不存在
    DOWNLOAD_BILL_FILE_NOT_EXIST("0003", "下载账单的时候账单不存在"),
    SERVICE_CALL_ERROR("1002", "服务调用异常"),
    SUB_SYS_NO_METHOD_MATCH("1003", "业务系统匹配不到指定服务"),
    SUB_SYSTEM_ERROR("1004", "业务系统异常"),

    SYSTEM_ERROR("19999", "系统内部异常");
    /**
     * 系统码
     */
    private String code;
    /**
     * 描述信息
     */
    private String desc;

    BaseErrorEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getDesc() {
        return desc;
    }
}
