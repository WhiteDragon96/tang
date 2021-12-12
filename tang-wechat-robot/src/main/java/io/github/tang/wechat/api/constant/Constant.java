package io.github.tang.wechat.api.constant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 常量
 *
 * @author tangcs
 * @date 2018/1/18
 */
public interface Constant {

    String VERSION           = "1.0.5";
    String BASE_URL          = "https://login.weixin.qq.com";
    String BASE_LOGIN_URL          = "https://login.wx.qq.com";//https://login.wx2.qq.com
    String GET               = "GET";
    String GROUP_BR          = ":<br/>";
    String GROUP_IDENTIFY    = "@@";
    String LOCATION_IDENTIFY = "/cgi-bin/mmwebwx-bin/webwxgetpubliclinkimg?url=";

    String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36";

    String UOS_PATCH_CLIENT_VERSION = "2.0.0";
            String     UOS_PATCH_EXTSPAM = "Gp8ICJkIEpkICggwMDAwMDAwMRAGGoAI1GiJSIpeO1RZTq9QBKsRbPJdi84ropi16EYI10WB6g74sGmRwSNXjPQnYUKYotKkvLGpshucCaeWZMOylnc6o2AgDX9grhQQx7fm2DJRTyuNhUlwmEoWhjoG3F0ySAWUsEbH3bJMsEBwoB//0qmFJob74ffdaslqL+IrSy7LJ76/G5TkvNC+J0VQkpH1u3iJJs0uUYyLDzdBIQ6Ogd8LDQ3VKnJLm4g/uDLe+G7zzzkOPzCjXL+70naaQ9medzqmh+/SmaQ6uFWLDQLcRln++wBwoEibNpG4uOJvqXy+ql50DjlNchSuqLmeadFoo9/mDT0q3G7o/80P15ostktjb7h9bfNc+nZVSnUEJXbCjTeqS5UYuxn+HTS5nZsPVxJA2O5GdKCYK4x8lTTKShRstqPfbQpplfllx2fwXcSljuYi3YipPyS3GCAqf5A7aYYwJ7AvGqUiR2SsVQ9Nbp8MGHET1GxhifC692APj6SJxZD3i1drSYZPMMsS9rKAJTGz2FEupohtpf2tgXm6c16nDk/cw+C7K7me5j5PLHv55DFCS84b06AytZPdkFZLj7FHOkcFGJXitHkX5cgww7vuf6F3p0yM/W73SoXTx6GX4G6Hg2rYx3O/9VU2Uq8lvURB4qIbD9XQpzmyiFMaytMnqxcZJcoXCtfkTJ6pI7a92JpRUvdSitg967VUDUAQnCXCM/m0snRkR9LtoXAO1FUGpwlp1EfIdCZFPKNnXMeqev0j9W9ZrkEs9ZWcUEexSj5z+dKYQBhIICviYUQHVqBTZSNy22PlUIeDeIs11j7q4t8rD8LPvzAKWVqXE+5lS1JPZkjg4y5hfX1Dod3t96clFfwsvDP6xBSe1NBcoKbkyGxYK0UvPGtKQEE0Se2zAymYDv41klYE9s+rxp8e94/H8XhrL9oGm8KWb2RmYnAE7ry9gd6e8ZuBRIsISlJAE/e8y8xFmP031S6Lnaet6YXPsFpuFsdQs535IjcFd75hh6DNMBYhSfjv456cvhsb99+fRw/KVZLC3yzNSCbLSyo9d9BI45Plma6V8akURQA/qsaAzU0VyTIqZJkPDTzhuCl92vD2AD/QOhx6iwRSVPAxcRFZcWjgc2wCKh+uCYkTVbNQpB9B90YlNmI3fWTuUOUjwOzQRxJZj11NsimjOJ50qQwTTFj6qQvQ1a/I+MkTx5UO+yNHl718JWcR3AXGmv/aa9rD1eNP8ioTGlOZwPgmr2sor2iBpKTOrB83QgZXP+xRYkb4zVC+LoAXEoIa1+zArywlgREer7DLePukkU6wHTkuSaF+ge5Of1bXuU4i938WJHj0t3D8uQxkJvoFi/EYN/7u2P1zGRLV4dHVUsZMGCCtnO6BBigFMAA=";

    /**
     * 特殊用户 须过滤
     */
    Set<String> API_SPECIAL_USER = new HashSet<>(
            Arrays.asList("newsapp", "filehelper", "weibo", "qqmail",
                    "fmessage", "tmessage", "qmessage", "qqsync",
                    "floatbottle", "lbsapp", "shakeapp", "medianote",
                    "qqfriend", "readerapp", "blogapp", "facebookapp",
                    "masssendapp", "meishiapp", "feedsapp", "voip",
                    "blogappweixin", "brandsessionholder", "weixin",
                    "weixinreminder", "officialaccounts", "wxitil",
                    "notification_messages", "wxid_novlwrv3lqwv11",
                    "gh_22b87fa7cb3c", "userexperience_alarm"));

    /**
     * index url
     */
    List<String> INDEX_URL = new ArrayList<>(
            Arrays.asList("wx2.qq.com", "wx8.qq.com",
                    "wx.qq.com", "web2.wechat.com", "wechat.com"));

    /**
     * file url
     */
    List<String> FILE_URL = new ArrayList<>(
            Arrays.asList("file.wx2.qq.com", "file.wx8.qq.com",
                    "file.wx.qq.com", "file.web2.wechat.com", "file.web.wechat.com"));

    /**
     * webpush url, webpush.wx2.qq.com
     */
    List<String> WEB_PUSH_URL = new ArrayList<>(
            Arrays.asList("wx2.qq.com", "wx8.qq.com",
                    "wx.qq.com", "web2.wechat.com", "web.wechat.com"));

}