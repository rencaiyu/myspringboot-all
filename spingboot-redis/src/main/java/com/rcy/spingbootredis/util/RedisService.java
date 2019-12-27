package com.rcy.spingbootredis.util;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @description: redis 工具类，在实战中可以考虑实现一个接口
 * @author: rencaiyu 2019年12月26日 11:36
 **/
@Service("redisService")
public class RedisService {

    @Autowired
    private RedisDataSource redisDataSource;

    /**
     * 获取自增ID
     */
    public Long getId(String name) {
        Jedis jedis = null;
        try {
            jedis = redisDataSource.getRedisClient();
            Long result = jedis.incr(name);
            return result;
        } finally {
            redisDataSource.close(jedis);
        }
    }

    /**
     * 设置单个值
     */
    public String set(String key, String value) {
        Jedis jedis = null;
        try {
            jedis = redisDataSource.getRedisClient();
            String result = jedis.set(key, value);
            return result;
        } finally {
            redisDataSource.close(jedis);
        }
    }

    /**
     * 设置单个对象值
     */
    public String setObj(String key, Object value) throws IOException {
        Jedis jedis = null;
        try {
            jedis = redisDataSource.getRedisClient();
            String strValue = JSON.toJSONString(value);
            String result = jedis.set(key, strValue);
            return result;
        } finally {
            redisDataSource.close(jedis);
        }
    }

    /**
     * 获取单个值
     */
    public String get(String key) {
        Jedis jedis = null;
        try {
            jedis = redisDataSource.getRedisClient();
            String result = jedis.get(key);
            return result;
        } finally {
            redisDataSource.close(jedis);
        }
    }

    /**
     * key是否存在
     */
    public Boolean exists(String key) {
        Jedis jedis = null;
        try {
            jedis = redisDataSource.getRedisClient();
            Boolean result = jedis.exists(key);
            return result;
        } finally {
            redisDataSource.close(jedis);
        }
    }

    /**
     * 删除key
     */
    public Long del(String key) {
        Jedis jedis = null;
        try {
            jedis = redisDataSource.getRedisClient();
            Long l = jedis.del(key);
            return l;
        } finally {
            redisDataSource.close(jedis);
        }
    }

    /**
     * 删除一个或多个哈希表字段
     */
    public Long hdel(String key, String... field) {
        Jedis jedis = null;
        try {
            jedis = redisDataSource.getRedisClient();
            Long l = jedis.hdel(key, field);
            return l;
        } finally {
            redisDataSource.close(jedis);
        }
    }

    /**
     * 获取所有key
     */
    public Set<String> getAllKeys() {
        Jedis jedis = null;
        try {
            jedis = redisDataSource.getRedisClient();
            Set<String> result = jedis.keys("*");
            return result;
        } finally {
            redisDataSource.close(jedis);
        }
    }

    /**
     * 将一个或多个值插入到列表头部 没有列的时候自动创建
     */
    public Long lpush(String key, String value) {
        Jedis jedis = null;
        try {
            jedis = redisDataSource.getRedisClient();
            Long result = jedis.lpush(key, value);
            return result;
        } finally {
            redisDataSource.close(jedis);
        }
    }

    /**
     * 将一个或多个值插入到列表头部 没有列的时候自动创建
     */
    public Long lpushObj(String key, Object value) throws IOException {
        Jedis jedis = null;
        try {
            jedis = redisDataSource.getRedisClient();
            String strValue = JSON.toJSONString(value);
            Long result = jedis.lpush(key, strValue);
            return result;
        } finally {
            redisDataSource.close(jedis);
        }
    }

    /**
     * 移出并获取列表的第一个元素（最左）
     */
    public String lpop(String key) {
        Jedis jedis = null;
        try {
            jedis = redisDataSource.getRedisClient();
            String result = jedis.lpop(key);
            return result;
        } finally {
            redisDataSource.close(jedis);
        }
    }

    /**
     * 移除并获取列表最后一个元素(最右)
     */
    public String rpop(String key) {
        Jedis jedis = null;
        try {
            jedis = redisDataSource.getRedisClient();
            String result = jedis.rpop(key);
            return result;
        } finally {
            redisDataSource.close(jedis);
        }
    }

    /**
     * 获取列表长度
     */
    public Long llen(String key) {
        Jedis jedis = null;
        try {
            jedis = redisDataSource.getRedisClient();
            Long result = jedis.llen(key);
            return result;
        } finally {
            redisDataSource.close(jedis);
        }
    }

    /**
     * 获取存储在哈希表中指定字段的值
     */
    public String hget(String key, String field) {
        Jedis jedis = null;
        try {
            jedis = redisDataSource.getRedisClient();
            String result = jedis.hget(key, field);
            return result;
        } finally {
            redisDataSource.close(jedis);
        }
    }

    /**
     * 将哈希表 key 中的字段 field 的值设为 value
     */
    public Long hset(String key, String field, String value) {
        Jedis jedis = null;
        try {
            jedis = redisDataSource.getRedisClient();
            Long result = jedis.hset(key, field, value);
            return result;
        } finally {
            redisDataSource.close(jedis);
        }
    }

    /**
     * 将哈希表 key 中的字段 field 的值设为 value
     */
    public Long hsetObj(String key, String field, Object value) throws IOException {
        Jedis jedis = null;
        try {
            jedis = redisDataSource.getRedisClient();
            String strValue = JSON.toJSONString(value);
            Long result = jedis.hset(key, field, strValue);
            return result;
        } finally {
            redisDataSource.close(jedis);
        }
    }

    /**
     * 获取在哈希表中指定 key 的所有字段和值
     */
    public Map<String, String> hgetAll(String key) {
        Jedis jedis = null;
        try {
            jedis = redisDataSource.getRedisClient();
            Map<String, String> result = jedis.hgetAll(key);
            return result;
        } finally {
            redisDataSource.close(jedis);
        }
    }

    /**
     * 移除列表元素
     */
    public Long lrem(String key, String value) {
        Jedis jedis = null;
        try {
            jedis = redisDataSource.getRedisClient();
            long count = -1;// count = 0:移除表中所有与 VALUE 相等的值
            long result = jedis.lrem(key, count, value);
            return result;
        } finally {
            redisDataSource.close(jedis);
        }
    }

    /**
     * 移除列表元素(原始方法) 从存于 key 的列表里移除前 count 次出现的值为 value 的元素 count > 0: 从头往尾移除值为
     * value 的元素; count < 0: 从尾往头移除值为 value 的元素; count = 0: 移除所有值为 value 的元素
     */
    public Long lrem(String key, long count, String value) {
        Jedis jedis = null;
        try {
            jedis = redisDataSource.getRedisClient();
            long result = jedis.lrem(key, count, value);
            return result;
        } finally {
            redisDataSource.close(jedis);
        }
    }

    /**
     * 对一个列表进行修剪,让列表只保留指定区间内的元素,不在指定区间之内的元素都将被删除
     */
    public String ltrim(String key, long start, long end) {
        Jedis jedis = null;
        try {
            jedis = redisDataSource.getRedisClient();
            String result = jedis.ltrim(key, start, end);
            return result;
        } finally {
            redisDataSource.close(jedis);
        }
    }

    /**
     * 获取列表中所有元素
     */
    public List<String> lrange(String key, long start, long end) {
        Jedis jedis = null;
        try {
            jedis = redisDataSource.getRedisClient();
            List<String> result = jedis.lrange(key, start, end);
            return result;
        } finally {
            redisDataSource.close(jedis);
        }
    }

    /**
     * 指定的 key 设置值及其过期时间。如果 key 已经存在， SETEX 命令将会替换旧的值。单位为秒
     */
    public String setex(String key, int seconds, String value) {
        Jedis jedis = null;
        try {
            jedis = redisDataSource.getRedisClient();
            String result = jedis.setex(key, seconds, value);
            return result;
        } finally {
            redisDataSource.close(jedis);
        }
    }

    /**
     * 获取自增ID
     */
    public Long Incr(String key) {
        Jedis jedis = null;
        try {
            jedis = redisDataSource.getRedisClient();
            Long result = jedis.incr(key);
            return result;
        } finally {
            redisDataSource.close(jedis);
        }
    }

    /**
     * 指定的 key 设置其过期时间 单位为秒
     */
    public Long expire(String key, int seconds) {
        Jedis jedis = null;
        try {
            jedis = redisDataSource.getRedisClient();
            Long result = jedis.expire(key, seconds);
            return result;
        } finally {
            redisDataSource.close(jedis);
        }
    }

    /**
     * 用于移除给定 key 的过期时间，使得 key永不过期
     */
    public Long persist(String key) {
        Jedis jedis = null;
        try {
            jedis = redisDataSource.getRedisClient();
            Long result = jedis.persist(key);
            return result;
        } finally {
            redisDataSource.close(jedis);
        }
    }

    /**
     * 以秒为单位返回 key 的剩余过期时间
     */
    public Long ttl(String key) {
        Jedis jedis = null;
        try {
            jedis = redisDataSource.getRedisClient();
            Long result = jedis.ttl(key);
            return result;
        } finally {
            redisDataSource.close(jedis);
        }
    }

    /**
     * 以毫秒为单位返回 key 的剩余过期时间
     */
    public Long pttl(String key) {
        Jedis jedis = null;
        try {
            jedis = redisDataSource.getRedisClient();
            Long result = jedis.pttl(key);
            return result;
        } finally {
            redisDataSource.close(jedis);
        }
    }

    /**
     * 修改 key的名称
     */
    public String Rename(String old_key, String new_key) {
        Jedis jedis = null;
        try {
            jedis = redisDataSource.getRedisClient();
            String result = jedis.rename(old_key, new_key);
            return result;
        } finally {
            redisDataSource.close(jedis);
        }
    }
}
