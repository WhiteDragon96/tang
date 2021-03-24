package com.white.daily.utils;

import com.white.daily.exception.BaseErrorEnum;
import com.white.daily.exception.BaseException;
import com.white.daily.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.groups.Default;
import java.util.*;

/**
 * 参数校验工具
 *
 * @author baihua
 * @date 2019/1/3
 */
@Slf4j
public class ValidatorUtil {
    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    /**
     * 返回所有错误提示消息的列表
     *
     * @param obj
     * @return
     */
    public static <T> List<String> validate(T obj, Class<?>... groups) {

        //入参为空返回
        if (obj == null) {
            return Collections.singletonList("请求参数为空");
        }
        //自定义校验条件
        if (groups == null) {
            groups = new Class<?>[]{Default.class};
        }
        //校验结果
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(obj, groups);
        if (constraintViolations.size() > 0) {

            Iterator<ConstraintViolation<T>> iterator = constraintViolations.iterator();
            List<String> errorList = new ArrayList<>();

            while (iterator.hasNext()) {
                errorList.add(iterator.next().getMessage());
            }

            return errorList;
        }
        return null;
    }

    /**
     * 参数校验，不通过则返回异常，不打印堆栈
     *
     * @param obj
     * @throws
     */
    public static <T> void validateWithError(T obj, Class<?>... groups) throws Exception {
        List<String> errors = validate(obj, groups);
        if (errors == null || errors.isEmpty()) {
            return;
        }

        throw new Exception();
    }

    /**
     * 参数校验，返回业务异常，打印堆栈
     *
     * @param obj
     * @throws BizException
     */
    public static <T> void validateWithBizError(T obj, Class<?>... groups) throws BizException {
        List<String> errors = validate(obj, groups);
        if (errors == null || errors.isEmpty()) {
            return;
        }

        throw BizException.instance(BaseErrorEnum.PARAM_CHECK_ERROR, errors.toString());
    }

    /**
     * 参数校验，返回业务异常，打印堆栈 不需要自定义校验条件
     *
     * @param obj
     * @throws BizException
     */
    public static <T> void validateWithBizError(T obj) throws BizException {
        List<String> errors = validate(obj, Default.class);
        if (errors == null || errors.isEmpty()) {
            return;
        }

        throw BizException.instance(BaseErrorEnum.PARAM_CHECK_ERROR, errors.toString());
    }

    /**
     * 将bizContent参数校验
     *
     * @param bizContent
     * @param tClass
     * @param required
     * @param <T>
     * @return
     * @throws BaseException
     */
    /*public static <T> T validateBizContent(String bizContent, Class<T> tClass, boolean required, Class<?>... groups) throws BaseException {
        if (StringUtils.isEmpty(bizContent)) {
            if (!required) {
                return null;
            } else {
                throw BaseException.instance(BaseErrorEnum.PARAM_CHECK_ERROR, "biz_content不能为空");
            }
        } else {
            try {
                T instance = JacksonUtil.deserialize(bizContent, tClass);
                ValidatorUtil.validateWithError(instance, groups);
                return instance;
            } catch (BaseException e) {
                throw e;
            } catch (Exception e) {
                LogUtils.error(log, LogLevelEnum.P2, "parse biz_content fail", e);
                throw BaseException.instance(BaseErrorEnum.PARAM_CHECK_ERROR, "biz_content格式异常");
            }
        }
    }*/

    /**
     * 校验以后返回resultDto
     *
     * @param obj
     * @param returnCode
     * @param groups
     * @param <T>
     * @param <V>
     * @return
     */
    /*public static <T, V> ResultDto<V> validateWithResult(T obj, BaseReturnCode returnCode, Class<?>... groups) {
        List<String> errors = ValidatorUtil.validate(obj, groups);
        if (errors == null || errors.isEmpty()) {
            return ResultDto.newSuccess();
        }

        return ResultDto.<V>newFailure(returnCode);
    }*/

    /**
     * 校验以后返回resultDto
     *
     * @param obj
     * @param returnCode
     * @param errMsg
     * @param groups
     * @param <T>
     * @param <V>
     * @return
     */
    /*public static <T, V> ResultDto<V> validateWithResult(T obj, BaseReturnCode returnCode, String errMsg, Class<?>... groups) {
        List<String> errors = ValidatorUtil.validate(obj, groups);
        if (errors == null || errors.isEmpty()) {
            return ResultDto.newSuccess();
        }

        return ResultDto.<V>newFailure(returnCode.getCode(), StringUtils.isEmpty(errMsg) ? returnCode.getDesc() : errMsg);
    }*/

}