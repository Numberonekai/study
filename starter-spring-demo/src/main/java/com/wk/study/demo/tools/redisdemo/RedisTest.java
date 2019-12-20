package com.wk.study.demo.tools.redisdemo;

import com.alibaba.fastjson.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.DefaultStringRedisConnection;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.Pipeline;

import java.util.List;

/**
 * @auther: kai2.wang
 * @date: 2019/12/5 09:23
 * @description:
 * @version: 1.0
 */
@SpringBootApplication
public class RedisTest {

    public static void main(String[] args) {

//        AnnotationConfigApplicationContext annotationConfigApplicationContext=new AnnotationConfigApplicationContext(RedisUtils.class);
//        JedisCluster jedisCluster= (JedisCluster) annotationConfigApplicationContext.getBean("getJedisCluster");
//        jedisCluster.set("wk","123");
//        System.out.println(jedisCluster.get("wk"));


        ConfigurableApplicationContext configurableApplicationContext=SpringApplication.run(RedisTest.class);
        RedisTemplate redisTemplate= (RedisTemplate) configurableApplicationContext.getBean("redisTemplate");
//        DefaultStringRedisConnection defaultStringRedisConnection=new DefaultStringRedisConnection(redisTemplate.getConnectionFactory().getConnection());
//        defaultStringRedisConnection.select(1);
        redisTemplate.opsForValue().set("test","123");
        SessionCallback DataAccessException=new SessionCallback<Object>() {
            @Override
            public  String execute(RedisOperations redisOperations) throws DataAccessException {
                for (int i = 0; i < 1000; i++) {
                    JSONObject jsonObject=new JSONObject();
                    jsonObject.put("json"+i,"json"+i);
                    redisOperations.opsForValue().set("test"+i+":data"+i+":result"+i,jsonObject);
//                    try {
//                        Thread.sleep(10);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }
                return null;
            }
        };

        Long start=System.currentTimeMillis();
//        List result = redisTemplate.executePipelined(DataAccessException);
//        System.out.println(result);
        Long end=System.currentTimeMillis();
        System.out.println(end-start);
        System.out.println(redisTemplate.opsForValue().get("test")+"-------");

        Jedis jedis=new Jedis("127.0.0.1");
        Pipeline pipeline=jedis.pipelined();
        pipeline.multi();
        System.out.println(pipeline.get("798"));
        pipeline.set("789","123");
        System.out.println(pipeline.get("798"));
        pipeline.exec();
        pipeline.sync();


//        RedisTemplate redisTemplate= (RedisTemplate) annotationConfigApplicationContext.getBean("redisTemplate");
//        redisTemplate.opsForValue().set("wk","456");
//        System.out.println(redisTemplate.opsForValue().get("wk"));

    }
}
