package com.white.daily.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Created by baihua on 2017/12/11.
 *
 * @author baihua
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@SuppressWarnings("unchecked")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultDto<T> extends BaseResultDto {

    private static final long serialVersionUID = -9167323037030715915L;

    private T data;

    public ResultDto() {
        super();
    }

    public static <T> ResultDto<T> newSuccess() {
        return ResultDto.newSuccess(null);
    }

    public static <T> ResultDto<T> newSuccess(T data) {
        ResultDto<T> newOne = new ResultDto<>();

        newOne.setSuccess(true);
        newOne.setErrCode(BaseErrorEnum.SUCCESS.getCode());
        newOne.setErrMsg(BaseErrorEnum.SUCCESS.getDesc());
        newOne.setData(data);

        return newOne;
    }

    /**
     * 返回错误结果
     *
     * @param errCode
     * @param errMsg
     * @return
     */
    public static <T> ResultDto<T> newFailure(String errCode, String errMsg) {
        return ResultDto.newFailure(errCode, errMsg, null);
    }

    /**
     * 返回错误结果
     *
     * @param errCode
     * @param errMsg
     * @return
     */
    public static <T> ResultDto<T> newFailure(String errCode, String errMsg, T data) {
        ResultDto<T> newOne = new ResultDto<>();

        newOne.setSuccess(false);
        newOne.setErrCode(errCode);
        newOne.setErrMsg(errMsg);

        newOne.setData(data);
        return newOne;
    }

    /**
     * 返回错误结果
     *
     * @param baseReturnCode
     * @return
     */
    public static <T> ResultDto<T> newFailure(BaseReturnCode baseReturnCode) {
        return ResultDto.newFailure(baseReturnCode, null);
    }

    /**
     * 返回错误结果
     *
     * @param baseReturnCode
     * @param data
     * @return
     */
    public static <T> ResultDto<T> newFailure(BaseReturnCode baseReturnCode, T data) {
        ResultDto<T> newOne = ResultDto.newFailure(baseReturnCode.getCode(), baseReturnCode.getDesc());
        newOne.setData(data);
        return newOne;
    }

}
