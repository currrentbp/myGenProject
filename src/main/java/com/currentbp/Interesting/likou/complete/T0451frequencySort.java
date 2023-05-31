package com.currentbp.Interesting.likou.complete;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author baopan
 * @createTime 2023/5/15 22:42
 */
public class T0451frequencySort {
    /*
给定一个字符串 s ，根据字符出现的 频率 对其进行 降序排序 。一个字符出现的 频率 是它出现在字符串中的次数。
返回 已排序的字符串。如果有多个答案，返回其中任何一个。
示例 1:
输入: s = "tree"
输出: "eert"
解释: 'e'出现两次，'r'和't'都只出现一次。
因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
示例 2:
输入: s = "cccaaa"
输出: "cccaaa"
解释: 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
注意"cacaca"是不正确的，因为相同的字母必须放在一起。
示例 3:
输入: s = "Aabb"
输出: "bbAa"
解释: 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
注意'A'和'a'被认为是两种不同的字符。

     */
    @Test
    public void t1() {
        StringUtil.printObject(frequencySort("tree"));
        StringUtil.printObject(frequencySort("cccaaa"));
        StringUtil.printObject(frequencySort("Aabb"));
    }

    public String frequencySort(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        char[] chars = s.toCharArray();
        Map<Character, Integer> char2CountMap = new HashMap<>();
        for (char aChar : chars) {
            Integer count = char2CountMap.getOrDefault(aChar, 0);
            char2CountMap.put(aChar, count + 1);
        }

        Pair<Integer, Character>[] count2Chars = new Pair[char2CountMap.size()];
        int index = 0;
        for (Map.Entry<Character, Integer> entry : char2CountMap.entrySet()) {
            Character key = entry.getKey();
            Integer count = entry.getValue();
            count2Chars[index++] = Pair.of(count, key);
        }

        //Collections.sort(list, (a, b) -> map.get(b) - map.get(a));
        mergeSort(count2Chars);

        return doStr(count2Chars);
    }

    private String doStr(Pair<Integer, Character>[] count2Chars) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <count2Chars.length; i++) {
            Pair<Integer, Character> count2Char = count2Chars[i];
            for(int j=0;j<count2Char.getLeft();j++){
                sb.append(count2Char.getRight());
            }
        }
        return sb.toString();
    }

    private void mergeSort(Pair<Integer, Character>[] pairs) {
        if (pairs == null || pairs.length == 0) {
            return;
        }
        doMergeSort(pairs, 0, pairs.length - 1);
    }

    private void doMergeSort(Pair<Integer, Character>[] countNums, int left, int right) {
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

    private void doMerge(Pair<Integer, Character>[] countNums, int oneLeft, int oneRight, int twoLeft, int twoRight) {
        if (oneLeft > oneRight || twoLeft > twoRight) {
            return;
        }

        Pair<Integer, Character>[] newSources = new Pair[twoRight - oneLeft + 1];
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

//class Pair<K, V> {
//    private K left;
//    private V right;
//
//    public static <K, V> Pair<K, V> of(K left, V right) {
//        Pair<K, V> kvPair = new Pair<>();
//        kvPair.left = left;
//        kvPair.right = right;
//        return kvPair;
//    }
//
//    public K getLeft() {
//        return left;
//    }
//
//    public V getRight() {
//        return right;
//    }
//}
