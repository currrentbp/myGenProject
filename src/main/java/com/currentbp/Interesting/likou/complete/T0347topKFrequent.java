package com.currentbp.Interesting.likou.complete;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

import java.util.*;

/**
 * @author baopan
 * @createTime 2023/5/15 8:45
 */
public class T0347topKFrequent {
    /*
给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
示例 1:
输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]
示例 2:
输入: nums = [1], k = 1
输出: [1]
     */

    @Test
    public void t1() {
        StringUtil.printObject(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));
        StringUtil.printObject(topKFrequent(new int[]{1}, 1));
        StringUtil.printObject(topKFrequent(new int[]{-1,-1}, 1));
    }


    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        Map<Integer, Integer> num2CountMap = new HashMap<>();

        for (int num : nums) {
            Integer count = num2CountMap.getOrDefault(num, 0);
            num2CountMap.put(num, count + 1);
        }

        Pair<Integer, Integer>[] countNums = new Pair[num2CountMap.size()];
        int y = 0;
        for (Map.Entry<Integer, Integer> numCount : num2CountMap.entrySet()) {
            Integer key = numCount.getKey();//num
            Integer value = numCount.getValue();//count
            countNums[y++] = Pair.of(value, key);
        }

        mergeSort(countNums);

        return tops(countNums, k);
    }

    private int[] tops(Pair<Integer, Integer>[] countNums, int k) {
        int[] sources = new int[Math.min(countNums.length, k)];
        for (int i = 0; i < sources.length; i++) {
            sources[i] = countNums[i].getRight();
        }
        return sources;
    }

    private void mergeSort(Pair<Integer, Integer>[] pairs) {
        if (pairs == null || pairs.length == 0) {
            return;
        }
        doMergeSort(pairs, 0, pairs.length - 1);
    }

    private void doMergeSort(Pair<Integer, Integer>[] countNums, int left, int right) {
        if (left >= right) {
            return;
        }
        if (left + 1 == right) {
            doMerge(countNums, left, left, right, right);
        } else {
            int middle = (left + right) / 2;
            doMergeSort(countNums, left, middle);
            doMergeSort(countNums, middle + 1, right);
            doMerge(countNums, left, middle, middle + 1, right);
        }
    }

    private void doMerge(Pair<Integer, Integer>[] countNums, int oneLeft, int oneRight, int twoLeft, int twoRight) {
        if (oneLeft > oneRight || twoLeft > twoRight) {
            return;
        }

        Pair<Integer, Integer>[] newSources = new Pair[twoRight - oneLeft + 1];
        int oneIndex = oneLeft, twoIndex = twoLeft, newIndex = 0;

        while (oneIndex <= oneRight || twoIndex <= twoRight) {
            if (oneIndex > oneRight) {
                newSources[newIndex++] = countNums[twoIndex++];
                continue;
            }
            if (twoIndex > twoRight) {
                newSources[newIndex++] = countNums[oneIndex++];
                continue;
            }

            if (countNums[oneIndex].getLeft() > countNums[twoIndex].getLeft()) {
                newSources[newIndex++] = countNums[oneIndex++];
            } else {
                newSources[newIndex++] = countNums[twoIndex++];
            }
        }
        for (int i = oneLeft, j = 0; j < newSources.length; i++, j++) {
            countNums[i] = newSources[j];
        }
    }


}
class Pair<K,V>{
    private K left;
    private V right;
    public static <K,V> Pair<K,V> of(K left,V right){
        Pair<K, V> kvPair = new Pair<>();
        kvPair.left = left;
        kvPair.right = right;
        return kvPair;
    }

    public K getLeft() {
        return left;
    }

    public V getRight() {
        return right;
    }

    public void setLeft(K left) {
        this.left = left;
    }

    public void setRight(V right) {
        this.right = right;
    }
}
