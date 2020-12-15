package com.currentbp.util.all.lock;

import com.currentbp.common.entity.Functions;
import com.currentbp.util.all.RandomUtil;
import com.currentbp.util.all.redisUtil.RedisCacheUtilImpl;

/**
 * 本类是关于redis的锁相关
 *
 * @author baopan
 * @createTime 20201201
 */
public class RedisLock {
    private RedisCacheUtilImpl redisCacheUtil;

    public <T> T tryLock(String cacheKey, int timeoutInSecond, Functions.Function0<T> func, int retryTimes) {
        return tryLock(cacheKey, timeoutInSecond, func, retryTimes, 7);
    }

    public <T> T tryLock(String cacheKey, int timeoutInSecond, Functions.Function0<T> func, int retryTimes, long sleepMillis) {
        Object ret = null;
        while (retryTimes > 0) {
            ret = tryLock(cacheKey, timeoutInSecond, func);
            if (ret != null) {
                break;
            }
            try {
                long ran = RandomUtil.getRandomNum(10) - 5;
                if (ran + sleepMillis > 0) {
                    sleepMillis = ran + sleepMillis;
                }
                Thread.sleep(sleepMillis);
            } catch (Exception e) {
                System.out.println("Jedis sleep Exception:" + e.getMessage());
            }
            retryTimes--;
        }
        return (T) ret;
    }

    public <T> T tryLock(String cacheKey, int timeoutInSecond, Functions.Function0<T> func) {
        long lockEnquired = 0L;

        String currentTimeMillis = String.valueOf(System.currentTimeMillis());
        long timeoutInMillis = timeoutInSecond * 1000L + 1;
        Object o = null;
        try {
            if ((lockEnquired = redisCacheUtil.setnx(cacheKey, String.valueOf(System.currentTimeMillis() + timeoutInMillis)).longValue()) > 0L) {
                o = func.apply();
                return (T) o;
            }
            //开始校验锁里存放的过期时间
            String lockedTime = redisCacheUtil.get(cacheKey);
            if (lockedTime == null) {//得到加锁失败后的瞬间，锁被释放,则立即重试
                return tryLock(cacheKey, timeoutInSecond, func);
            }

            if (lockedTime.compareTo(currentTimeMillis) >= 0) {
                return null;
            } else {//锁内时间表示已过期，尝试加锁
                String lastLockedTime = redisCacheUtil.getSet(cacheKey, String.valueOf(System.currentTimeMillis() + timeoutInMillis));
                if (lastLockedTime != null && lastLockedTime.compareTo(currentTimeMillis) >= 0) {
                    return null;
                }//lastLockedTime为null，表示前一瞬间，锁被释放，则说明本次尝试成功
            }

            lockEnquired = 1L;
            o = func.apply();
        } finally {
            if (lockEnquired > 0L && redisCacheUtil.get(cacheKey).compareTo(currentTimeMillis) >= 0) {
                redisCacheUtil.del(cacheKey);
            }
        }

        return (T) o;
    }


}
