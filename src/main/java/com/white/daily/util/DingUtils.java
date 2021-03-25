package com.white.daily.util;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiRobotSendRequest;
import com.dingtalk.api.response.OapiRobotSendResponse;
import com.taobao.api.ApiException;

/**
 * 钉钉机器人 发送消息
 * @author tcs
 * @date Created in 2021-03-05
 */
public class DingUtils {

    public static OapiRobotSendResponse sendMsg(String msg) throws ApiException {
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/robot/send?access_token=e3ee796b38a1c3f63ab063bf6a8fc1b8b1e3005f9c626b225b3faa406179449a");
        OapiRobotSendRequest request = new OapiRobotSendRequest();
        request.setMsgtype("text");
        OapiRobotSendRequest.Text text = new OapiRobotSendRequest.Text();
        text.setContent("test: \n" + msg);
        request.setText(text);
        OapiRobotSendRequest.At at = new OapiRobotSendRequest.At();
        at.setIsAtAll(false);
        request.setAt(at);
        return client.execute(request);
    }
}
