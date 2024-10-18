package com.white.daily.mock.service;

import redis.clients.jedis.JedisPubSub;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * @author tcs
 * @date Created in 2022-02-09
 */
public class MyJedisPubSub extends JedisPubSub {

    HttpServletResponse response;

    public MyJedisPubSub(HttpServletResponse response) {
        this.response = response;
    }

    @Override
    /** JedisPubSub类是一个没有抽象方法的抽象类,里面方法都是一些空实现
     * 所以可以选择需要的方法覆盖,这儿使用的是SUBSCRIBE指令，所以覆盖了onMessage
     * 如果使用PSUBSCRIBE指令，则覆盖onPMessage方法
     * 当然也可以选择BinaryJedisPubSub,同样是抽象类，但方法参数为byte[]
     **/
    public void onMessage(String channel, String message) {
        System.out.println(Thread.currentThread().getName()+"-接收到消息:channel=" + channel + ",message=" + message);
        ServletOutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            outputStreamWriter.write(message);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //接收到exit消息后退出
        if ("exit".equals(message)) {
            System.exit(0);
        }
    }
}
