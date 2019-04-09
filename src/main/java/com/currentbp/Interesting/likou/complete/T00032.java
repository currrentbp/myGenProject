package com.currentbp.Interesting.likou.complete;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

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
    public void t1() {
        System.out.println(longestValidParentheses3("()((((()))"));
        System.out.println(longestValidParentheses3("(()"));
        System.out.println(longestValidParentheses3(")()())"));
    }


    public int longestValidParentheses(String s) {
        if (null == s || 0 == s.length()) {
            return 0;
        }
        //true：已经使用了，false:未使用
        boolean[] tag = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            tag[i] = false;
        }

        handle(s, tag);
        int count = 0;
        int max = 0;
        for (boolean b : tag) {
            if (b) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 0;
            }
        }
        return Math.max(max, count);
    }

    private boolean handle(String s, boolean[] tag) {
        boolean flag = false;
        List<Integer> tagIndex = new ArrayList<>();
        for (int i = 0; i < tag.length; i++) {
            if (!tag[i]) {
                tagIndex.add(i);
            }
        }
        if (1 >= tagIndex.size()) {
            return true;
        }

        for (int i = 0; i < tagIndex.size(); i++) {
            if (i + 1 < tagIndex.size()) {
                if (s.charAt(tagIndex.get(i)) == '(' && s.charAt(tagIndex.get(i + 1)) == ')') {
                    flag = true;
                    tag[tagIndex.get(i)] = true;
                    tag[tagIndex.get(i + 1)] = true;
                    i++;
                }
            }
        }

        return flag && handle(s, tag);
    }

    public int longestValidParentheses2(String s) {
        if (null == s || 0 == s.length()) {
            return 0;
        }
        //true：已经使用了，false:未使用
        boolean[] tag = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            tag[i] = false;
        }

        handle2(s, tag);
        int count = 0;
        int max = 0;
        for (boolean b : tag) {
            if (b) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 0;
            }
        }
        return Math.max(max, count);
    }

    private boolean handle2(String s, boolean[] tag) {
        boolean flag = false;
        for (int i = 0; i < tag.length; ) {
            int[] beforeAfter = new int[2];
            if (getTwoIndex(tag, i, beforeAfter)) {
                if (s.charAt(beforeAfter[0]) == '(' && s.charAt(beforeAfter[1]) == ')') {
                    flag = true;
                    tag[beforeAfter[0]] = true;
                    tag[beforeAfter[1]] = true;
                    i = beforeAfter[1] + 1;
                } else {
                    i++;
                }
            } else {
                i++;
            }
        }

        return flag && handle2(s, tag);
    }

    private boolean getTwoIndex(boolean[] tag, int index, int[] beforeAfterIndex) {
        if (index >= tag.length) {
            return false;
        }

        int before = -1, after = -1;
        boolean result = false;
        while (true) {
            if (index >= tag.length) {
                break;
            }
            if (-1 == before && !tag[index]) {
                before = index;
                index++;
                continue;
            }
            if (-1 != before && !tag[index]) {
                after = index;
                result = true;
                break;
            }
            index++;
        }
        beforeAfterIndex[0] = before;
        beforeAfterIndex[1] = after;
        return result;
    }

    /*
    官方最佳答案
     */
    public int longestValidParentheses3(String s) {
        char[] chars = s.toCharArray();
        return Math.max(calc(chars, 0, 1, chars.length, '('), calc(chars, chars.length - 1, -1, -1, ')'));
    }

    private static int calc(char[] chars, int start, int step, int end, char cTem) {
        int max = 0, sum = 0, currLen = 0, validLen = 0;
        for (; start != end; start += step) {
            sum += (chars[start] == cTem ? 1 : -1);
            currLen++;
            if (sum < 0) {
                max = max > validLen ? max : validLen;
                sum = 0;
                currLen = 0;
                validLen = 0;
            } else if (sum == 0) {
                validLen = currLen;
            }
        }
        return max > validLen ? max : validLen;
    }

}
