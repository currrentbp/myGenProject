package com.currentbp.Interesting.likou.complete;

import com.currentbp.util.all.Assert;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 2019/3/31 20:32
 */
public class T0028 {
    /*
    实现 strStr() 函数。

给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

示例 1:

输入: haystack = "hello", needle = "ll"
输出: 2
示例 2:

输入: haystack = "aaaaa", needle = "bba"
输出: -1
说明:

当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。

对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
     */

    @Test
    public void t1() {
        Assert.isTrue(0 == strStr("a", ""), "error");
        Assert.isTrue(2 == strStr("hello", "ll"), "error");
        Assert.isTrue(-1 == strStr("aaaaa", "bba"), "error");
    }

    public int strStr(String haystack, String needle) {
        if (null == haystack || null == needle) {
            return -1;
        }
        if(0 == haystack.length() && 0 == needle.length()){
            return 0;
        }
        if(0 == haystack.length() ){
            return -1;
        }
        if(0 == needle.length()){
            return 0;
        }
        int index = -1;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0) && haystack.length() - i >= needle.length()) {
                boolean flag = true;
                for (int j = 0; j < needle.length(); j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    index = i;
                    break;
                }
            }
        }
        return index;
    }
}
