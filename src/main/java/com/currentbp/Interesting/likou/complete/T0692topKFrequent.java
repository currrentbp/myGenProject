package com.currentbp.Interesting.likou.complete;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author baopan
 * @createTime 2023/5/15 23:18
 */
public class T0692topKFrequent {
    /*
给定一个单词列表words和一个整数 k ，返回前k个出现次数最多的单词。
返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率， 按字典顺序 排序。
示例 1：
输入: words = ["i", "love", "leetcode", "i", "love", "coding"], k = 2
输出: ["i", "love"]
解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
    注意，按字母顺序 "i" 在 "love" 之前。
示例 2：
输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
输出: ["the", "is", "sunny", "day"]
解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
    出现次数依次为 4, 3, 2 和 1 次。

     */

    @Test
    public void t1() {
        StringUtil.printObject(topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
        StringUtil.printObject(topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));
    }

    public List<String> topKFrequent(String[] words, int k) {
        if (words == null || words.length == 0) {
            return new ArrayList<>();
        }
        Map<String, Pair<Integer, Integer>> str2CountMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            Pair<Integer, Integer> count2IndexPair = str2CountMap.getOrDefault(words[i], Pair.of(0, i));
            count2IndexPair.setLeft(count2IndexPair.getLeft() + 1);
            str2CountMap.put(words[i], count2IndexPair);
        }

        List<Triple<Integer, String, Integer>> count2Str2Indexs = str2CountMap.entrySet().stream().map(kv -> {
            return Triple.of(kv.getValue().getLeft(), kv.getKey(), kv.getValue().getRight());
        }).collect(Collectors.toList());

        //Collections.sort(list, (a, b) -> map.get(b) - map.get(a));
        Collections.sort(count2Str2Indexs, (a, b) -> {
            if (a.getLeft() > b.getLeft()) {
                return -1;
            } else if (a.getLeft() < b.getLeft()) {
                return 1;
            } else {
                return a.getMiddle().compareTo(b.getMiddle());
            }
        });
//        StringUtil.printObject(count2Strs);
        return count2Str2Indexs.subList(0, k).stream().map(kv -> {
            return kv.getMiddle();
        }).collect(Collectors.toList());
    }
}



class Triple<K, M, V> {
    private K left;
    private M middle;
    private V right;

    public static <K, M, V> Triple<K, M, V> of(K left, M middle, V right) {
        Triple<K, M, V> kvPair = new Triple<>();
        kvPair.left = left;
        kvPair.middle = middle;
        kvPair.right = right;
        return kvPair;
    }

    public K getLeft() {
        return left;
    }

    public V getRight() {
        return right;
    }

    public M getMiddle() {
        return middle;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "left=" + left +
                ", middle=" + middle +
                ", right=" + right +
                '}';
    }
}
