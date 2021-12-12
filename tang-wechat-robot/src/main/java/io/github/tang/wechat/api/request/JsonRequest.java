package io.github.tang.wechat.api.request;

import io.github.tang.wechat.api.response.JsonResponse;

/**
 * JSON请求
 *
 * @author tangcs
 * @date 2018/1/18
 */
public class JsonRequest extends ApiRequest<JsonRequest, JsonResponse> {

    public JsonRequest(String url) {
        super(url, JsonResponse.class);
    }

}