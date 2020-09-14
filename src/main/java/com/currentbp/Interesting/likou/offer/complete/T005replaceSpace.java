package com.currentbp.Interesting.likou.offer.complete;

/**
 * @author baopan
 * @createTime 2020/8/30 23:31
 */
public class T005replaceSpace {
/*
请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
示例 1：
输入：s = "We are happy."
输出："We%20are%20happy."
限制：
0 <= s 的长度 <= 10000
 */

    public String replaceSpace(String s) {
        if (null == s || 0 == s.length()) {
            return s;
        }

        String result = "";
        for (int i = 0; i < s.length(); i++) {
            if (' ' == s.charAt(i)) {
                result = result+"%20" ;
            } else {
                result = result + s.charAt(i);
            }
        }
        return result;
    }
}
