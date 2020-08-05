package com.currentbp.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author baopan
 * @createTime 2020/7/17 10:50
 */
public abstract class LocalCache<K, V> {

    //最大时间：每个value的最大存活时间
    private Long maxTime;
    //缓存值
    private Map<K, CacheValue> localValues = new HashMap<>();

    public LocalCache(){}

    public V get(K k) {
        //1、直接获取到了，而且没有超时
        //2、获取到了，但是超时了，需要走超时删除数据并加载功能
        //3、没有获取到，需要走加载功能
        CacheValue cacheValue = localValues.get(k);
        long currentTime = System.currentTimeMillis();
        if (null != cacheValue) {//获取到了value
            Long timeOut = cacheValue.getTimeOut();
            if (null == timeOut || timeOut <= 0 || timeOut - currentTime >= 0) {//没有超时时间 or 没有超时
                if (1 == cacheValue.status.get()) {
                    V value = (V) cacheValue.getValue();
                    System.out.println("use cache,k:" + k + " value:" + value);
                    return value;
                } else {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("not timeout,but loading ,k:" + k);
                    return get(k);
                }
            } else {//超时了
                System.out.println("timeout and loading ,k:" + k);
                timeOutLoading(k);//此处没有判断加载数据本身的操作是否超时
                V value = (V) localValues.get(k).getValue();
                System.out.println("timeout and loading ,k:" + k + " value:" + value);
                return value;
            }
        } else {//没有获取到value，则需要加载
            doLoading(k);//此处没有判断加载数据本身的操作是否超时
            V value =(V) localValues.get(k).getValue();
            System.out.println("no cache ,k:" + k + " value:" + value);
            return value;
        }
    }

    /**
     * 超时主动删除原有数据，并添加新数据
     *
     * @param k
     */
    private void timeOutLoading(K k) {
        CacheValue cacheValue = localValues.get(k);
        //状态：1：可正常读，2：正在加载，
        int status1 = cacheValue.status.get();
        if (status1 == 1) {
            boolean nowUpdate = cacheValue.status.compareAndSet(1, 2);
            if (nowUpdate) {//允许当前线程加载
                doLoading(k);
            } else {//表示现在有线程在更新该变量
                while (cacheValue.status.get() == 2) {
                }//如果状态一直是2，表示一直在加载中，则一直等待
                return;
            }
        }
    }

    private synchronized void doLoading(K k) {
        CacheValue cacheValue = localValues.get(k);
        if (null == cacheValue) {
            cacheValue = new CacheValue();
            cacheValue.status.set(2);
            if (null == maxTime || maxTime <= 0) {
                cacheValue.setTimeOut(0L);//默认没有超时时间
            } else {
                cacheValue.setTimeOut(System.currentTimeMillis() + maxTime);
            }
            localValues.put(k, cacheValue);
        }

//        if(k.equals(15)){
//            try {
//                Thread.sleep(11111);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }//测试阻塞

        V loading = loading(k);//此处可以使用异步方式
        cacheValue.setValue(loading);
        cacheValue.status.compareAndSet(2,1);
    }

    public Long getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(Long maxTime) {
        this.maxTime = maxTime;
    }

    abstract V loading(K k);
}

class CacheValue<V> {

    //超时时间（初始化时是一个未来时间），为空或者小于等于0表示没有超时时间（永不超时）
    private Long timeOut;

    //状态：1：可正常读，2：正在加载，
    public AtomicInteger status = new AtomicInteger(1);

    private V value;

    public Long getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(Long timeOut) {
        this.timeOut = timeOut;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
