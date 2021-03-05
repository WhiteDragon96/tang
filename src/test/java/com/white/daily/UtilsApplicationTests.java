package com.white.daily;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiRobotSendRequest;
import com.dingtalk.api.response.OapiRobotSendResponse;
import com.taobao.api.ApiException;
import com.white.daily.config.DingRobotConfig;
import com.white.daily.utils.DingUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UtilsApplicationTests {

    @Autowired
    DingRobotConfig dingRobotConfig;

    @Test
    void contextLoads() throws ApiException {
        DingUtils.sendMsg("hello DD");
    }

}
