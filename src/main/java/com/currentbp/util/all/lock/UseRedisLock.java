package com.currentbp.util.all.lock;

import com.currentbp.common.entity.Functions;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 20201202
 */
public class UseRedisLock {

    @Test
    public void t1(){
        RedisLock redisLock = new RedisLock();
        redisLock.tryLock("",10,getFun());
    }

    private Functions.Function0 getFun(){
        return new Functions.Function0() {
            @Override
            public Object apply() {
                return null;
            }
        };
    }



}
