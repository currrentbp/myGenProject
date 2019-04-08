package com.currentbp.Interesting.likou;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baopan
 * @createTime 20190404
 */
public class T00032 {
    /*
    给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。

示例 1:

输入: "(()"
输出: 2
解释: 最长有效括号子串为 "()"
示例 2:

输入: ")()())"
输出: 4
解释: 最长有效括号子串为 "()()"
     */
    @Test
    public void t2() {
        boolean b1 = false;
        boolean b2 = true;
        System.out.println(!(b1^b2));
    }

    @Test
    public void t1() {

    }

    public int longestValidParentheses(String s) {
        if (null == s || 0 == s.length()) {
            return 0;
        }

        boolean[] tag = new boolean [s.length()];
        for (int i = 0; i < s.length(); i++) {
            tag[i] = false;
        }

        boolean isOk = handle(s, tag);

        return 0;
    }

    private boolean handle(String s, boolean[] tag) {
        boolean flag = false;
        List<Integer> tagIndex = new ArrayList<>();
        for (int i=0;i<tag.length;i++) {

        }

        for (int i = 0; i < tagIndex.size(); i++) {
            if (i + 1 < tag.length) {
                if (s.charAt(i) == '(' && s.charAt(i + 1) == ')') {
                    //todo not work
                }
            }
        }
        return flag && handle(s, tag);
    }
}
