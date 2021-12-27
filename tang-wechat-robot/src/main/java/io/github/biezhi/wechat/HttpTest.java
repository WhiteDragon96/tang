package io.github.biezhi.wechat;

import cn.hutool.http.HttpUtil;

/**
 * @author tcs
 * @date Created in 2021-12-15
 */
public class HttpTest {
    public static void main(String[] args) {
        String s = HttpUtil.get("https://api.ixiaowai.cn/tgrj/index.php");
        System.out.println(s);
    }
}
