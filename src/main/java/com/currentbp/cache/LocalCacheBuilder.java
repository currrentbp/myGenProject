package com.currentbp.cache;

/**
 * @author baopan
 * @createTime 2020/7/17 10:50
 */
public class LocalCacheBuilder<K,V> {
    private Long maxTime;

    public LocalCacheBuilder(){}

    public static LocalCacheBuilder newBuilder() {
        return new LocalCacheBuilder();
    }

    public LocalCacheBuilder setMaxTime(long maxTime) {
        this.maxTime = maxTime;
        return this;
    }

    public <K1 extends K, V1 extends V> LocalCache<K1, V1> build(LocalCache<K1, V1> localCache) {
        localCache.setMaxTime(this.maxTime);
        return localCache;
    }
}
