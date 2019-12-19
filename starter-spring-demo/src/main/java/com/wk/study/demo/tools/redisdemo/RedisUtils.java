package com.wk.study.demo.tools.redisdemo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @auther: kai2.wang
 * @date: 2019/12/9 15:35
 * @description:
 * @version: 1.0
 */
@Configuration
@EnableCaching
@ConditionalOnClass(LettuceConnectionFactory.class)
@ConditionalOnMissingBean({JedisCluster.class})
public class RedisUtils {
//
//    @Bean
//    public JedisCluster getJedisCluster(){
//        Set<HostAndPort> hostAndPorts=new HashSet<>();
//        hostAndPorts.add(new HostAndPort("172.17.202.1",6379));
//        hostAndPorts.add(new HostAndPort("172.17.202.2",6379));
//        hostAndPorts.add(new HostAndPort("172.17.202.3",6379));
//
//        JedisPoolConfig jedisPoolConfig=new JedisPoolConfig();
//        jedisPoolConfig.setMaxIdle(10);
//        jedisPoolConfig.setMaxTotal(10);
//        jedisPoolConfig.setMinIdle(3);
//        JedisCluster jedisCluster=new JedisCluster(hostAndPorts,3000,2000,3,jedisPoolConfig);
//        return jedisCluster;
//    }

    @Bean("redisTemplate")
    public RedisTemplate<Object,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory)throws Exception {
        RedisTemplate redisTemplate=new RedisTemplate();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer redisSerializer=new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        redisSerializer.setObjectMapper(objectMapper);
        redisTemplate.setValueSerializer(redisSerializer);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }


//    @Bean
//    public RedisConnectionFactory redisConnectionFactory(){
//        RedisClusterConfiguration redisClusterConfiguration=new RedisClusterConfiguration();
//        List<RedisNode> redisNodeList=new ArrayList<>();
//        redisNodeList.add(new RedisNode("172.17.202.1",6379));
//        redisNodeList.add(new RedisNode("172.17.202.2",6379));
//        redisNodeList.add(new RedisNode("172.17.202.3",6379));
//        redisClusterConfiguration.setClusterNodes(redisNodeList);
//        RedisConnectionFactory redisConnectionFactory=new LettuceConnectionFactory(redisClusterConfiguration);
//        return redisConnectionFactory;
//    }



}
