package com.currentbp.Interesting.likou;

import com.currentbp.util.all.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author baopan
 * @createTime 20181227
 */
public class T00005 {
    /*
    给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：

输入: "cbbd"
输出: "bb"
     */
    public String longestPalindrome(String s) {
        if (null == s || 0 == s.length()) {
            return "";
        }
        int max = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int center = aroundText1(s, i);
            int two = aroundText2(s, i, i + 1);
            int len = Math.max(center, two);
            if (max < len) {
                max = len;
                start = center > two ? i - (len - 1) / 2 : i + 1 - len / 2;
                end = center > two ? i + 1 + (len - 1) / 2 : i + 1 + len / 2;
            }
        }
        return s.substring(start, end);
    }

    /**
     * 中间向两边扩展
     *
     * @param s
     * @param middle
     * @return
     */
    private int aroundText1(String s, int middle) {
        int l = middle, r = middle, left = middle, right = middle;
        int result = 1;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            left = l--;
            right = r++;
        }
        result = right - left + 1;
        return result;
    }

    /**
     * 两个边界向两边扩展
     *
     * @param s
     * @param left
     * @param right
     * @return
     */
    private int aroundText2(String s, int left, int right) {
        int l = left, r = right;
        int result = 1;
        boolean flag = false;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            flag = true;
            left = l--;
            right = r++;
        }
        result = !flag ? 0 : right - left + 1;
        return result;
    }

    /*
    官网解答
     */
    public String longestPalindrome2(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    @Test
    public void t1() {
        Assert.isTrue(longestPalindrome("1").equals("1"), "error");
        Assert.isTrue(longestPalindrome("11").equals("11"), "error");
        Assert.isTrue(longestPalindrome("111").equals("111"), "error");
        Assert.isTrue(longestPalindrome("1111").equals("1111"), "error");
        Assert.isTrue(longestPalindrome("212").equals("212"), "error");
        Assert.isTrue(longestPalindrome("123").equals("1"), "error");
        Assert.isTrue(longestPalindrome("12321").equals("12321"), "error");
        Assert.isTrue(longestPalindrome("123321").equals("123321"), "error");
        Assert.isTrue(longestPalindrome("1232").equals("232"), "error");
        Assert.isTrue(longestPalindrome("14545").equals("454"), "error");
        Assert.isTrue(longestPalindrome("112321").equals("12321"), "error");
    }
}
