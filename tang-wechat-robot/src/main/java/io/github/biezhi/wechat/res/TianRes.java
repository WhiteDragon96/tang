package io.github.biezhi.wechat.res;

import lombok.Data;

import java.util.List;

/**
 * @author tcs
 * @date Created in 2021-12-10
 */

@Data
public class TianRes {
    private Integer code;
    private String mag;
    private List<News> newsList;
    @Data
    public static class News{
        private String reply;
        private String datatype;
    }
}
