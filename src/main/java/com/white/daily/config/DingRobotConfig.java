package com.white.daily.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author tcs
 * @date Created in 2021-03-05
 */
@Component
public class DingRobotConfig {

    public static String serverUrl;

    @Value(value = "${ding.serverUrl}")
    public static void setUrl(String url){
        serverUrl = url;
    }


}
