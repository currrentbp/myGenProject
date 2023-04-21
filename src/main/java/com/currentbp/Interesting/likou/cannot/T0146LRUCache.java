package com.currentbp.Interesting.likou.cannot;

import javafx.util.Pair;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author baopan
 * @createTime 2023/4/20 23:36
 */
public class T0146LRUCache {
    /*
请你设计并实现一个满足 LRU (最近最少使用) 缓存 约束的数据结构。
实现 LRUCache 类：
LRUCache(int capacity) 以 正整数 作为容量capacity 初始化 LRU 缓存
int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
void put(int key, int value)如果关键字key 已经存在，则变更其数据值value ；如果不存在，则向缓存中插入该组key-value 。
如果插入操作导致关键字数量超过capacity ，则应该 逐出 最久未使用的关键字。
函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
示例：
输入
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
输出
[null, null, null, 1, null, -1, null, -1, 3, 4]
解释
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // 缓存是 {1=1}
lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
lRUCache.get(1);    // 返回 1
lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
lRUCache.get(2);    // 返回 -1 (未找到)
lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
lRUCache.get(1);    // 返回 -1 (未找到)
lRUCache.get(3);    // 返回 3
lRUCache.get(4);    // 返回 4


怀疑case有问题，代码么有问题
     */
    @Test
    public void t1() {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        int i = lruCache.get(1);
        lruCache.put(3, 3);
        int i1 = lruCache.get(2);
        lruCache.put(4, 4);
        int i2 = lruCache.get(1);
        int i3 = lruCache.get(3);
        int i4 = lruCache.get(4);
        System.out.println("========");
    }

    @Test
    public void t2() {
        LRUCache lruCache = new LRUCache(2);
        int i = lruCache.get(2);
        lruCache.put(2, 6);
        int i1 = lruCache.get(1);
        lruCache.put(1, 5);
        lruCache.put(1, 2);
        int i2 = lruCache.get(1);
        int i3 = lruCache.get(2);
        System.out.println("========");
    }


    class LRUCache {
        int capacity;
        Integer[] sources;//严格按照活跃度0->1的顺数存放数据
        Map<Integer, Integer> kv = new HashMap<>();

        public LRUCache(int capacity) {
            this.capacity = capacity;
            sources = new Integer[capacity];
        }

        public int get(int key) {
            Integer value = kv.get(key);
            if (value == null) {
                return -1;
            } else {
                //重新排序
                resort(key, false);
            }
            return value;
        }

        public void put(int key, int value) {
            Integer oldValue = kv.get(key);
            if (null == oldValue) {
                resort(key, true);
            } else {
                resort(key, false);
            }
            kv.put(key, value);
        }

        private void resort(int key, boolean removeLast) {
            Integer key1 = key;
            Integer lastKey = sources[capacity - 1];
            //重新排序
            Integer[] temp = new Integer[capacity];
            temp[0] = key1;
            int index = 0, tempIndex = 1;
            while (index < capacity && tempIndex < capacity) {
                if (key1 == sources[index]) {
                    index++;
                    continue;
                }
                temp[tempIndex] = sources[index];
                index++;
                tempIndex++;
            }
            sources = temp;

            if (removeLast && lastKey != null) {
                kv.remove(lastKey);
            }
        }
    }
}
