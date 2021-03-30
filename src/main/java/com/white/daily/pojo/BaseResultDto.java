package com.white.daily.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

/**
 * 基础result
 *
 * @author baihua
 * @date 2020/3/4
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResultDto implements Serializable {
    private static final long serialVersionUID = 7561975797605288716L;

    private boolean success = true;

    private String errMsg = "success";

    private String errCode;

    public BaseResultDto() {
    }

    public BaseResultDto(boolean success) {
        this(success, null);
    }

    public BaseResultDto(boolean success, String errMsg) {
        this(success, errMsg, null);
    }

    public BaseResultDto(boolean success, String errMsg, String errCode) {
        this.success = success;
        this.errMsg = errMsg;
        this.errCode = errCode;
    }

    public boolean isSuccess() {
        return success;
    }

    public static BaseResultDto success() {

        BaseResultDto newOne = new BaseResultDto();

        newOne.setSuccess(true);

        newOne.setErrCode(BaseErrorEnum.SUCCESS.getCode());
        newOne.setErrMsg(BaseErrorEnum.SUCCESS.getCode());

        return newOne;
    }

    public static BaseResultDto fail(String code, String msg) {
        BaseResultDto newOne = new BaseResultDto();

        newOne.setSuccess(false);

        newOne.setErrCode(code);
        newOne.setErrMsg(msg);

        return newOne;
    }

    public void setResultDto(BaseResultDto resultDto) {
        this.success = resultDto.isSuccess();
        this.errCode = resultDto.getErrCode();
        this.errMsg = resultDto.getErrMsg();
    }
}
