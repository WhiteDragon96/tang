package com.white.daily.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;

/**
 * 业务异常，包含堆栈，方便定位问题
 *
 * @author baihua
 * @date 2019/10/9
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class BizException extends RuntimeException {
    private static final long serialVersionUID = -1843449871529322352L;

    /**
     * 错误码
     */
    private String errorCode;
    /**
     * 错误消息
     */
    private String errorMsg;

    /**
     * 创建异常实例
     *
     * @param errorCode
     * @param errorMsg
     * @return
     */
    public static BizException instance(String errorCode, String errorMsg) {
        return new BizException(errorMsg).setErrorCode(errorCode).setErrorMsg(errorMsg);
    }

    private BizException(String errorMsg) {
        super(errorMsg);
    }

    /**
     * 依据错误码返回异常
     *
     * @param baseReturnCode
     * @return
     */
    public static BizException instance(BaseReturnCode baseReturnCode) {
        return new BizException(baseReturnCode.getDesc())
                .setErrorCode(baseReturnCode.getCode())
                .setErrorMsg(baseReturnCode.getDesc());
    }

    /**
     * 依据错误码和错误信息返回异常
     *
     * @param returnCode
     * @param errorMsg
     * @return
     */
    public static BizException instance(BaseReturnCode returnCode, String errorMsg) {
        return new BizException(StringUtils.isEmpty(errorMsg) ? returnCode.getDesc() : errorMsg)
                .setErrorCode(returnCode.getCode())
                .setErrorMsg(StringUtils.isEmpty(errorMsg) ? returnCode.getDesc() : errorMsg);
    }
}
