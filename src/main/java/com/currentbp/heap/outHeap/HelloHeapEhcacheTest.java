package com.currentbp.heap.outHeap;

import com.alibaba.fastjson2.JSON;
import org.ehcache.Cache;
import org.ehcache.config.CacheConfiguration;
import org.ehcache.config.ResourcePools;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.config.units.MemoryUnit;
import org.junit.Test;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 堆外内存使用：ehcache
 * @author baopan
 * @createTime 20210310
 */
public class HelloHeapEhcacheTest {
    private static Map<String, InHeapClass> inHeapCache = new HashMap<>();

    private static Cache<String, OffHeapClass> offHeapCache;

    static {
        ResourcePools resourcePools = ResourcePoolsBuilder.newResourcePoolsBuilder()
                .offheap(50, MemoryUnit.MB)//如果此处设置堆外内存过小，会直接将超过的部分丢弃
                .build();

        CacheConfiguration<String, OffHeapClass> configuration = CacheConfigurationBuilder
                .newCacheConfigurationBuilder(String.class, OffHeapClass.class, resourcePools)
                .build();

        offHeapCache = CacheManagerBuilder.newCacheManagerBuilder()
                .withCache("cacher", configuration)
                .build(true)
                .getCache("cacher", String.class, OffHeapClass.class);


        for (int i = 1; i < 10001; i++) {
            inHeapCache.put("InHeapKey" + i, new InHeapClass("InHeapKey" + i, "InHeapValue" + i));
            offHeapCache.put("OffHeapKey" + i, new OffHeapClass("OffHeapKey" + i, "OffHeapValue" + i));
        }
    }

    @Test
    public void t1() {
        System.out.println("===>" + JSON.toJSONString(inHeapCache.get("InHeapKey1")));
        System.out.println("===>" + JSON.toJSONString(offHeapCache.get("OffHeapKey1")));
        Iterator iterator = offHeapCache.iterator();
        int sum = 0;
        while (iterator.hasNext()) {
            System.out.println(JSON.toJSONString(iterator.next()));
            sum++;
        }
        System.out.println(sum);
        for (int i = 1; i < 10001; i++) {
            if (null == offHeapCache.get("OffHeapKey" + i)) {
                System.out.println("===>no cache,index:"+i);
            }
//            System.out.println("===>" + JSON.toJSONString(offHeapCache.get("OffHeapKey" + i)));
        }
    }


    private static class InHeapClass implements Serializable {
        private String key;
        private String value;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public InHeapClass(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }


    private static class OffHeapClass implements Serializable {
        private String key;
        private String value;

        public String getKey() {
            return key;
        }

        public OffHeapClass(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }


}
