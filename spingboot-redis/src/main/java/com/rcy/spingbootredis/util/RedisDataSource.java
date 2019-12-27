package com.rcy.spingbootredis.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @description: 此处使用Jedis的连接池，类似于mysql的连接池
 * @author: rencaiyu 2019年12月26日 11:37
 **/
@Service("redisDataSource")
public class RedisDataSource {
    /**
     * 以下方式配置建议在集群下使用
     **/
//    @Resource
//    private JedisSentinelPool jedisSentinelPool;
//
//    public Jedis getRedisClient() {
//        return jedisSentinelPool.getResource();
//    }
//    public void close(Jedis jedis) {
//        if (jedis != null) {
//            jedis.close();
//        }
//    }


    @Autowired
    private JedisPool jedisPool;

    public Jedis getRedisClient() {
        return jedisPool.getResource();
    }

    public void close(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }
}
