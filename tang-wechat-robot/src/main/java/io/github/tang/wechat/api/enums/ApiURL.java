package io.github.tang.wechat.api.enums;

import lombok.Getter;

/**
 * API URL
 *
 * @author tangcs
 * @date 2018/1/21
 */
@Getter
public enum ApiURL {
    
    IMAGE2("%s/webwxgetmsgimg?MsgID=%s&skey=%s", ".jpg", "images"),
    IMAGE("%s/webwxgetmsgimg?MsgID=%s&skey=%s", ".jpg", "images"),// type: slave 这样是小图片
    HEAD_IMG("%s/webwxgetheadimg?username=%s&skey=%s", ".jpg", "headimg"),
    ICON("%s/webwxgeticon?username=%s&skey=%s", ".jpg", "icons"),
    VOICE("%s/webwxgetvoice?msgid=%s&skey=%s", ".mp3", "voice"),
    VIDEO("%s/webwxgetvideo?msgid=%s&skey=%s", ".mp4", "video");

    private String url;
    private String suffix;
    private String dir;

    ApiURL(String url) {
        this.url = url;
    }

    ApiURL(String url, String suffix, String dir) {
        this.url = url;
        this.suffix = suffix;
        this.dir = dir;
    }

}
