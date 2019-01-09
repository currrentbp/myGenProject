package com.currentbp.Interesting.likou;

import com.currentbp.util.all.Assert;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 20190109
 */
public class T00009 {
    /*
    判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

示例 1:

输入: 121
输出: true
示例 2:

输入: -121
输出: false
解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
示例 3:

输入: 10
输出: false
解释: 从右向左读, 为 01 。因此它不是一个回文数。
进阶:

你能不将整数转为字符串来解决这个问题吗？
     */
    //todo not work
    //https://leetcode-cn.com/problems/palindrome-number/

    @Test
    public void t1() {
        Assert.isTrue(!isPalindrome(2147483647), "error");
        Assert.isTrue(isPalindrome(121), "error");
        Assert.isTrue(!isPalindrome(-121), "error");
        Assert.isTrue(!isPalindrome(10), "error");
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String temp = "" + x;
        String temp1 = "";
        for (int i = 0; i < temp.length(); i++) {
            temp1 = temp.substring(i, i + 1) + temp1;
        }
        try {
            int value = Integer.parseInt(temp1);
            if (x == value) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    /*
    官网最佳答案
     */
    public static boolean isPalindrome2(int x) {
        int origin = x;
        int result = 0;

        if (x < 0) return false;

        // 123
        while (x > 0) {
            int temp = x % 10;
            x = x / 10;
            result = result * 10 + temp;
        }

        if (result == origin) return true;
        return false;
    }
}
