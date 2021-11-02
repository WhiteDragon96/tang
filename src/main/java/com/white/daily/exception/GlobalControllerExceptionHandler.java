package com.white.daily.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * @author tcs
 * @date Created in 2021-08-23
 */
@ControllerAdvice
@Slf4j
public class GlobalControllerExceptionHandler {
    private static final String MISSING_PARAM_ERROR_CODE = "NotNull";

    /**
     * 这种方式返回异常处理的结果
     *
     * @param e
     * @return
     */
    @ResponseStatus(value = HttpStatus.OK)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String handleApiException(HttpServletRequest request, Exception e) {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
        return "系统错误";
    }
}
