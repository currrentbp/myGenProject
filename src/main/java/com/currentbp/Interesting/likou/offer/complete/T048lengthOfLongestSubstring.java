package com.currentbp.Interesting.likou.offer.complete;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author baopan
 * @createTime 20221228
 */
public class T048lengthOfLongestSubstring {
    /*
请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
示例1:
输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:
输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:
输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
   请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。

解题思路1：
1、暴力拆解：从第一个字符开始一个个试，看最长的是多长
解题思路2：
1、动态规划：记录方式：
定义一个数组，dp[i]=3表示这个数组前n个是不同的，判断i+1时，只需要判断3个内是否有i+1这个字符，最后遍历dp找到最大值即可
     */

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            max = Math.max(max, getMax(s, i));
            if (max + i > s.length()) {
                break;
            }
        }
        return max;
    }

    private int getMax(String s, int start) {
        Set<Character> temp = new HashSet<>();
        for (int i = start; i < s.length(); i++) {
            if (temp.contains(s.charAt(i))) {
                break;
            } else {
                temp.add(s.charAt(i));
            }
        }
        return temp.size();
    }


}
