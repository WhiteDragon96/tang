package com.white.daily.pojo;

import lombok.Data;

/**
 * @author tcs
 * @date Created in 2021-04-25
 */
@Data
public class LogApi {
    protected Long id;
    protected String method;
    protected String methodClass;
    protected String methodName;
    protected String serverIp;
    protected String serverHost;
    protected String env;
    protected String remoteIp;
    private String time;
    private String userAgent;
    private String requestUri;
}
