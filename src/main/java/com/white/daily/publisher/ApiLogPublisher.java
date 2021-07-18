package com.white.daily.publisher;

import com.sun.jndi.toolkit.url.UrlUtil;
import com.white.daily.annotation.ApiLog;
import com.white.daily.event.ApiLogEvent;
import com.white.daily.pojo.LogApi;
import com.white.daily.util.SpringUtil;
import com.white.daily.util.WebUtil;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tcs
 * @date Created in 2021-04-25
 */
public class ApiLogPublisher {
    public ApiLogPublisher() {
    }

    public static void publishEvent(String methodName, String methodClass, ApiLog apiLog, long time) {
        HttpServletRequest request = WebUtil.getRequest();
        LogApi logApi = new LogApi();
        logApi.setTime(String.valueOf(time));
        logApi.setMethodName(methodName);
        logApi.setMethodClass(methodClass);
        if (request != null){
            logApi.setUserAgent(request.getHeader("user-agent"));
            logApi.setRequestUri(WebUtil.getPath(request.getRequestURI()));
            logApi.setMethod(request.getMethod());
        }
        Map<String, Object> event = new HashMap(16);
        event.put("log", logApi);
        SpringUtil.publishEvent(new ApiLogEvent(event));
    }
}
