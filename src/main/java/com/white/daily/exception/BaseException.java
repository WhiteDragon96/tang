package com.white.daily.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;

/**
 * 不打印堆栈，在参数校验这种不需要知道堆栈的地方使用
 *
 * @author baihua
 * @date 2019/4/16
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class BaseException extends RuntimeException {
    private static final long serialVersionUID = 1319799664892722446L;
    /**
     * 错误码
     */
    private String errorCode;
    /**
     * 错误消息
     */
    private String errorMsg;

    private BaseException() {
        super(null, null, false, false);
    }

    private BaseException(String message) {
        super(message, null, false, false);
        this.errorMsg = message;
    }

    /**
     * 创建异常实例
     *
     * @param errorCode
     * @param errorMsg
     * @return
     */
    public static BaseException instance(String errorCode, String errorMsg) {
        return new BaseException(errorMsg)
                .setErrorCode(errorCode);
    }

    /**
     * 依据错误码返回异常
     *
     * @param baseReturnCode
     * @return
     */
    public static BaseException instance(BaseReturnCode baseReturnCode) {
        return new BaseException(baseReturnCode.getDesc())
                .setErrorCode(baseReturnCode.getCode());
    }

    /**
     * 依据错误码和错误信息返回异常
     *
     * @param returnCode
     * @param errorMsg
     * @return
     */
    public static BaseException instance(BaseReturnCode returnCode, String errorMsg) {
        return new BaseException(StringUtils.isEmpty(errorMsg) ? returnCode.getDesc() : errorMsg)
                .setErrorCode(returnCode.getCode());
    }

}
