package com.white.daily.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author tcs
 * @date Created in 2022-02-09
 */
public class JedisPoolUtils {
    private static JedisPool pool = null;

    //可用连接实例的最大数目，默认值为8；
    private static final int MAX_TOTAL = 50;

    //控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。
    private static final int MAX_IDLE = 10;

    //等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException；
    private static final int MAX_WAIT = 3000;

    //超时时间
    private static final int TIME_OUT = 3000;

    //在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
    private static final boolean TEST_ON_BORROW = true;

    private static final boolean TEST_ON_RETURN = true;

    static {
        //获得池子对象
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(MAX_IDLE);
        poolConfig.setMaxTotal(MAX_TOTAL);
        poolConfig.setMaxWaitMillis(MAX_WAIT);
        poolConfig.setTestOnBorrow(TEST_ON_BORROW);
        poolConfig.setTestOnReturn(TEST_ON_RETURN);
        pool = new JedisPool(poolConfig, "119.91.204.244", 6378, TIME_OUT, "tangcs123");
    }

    //获得jedis资源的方法
    public static Jedis getJedis() {
        return pool.getResource();
    }

    public static void main(String[] args) {
        Jedis jedis = getJedis();
        System.out.println(jedis);
    }
}
