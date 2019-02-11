package com.currentbp.Interesting.likou;

import com.currentbp.util.all.Assert;
import org.junit.Test;

import java.util.Stack;
import java.util.Vector;

/**
 * @author baopan
 * @createTime 20190211
 */
public class T00020 {
    /*
    给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

示例 1:

输入: "()"
输出: true
示例 2:

输入: "()[]{}"
输出: true
示例 3:

输入: "(]"
输出: false
示例 4:

输入: "([)]"
输出: false
示例 5:

输入: "{[]}"
输出: true
     */
    //https://leetcode-cn.com/problems/valid-parentheses/
    @Test
    public void t2(){
        char x = '1';
        Character x1 = "1".charAt(0);
        Assert.isTrue(x==x1,"error");
    }

    @Test
    public void t1() {
        Assert.isTrue(!isValid("]"), "error");
        Assert.isTrue(isValid("()"), "error");
        Assert.isTrue(isValid("()[]{}"), "error");
        Assert.isTrue(!isValid("(]"), "error");
        Assert.isTrue(!isValid("([)]"), "error");
        Assert.isTrue(isValid("{[]}"), "error");
    }

    public boolean isValid(String s) {
        if (null == s || 0 == s.length()) {
            return true;
        }

        Stack<Character> statusList = new Stack<>();
        for (int index = 0; index < s.length(); index++) {
            switch (s.charAt(index)) {
                case '(':
                case '[':
                case '{':
                    statusList.push(s.charAt(index));
                    break;
                case ')':
                    if(statusList.empty()){
                        return false;
                    }
                    Character top1 = statusList.pop();
                    if ('(' != top1) {
                        return false;
                    }
                    break;
                case ']':
                    if(statusList.empty()){
                        return false;
                    }
                    Character top2 = statusList.pop();
                    if ('[' != top2) {
                        return false;
                    }
                    break;
                case '}':
                    if(statusList.empty()){
                        return false;
                    }
                    Character top3 = statusList.pop();
                    if ('{' != top3) {
                        return false;
                    }
                    break;
                default:
                    break;
            }
        }
        if (statusList.empty()) {
            return true;
        } else {
            return false;
        }
    }

    /*
    官网最佳答案
     */
    public boolean isValid2(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        final char[] ca = s.toCharArray();
        final int len = ca.length;
        final char[] tca = new char[len / 2];
        char tc;
        int j = 0;
        for (int i = 0; i < len; i++) {
            switch (ca[i]) {
                case '(':
                case '{':
                case '[':
                    if (j >= tca.length) {
                        return false;
                    }
                    tca[j++] = ca[i];
                    continue;
                case ')':
                    tc = '(';
                    break;
                case '}':
                    tc = '{';
                    break;
                case ']':
                    tc = '[';
                    break;
                default:
                    return false;
            }
            if (j == 0) {
                return false;
            }
            if (tca[--j] != tc) {
                return false;
            }
        }
        return j == 0;
    }
}
