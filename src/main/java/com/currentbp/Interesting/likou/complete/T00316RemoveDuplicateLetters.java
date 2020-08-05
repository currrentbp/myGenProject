package com.currentbp.Interesting.likou.complete;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 2020/8/1 22:54
 */
public class T00316RemoveDuplicateLetters {
    /*
给你一个仅包含小写字母的字符串，请你去除字符串中重复的字母，使得每个字母只出现一次。
需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
示例 1:
输入: "bcabc"
输出: "abc"
示例 2:
输入: "cbacdcbc"
输出: "acdb"
解题思路：
1、看完题目，发现无法发现规律，看了解题思路后才发现重点是“字典序”，
哪个字符串大取决于两个字符串中 第一个对应不相等的字符 。
根据这个规则，任意一个以 a 开头的字符串都大于任意一个以 b 开头的字符串

2、判断一个字符是否出现过，并且判断是否比后续的字符大，如果出现过，而且比后续字符大
     */
    @Test
    public void t2() {
        StringUtil.printObject(getNewString("123456", 0));
        StringUtil.printObject(getNewString("123456", 1));
        StringUtil.printObject(getNewString("123456", 2));
        StringUtil.printObject(getNewString("123456", 3));
        StringUtil.printObject(getNewString("123456", 4));
        StringUtil.printObject(getNewString("123456", 5));
    }

    @Test
    public void t3() {
        StringUtil.printObject(removeDuplicateLetters3("abacb"));
        StringUtil.printObject(removeDuplicateLetters3("caccabad"));
        StringUtil.printObject(removeDuplicateLetters3("cbacdcbc"));
    }

    /**
     * 我的第二种策略：按照字母的顺序查找该字符是否出现了，如果没有出现则continue，
     * 如果出现了，判断是否出现多次，如果多次，则删除除去上次的字符的
     */
    public String removeDuplicateLetters3(String s) {//todo 算法错误
        return removeTheSame(s, 'a', (char) ('a' - 1));
    }

    private String removeTheSame(String s, char currentChar, char beforeChar) {
        if (currentChar > 'z') return s;
        if (!hasTheChar(s, currentChar)) {//如果不存在查找的字符，则查找下一个字符
            return removeTheSame(s, (char) (currentChar + 1), beforeChar);
        }
        String s1 = getRemoveCurrentChar(s, currentChar, beforeChar);
        return removeTheSame(s1, (char) (currentChar + 1), currentChar);
    }

    private String getRemoveCurrentChar(String s, char currentChar, char beforeChar) {
        int beforeIndex = getBeforeIndex(s, beforeChar);//获取上个字符的位置
        //如果当前字符和上个字符的距离是0，表示上个字符不存在，而当前字符刚好在第一个位置
        //如果当前字符在上个字符的后面，而且后面有多个，则按照距离，保留第一个，如：上个字符是a，s:bbbbabbb，结果是ab
        //如果当前字符在上个字符的前面，而且前面有多个，则按照距离，保留离上个字符最近的一个，如：上个字符是a，s:bbba，结果是ba
        for (int i = beforeIndex; i < s.length(); i++) {
            if (s.charAt(i) == currentChar) {
                return doGetRemoveCurrentChar(s, i);//右边有这个字符，删除排除这个位置的相同字符
            }
        }
        for (int i = beforeIndex; i >= 0; i--) {
            if (s.charAt(i) == currentChar) {
                return doGetRemoveCurrentChar(s, i);//左边有这个字符，删除排除这个位置的相同字符
            }
        }
        return s;//这种情况不会发生，因为上面的一个方法已经判断了，进入这里面的s必定会存在当前字符
    }

    private String doGetRemoveCurrentChar(String s, int index) {
        char currentChar = s.charAt(index);
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != currentChar) {
                result += s.charAt(i);
            }
            if (s.charAt(i) == currentChar && i == index) {
                result += s.charAt(i);
            }
        }
        return result;
    }

    private int getBeforeIndex(String s, char beforeChar) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == beforeChar) {
                result = i;
                break;
            }
        }
        return result;
    }

    private boolean hasTheChar(String s, char cha) {
        boolean result = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == cha) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Test
    public void t1() {
        StringUtil.printObject(removeDuplicateLetters("abacb"));
        StringUtil.printObject(removeDuplicateLetters("caccabad"));
    }

    public String removeDuplicateLetters(String s) {
        return removeEach(s, 0);
    }

    private String removeEach(String s, int index) {
        if (index >= s.length()) {
            return s;
        }
        if (isHas(s.charAt(index), s, index)) {//是否存在相同的字符
            if (index == s.length() - 1) {
                return removeEach(getNewString(s, index), 0);
            }
            if (index - 1 < s.length() && s.charAt(index) == s.charAt(index + 1)) {//判断是否是两个连续相等的字符，a== a，则a直接删除一个
                return removeEach(getNewString(s, index), 0);

            }
            if (beforeHas(s, index)) {//当前位置的字符之前出现过，则删除现在的
                return removeEach(getNewString(s, index), 0);
            }
            if (beforeHas(s, index + 1)) {//当前位置的后面一个字符之前出现过，则删除下一个字符
                return removeEach(getNewString(s, index + 1), 0);
            }
            if (index - 1 < s.length() && s.charAt(index) > s.charAt(index + 1)) {//判断是否有必要删除这个字符，b<a，则b需要删除
                //如果下一个字符之前已经确定了，就先删除下一个字符，
                return removeEach(getNewString(s, index), 0);
            }
        }
        return removeEach(s, ++index);
    }

    private boolean beforeHas(String s, int index) {
        boolean has = false;
        for (int i = 0; i < index; i++) {
            if (s.charAt(i) == s.charAt(index)) {
                has = true;
                break;
            }
        }
        return has;
    }

    private String getNewString(String s, int index) {
        String s1 = "";
        if (index == 0) {
            s1 += s.substring(index + 1);
        } else if (index == s.length() - 1) {
            s1 += s.substring(0, index);
        } else {
            s1 = s.substring(0, index) + s.substring(index + 1);
        }

        return s1;
    }

    //判断是否存在和该字符相同的字符
    private boolean isHas(char charAt, String s, int index) {
        boolean has = false;
        for (int i = 0; i < s.length(); i++) {
            if (i != index && s.charAt(i) == charAt) {
                has = true;
                break;
            }
        }
        return has;
    }


    /**
     * 官方最佳答案
     */
    public String removeDuplicateLetters2(String s) {
        if (s.length() == 0) {
            return "";
        }
        int[] cnt = new int[26];
        boolean[] seen = new boolean[26];
        int top = -1;
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        char[] data = new char[26];
        for (int i = 0; i < s.length(); i++) {
            if (seen[s.charAt(i) - 'a']) {
                cnt[s.charAt(i) - 'a']--;
                continue;
            }
            while (top >= 0 && s.charAt(i) < data[top] && cnt[data[top] - 'a'] > 0) {
                seen[data[top] - 'a'] = false;
                top--;
            }
            data[++top] = s.charAt(i);
            seen[s.charAt(i) - 'a'] = true;
            cnt[s.charAt(i) - 'a']--;
        }
        return String.valueOf(data, 0, top + 1);
    }
}
