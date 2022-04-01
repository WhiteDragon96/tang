package com.white.daily.redis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.white.daily.pojo.User;
import com.white.daily.thread.MyThreadPool;
import com.white.daily.util.JedisPoolUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;
import redis.clients.jedis.Transaction;
import redis.clients.jedis.util.SafeEncoder;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/**
 * @author tcs
 * @date Created in 2021-10-22
 */
@SpringBootTest
public class RedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired(required = true)
    private RedisTemplate redisTemplate;

    @Resource(name = "asyncServiceExecutor")
    private Executor executor;

    @Test
    public void testTemplateRedis(){
        // 获取redis的连接对象
        RedisConnection connection = Objects.requireNonNull(redisTemplate.getConnectionFactory()).getConnection();
        User tang = new User(1, "tang", 18, new Date());
//        String s = JSONObject.toJSONString(tang);
        redisTemplate.opsForValue().set("user",tang);
        System.out.println(redisTemplate.opsForValue().get("user"));

    }

    @Test
    public void testSet() {

        stringRedisTemplate.opsForValue().set("hello1", "world");
        stringRedisTemplate.opsForZSet().add("张三1","张",2);
        stringRedisTemplate.opsForZSet().add("李四1","李",1);

    }

    @Test
    public void testThread(){
        for (int i = 10; i < 20; i++) {
            stringRedisTemplate.opsForValue().set(i+"", 10000-i+"");
        }
        executor.execute(() ->{
            for (int i = 10; i < 20; i++) {
                stringRedisTemplate.opsForValue().set(i+"", 10000-i+"");
            }
        });
    }

    @Test
    public void testQueue() {
        Map<String, String> map = new HashMap<>(12);
        map.put("fileId", "msg");
        redisTemplate.opsForList().leftPush("mylist1", map);
    }

    public static final String CHANNEL_KEY = "channel:1";
    private volatile int count;

    /**
     * redis 生产者
     */
    @Test
    public void testProducers() {
        putMessage("{\\\"ID\\\":\\\"Uu7G2ZBng\\\",\\\"DeviceID\\\":\\\"33090100001110000001\\\",\\\"DeviceName\\\":\\\"\\\",\\\"ChannelID\\\":\\\"33090100001310000001\\\",\\\"ChannelName\\\":\\\"\\xe4\\xba\\x94\\xe5\\xb3\\x99\\xe5\\xb1\\xb1\\xe5\\x85\\xa5\\xe4\\xbe\\xb5\\xe7\\x9b\\x91\\xe6\\xb5\\x8b\\xe5\\x8f\\xaf\\xe8\\xa7\\x81\\xe5\\x85\\x89\\\",\\\"AlarmPriority\\\":1,\\\"AlarmPriorityName\\\":\\\"\\xe4\\xb8\\x80\\xe7\\xba\\xa7\\xe8\\xad\\xa6\\xe6\\x83\\x85\\\",\\\"AlarmMethod\\\":5,\\\"AlarmMethodName\\\":\\\"\\xe8\\xa7\\x86\\xe9\\xa2\\x91\\xe6\\x8a\\xa5\\xe8\\xad\\xa6\\\",\\\"Longitude\\\":0,\\\"Latitude\\\":0,\\\"AlarmDescription\\\":\\\"\\\",\\\"AlarmType\\\":6,\\\"AlarmTypeName\\\":\\\"\\xe5\\x85\\xa5\\xe4\\xbe\\xb5\\xe6\\xa3\\x80\\xe6\\xb5\\x8b\\xe6\\x8a\\xa5\\xe8\\xad\\xa6\\\",\\\"AlarmEventType\\\":2,\\\"Time\\\":\\\"2022-02-16 15:10:08\\\",\\\"ExtInfo\\\":{},\\\"RecordPath\\\":\\\"\\\",\\\"SnapPath\\\":\\\"\\\",\\\"CreatedAt\\\":\\\"2022-02-16 15:10:08\\\"}");
        /*for (int i = 0; i < 100; i++) {
            int sum = i;
            executor.execute(() -> putMessage(Thread.currentThread().getName()+":::"+sum));
        }
        while (true){
            executor.execute(() -> putMessage(Thread.currentThread().getName()+":::"+UUID.randomUUID().toString()));
        }*/

    }

    public void putMessage(String message) {
        Jedis jedis = JedisPoolUtils.getJedis();
        Long publish = jedis.publish(CHANNEL_KEY, message);//返回订阅者数量
        System.out.println(Thread.currentThread().getName() + " put message,count=" + count+",subscriberNum="+publish);
        jedis.close();
        count++;
    }

    /**
     * redis 消费者
     */
    @Test
    public void testConsumers(){
        executor.execute(this::consumerMessage);
        consumerMessage();
    }

    public void consumerMessage() {
        MyJedisPubSub myJedisPubSub = new MyJedisPubSub();//处理接收消息
        Jedis jedis = JedisPoolUtils.getJedis();
        jedis.subscribe(myJedisPubSub, CHANNEL_KEY);//第一个参数是处理接收消息，第二个参数是订阅的消息频道
    }


    /**
     * 继承JedisPubSub，重写接收消息的方法
     */
class MyJedisPubSub extends JedisPubSub {
        @Override
        /** JedisPubSub类是一个没有抽象方法的抽象类,里面方法都是一些空实现
         * 所以可以选择需要的方法覆盖,这儿使用的是SUBSCRIBE指令，所以覆盖了onMessage
         * 如果使用PSUBSCRIBE指令，则覆盖onPMessage方法
         * 当然也可以选择BinaryJedisPubSub,同样是抽象类，但方法参数为byte[]
         **/
        public void onMessage(String channel, String message) {
            System.out.println(Thread.currentThread().getName()+"-接收到消息:channel=" + channel + ",message=" + message);
            //接收到exit消息后退出
            if ("exit".equals(message)) {
                System.exit(0);
            }
        }
    }

    public static final String MESSAGE_KEY = "message:queue";

    @Test
    public void testRedisList(){
        MyThreadPool.executor.execute(() ->{
            for (int i = 0; i < 100; i++) {
                putMessageList(String.valueOf(i));
            }
        });
        MyThreadPool.executor.execute(() ->{
            for (int i = 100; i < 1000; i++) {
                putMessageList(String.valueOf(i));
            }
        });

        try {
            TimeUnit.MINUTES.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    Jedis jedis2 = JedisPoolUtils.getJedis();
    public void putMessageList(String message) {
        Jedis jedis = JedisPoolUtils.getJedis();
        Long size = jedis.lpush(MESSAGE_KEY, message);
        System.out.println(Thread.currentThread().getName() + " put message,size=" + size + ",count=" + count);
        jedis.close();
        count++;
    }

    @Test
    public void testConsumerRedisList() {

        for (int i = 0; i < 100; i++) {
            MyThreadPool.executor.execute(() -> {
                while (true) {
                    consumerMessageList();
                }
            });
        }
        while (true) {
            consumerMessageList();
        }
    }

    public void consumerMessageList() {
        Jedis jedis = JedisPoolUtils.getJedis();
        List<String> brpop = jedis.brpop(0, MESSAGE_KEY);//0是timeout,返回的是一个集合，第一个是消息的key，第二个是消息的内容
        System.out.println(Thread.currentThread().getName()+"=================" + brpop);
        jedis.close();
    }


    @Test
    public void testRedisString(){
        Jedis jedis = JedisPoolUtils.getJedis();
        jedis.mset("a","1","b","2");
        System.out.println(jedis.mget("a","c","d"));
        System.out.println(jedis.exists("a"));
        System.out.println(jedis.getSet("name","李四"));
        System.out.println(jedis.get("name"));
        System.out.println(jedis.ttl("name"));
        List<String> age = jedis.hmget("user:1000","name","age");
        Map<String, String> map = jedis.hgetAll("user:1000");
        age.forEach(System.out::println);
        Long sadd = jedis.sadd("jedis:Redis", "1", "2", "5", "0");
        System.out.println(jedis.smembers("jedis::Redis"));

        Set<String> hackers = jedis.zrange("hackers", 0, -1);
        System.out.println(hackers);
        System.out.println(jedis.zrevrange("hackers", 0, -1));
    }

    @Test
    public void testKuangRedis(){
        Jedis jedis = JedisPoolUtils.getJedis();
        System.out.println(jedis.ping());
        Transaction multi = jedis.multi();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("hello","world");
        System.out.println(jedis.keys("*"));
        System.out.println(jedis.setnx("hello", "world1"));
        System.out.println(jedis.get("hello"));
    }


}
