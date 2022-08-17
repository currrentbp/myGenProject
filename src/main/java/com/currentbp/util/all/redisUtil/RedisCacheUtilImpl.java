package com.currentbp.util.all.redisUtil;

import com.alibaba.fastjson2.JSON;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.SortingParams;

import java.util.*;

/**
 * 连接redis集群实现类
 *
 * @author wzp
 * @date 2016年11月29日
 */
public class RedisCacheUtilImpl implements RedisCacheUtil {

    /**
     * JedisCluster 对象
     */
    private static JedisCluster jedis;

    /**
     * 读取redis配置文件
     */
    private static ResourceBundle rb;

    static {
        try {
            rb = ResourceBundle.getBundle("rediscache");
            jedis = getJedisCluster();
        } catch (Exception e) {
            jedis = null;
        }
    }

    /**
     * 获取JedisCluster对象
     */
    private static JedisCluster getJedisCluster() {
        JedisPoolConfig config = new JedisPoolConfig();
        //连接耗尽时是否阻塞, false报异常,ture阻塞直到超时, 默认true
        config.setBlockWhenExhausted(true);
        //最大空闲连接数, 默认8个
        config.setMaxIdle(Integer.parseInt(rb.getString("redis.server.maxidle")));
        //最大连接数, 默认8个
        config.setMaxTotal(Integer.parseInt(rb.getString("redis.server.maxtotal")));
        //获取连接时的最大等待毫秒数
        config.setMaxWaitMillis(Long.parseLong(rb.getString("redis.server.maxwaitmillis")));
        //在获取连接的时候检查有效性
        config.setTestOnBorrow("true".equalsIgnoreCase(rb.getString("redis.server.testonborrow")));
        Set<HostAndPort> nodes = new HashSet<HostAndPort>();
        String[] ips = rb.getString("redis.server.addrs").split(",");
        String[] ports = rb.getString("redis.server.ports").split(",");
        for (int i = 0; i < ips.length; i++) {
            nodes.add(new HostAndPort(ips[i], Integer.parseInt(ports[i])));
        }
        //返回JedisCluster对象
        //Set<HostAndPort> jedisClusterNode, int connectionTimeout, int soTimeout,int maxAttempts, String password
        return new JedisCluster(nodes, Integer.parseInt(rb.getString("redis.connection.timeout")), Integer.parseInt(rb.getString("redis.sotimeout")), Integer.parseInt(rb.getString("redis.maxAttempts")), rb.getString("redis.server.password"), config);
    }


    public String get(String key) {
        return jedis.get(key);
    }


    public <T> T get(String key, Class<T> clazz) {
        return JSON.parseObject(get(key), clazz);
    }


    public <T> List<T> getList(String key, Class<T> clazz) {
        return JSON.parseArray(get(key), clazz);
    }


    public Long del(String key) {
        return jedis.del(key);
    }


    public Boolean exists(String key) {
        return jedis.exists(key);
    }


    public Long expire(String key, int seconds) {
        return jedis.expire(key, seconds);
    }


    public Long ttl(String key) {
        return jedis.ttl(key);
    }


    public String set(String key, String value) {
        return jedis.set(key, value);
    }


    public String setex(String key, int seconds, String value) {
        return jedis.setex(key, seconds, value);
    }


    public <T> String set(String key, T value) {
        return jedis.set(key, JSON.toJSONString(value));
    }


    public <T> String setex(String key, int seconds, T value) {
        return jedis.setex(key, seconds, JSON.toJSONString(value));
    }

    public <T> Long setnx(String key, T value) {
        return jedis.setnx(key, JSON.toJSONString(value));
    }


    public Long strlen(String key) {
        return jedis.strlen(key);
    }


    public Long append(String key, String value) {
        return jedis.append(key, value);
    }


    public String hget(String key, String field) {
        return jedis.hget(key, field);
    }


    public <T> T hget(String key, String field, Class<T> clazz) {
        return JSON.parseObject(jedis.hget(key, field), clazz);
    }


    public <T> List<T> hgetList(String key, String field, Class<T> clazz) {
        return JSON.parseArray(jedis.hget(key, field), clazz);
    }


    public Map<String, String> hgetAll(String key) {
        return jedis.hgetAll(key);
    }


    public Long hset(String key, String field, String value) {
        return jedis.hset(key, field, value);
    }


    public <T> Long hset(String key, String field, T value) {
        return jedis.hset(key, field, JSON.toJSONString(value));
    }


    public Long hincrBy(String key, String field) {
        return hincrBy(key, field, 1);
    }


    public Long hincrBy(String key, String field, long value) {
        return jedis.hincrBy(key, field, value);
    }


    public Double hincrByFloat(String key, String field, double value) {
        return jedis.hincrByFloat(key, field, value);
    }


    public Boolean hexists(String key, String field) {
        return jedis.hexists(key, field);
    }


    public List<String> hvals(String key) {
        return jedis.hvals(key);
    }


    public Set<String> hkeys(String key) {
        return jedis.hkeys(key);
    }


    public List<String> hmget(String key, String... fields) {
        return jedis.hmget(key, fields);
    }


    public String hmset(String key, Map<String, String> hash) {
        return jedis.hmset(key, hash);
    }


    public Long hlen(String key) {
        return jedis.hlen(key);
    }


    public Long hdel(String key, String... fields) {
        return jedis.hdel(key, fields);
    }


    public Long sadd(String key, String... members) {
        return jedis.sadd(key, members);
    }


    public Set<String> smembers(String key) {
        return jedis.smembers(key);
    }


    public Long srem(String key, String... members) {
        return jedis.srem(key, members);
    }


    public Long scard(String key) {
        return jedis.scard(key);
    }


    public Boolean sismember(String key, String member) {
        return jedis.sismember(key, member);
    }


    public Long incr(String key) {
        return jedis.incr(key);
    }


    public Long incrBy(String key, long integer) {
        return jedis.incrBy(key, integer);
    }


    public Long decr(String key) {
        return jedis.decr(key);
    }


    public Long decrBy(String key, long integer) {
        return jedis.decrBy(key, integer);
    }


    public Long lpush(String key, String... strings) {
        return jedis.lpush(key, strings);
    }


    public <T> Long lpush(String key, @SuppressWarnings("unchecked") T... values) {
        String str[] = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            str[i] = JSON.toJSONString(values[i]);
        }
        return jedis.lpush(key, str);
    }


    public String lpop(String key) {
        return jedis.lpop(key);
    }


    public Long rpush(String key, String... strings) {
        return jedis.rpush(key, strings);
    }


    public <T> Long rpush(String key, @SuppressWarnings("unchecked") T... values) {
        String str[] = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            str[i] = JSON.toJSONString(values[i]);
        }
        return jedis.rpush(key, str);
    }


    public Long llen(String key) {
        return jedis.llen(key);
    }


    public List<String> lrange(String key, long start, long end) {
        return jedis.lrange(key, start, end);
    }


    public <T> List<T> lrange(String key, long start, long end, Class<T> classz) {
        List<String> list = jedis.lrange(key, start, end);
        if (list == null) {
            return null;
        }
        List<T> newList = new ArrayList<T>(list.size());
        for (String str : list) {
            newList.add(JSON.parseObject(str, classz));
        }
        return newList;
    }


    public Long lrem(String key, String value) {
        return jedis.lrem(key, 0, value);
    }


    public Long lrem(String key, long count, String value) {
        return jedis.lrem(key, count, value);
    }


    public String lset(String key, long index, String value) {
        return jedis.lset(key, index, value);
    }


    public String ltrim(String key, long start, long end) {
        return jedis.ltrim(key, start, end);
    }


    public String lindex(String key, long index) {
        return jedis.lindex(key, index);
    }


    public String type(String key) {
        return jedis.type(key);
    }


    public List<String> sort(String key) {
        return jedis.sort(key);
    }


    public List<String> sort(String key, SortingParams sortingParameters) {
        return jedis.sort(key, sortingParameters);
    }

    public String getSet(String cacheKey, String valueOf) {
        return jedis.getSet(cacheKey,valueOf);
    }

    /**
     * @param lock    所标记key
     * @param expired 超时时间  超时认为发生死锁，强制得到锁
     * @return
     * @Method：获取锁标记 必须释放
     */
    public boolean acquireLock(String lock, long expired) {
        // 1. 通过SETNX试图获取一个lock
        boolean success = false;
        long value = System.currentTimeMillis() + expired + 1;
        long acquired = jedis.setnx(lock, String.valueOf(value));
        //SETNX成功，则成功获取一个锁
        if (acquired == 1)
            success = true;
            //SETNX失败，说明锁仍然被其他对象保持，检查其是否已经超时
        else {
            long oldValue = Long.valueOf(jedis.get(lock));

            //超时
            if (oldValue < System.currentTimeMillis()) {
                String getValue = jedis.getSet(lock, String.valueOf(value));
                // 获取锁成功
                if (Long.valueOf(getValue) == oldValue)
                    success = true;
                    // 已被其他进程捷足先登了
                else
                    success = false;
            }
            //未超时，则直接返回失败
            else
                success = false;
        }
        return success;
    }

    /**
     * @param lock
     * @Method：释放锁
     */
    public Long releaseLock(String lock) {
        Long del = null;
        long current = System.currentTimeMillis();
        // 避免删除非自己获取得到的锁
        if (current < Long.valueOf(jedis.get(lock))) {
            del = jedis.del(lock);
        }
        return del;
    }


}