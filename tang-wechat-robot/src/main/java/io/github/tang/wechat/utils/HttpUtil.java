package io.github.tang.wechat.utils;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpUtil {

    /**
     * 模拟http的get请求，获取响应（输入流），然后把输入流转为
     *
     * @param url
     * @return
     */
    public static String httpGet(String url) {
        HttpURLConnection connection = null;
        InputStream response = null;
        try {
            connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setConnectTimeout(10000);
            connection.setReadTimeout(10000);
            response = connection.getInputStream();
            if (response != null) {
                String nextLine = IOUtils.toString(response, "utf-8");
                return nextLine;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (response != null)
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (connection != null) {
                connection.disconnect();
                connection = null;
            }
        }
        return null;
    }

}
