package io.github.tang.wechat.api.request;

import io.github.tang.wechat.api.response.ApiResponse;

/**
 * @author tangcs
 * @date 2018/1/18
 */
public class StringRequest extends ApiRequest<StringRequest, ApiResponse> {

    public StringRequest(String url) {
        super(url, ApiResponse.class);
    }

}