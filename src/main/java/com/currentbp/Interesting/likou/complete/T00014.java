package com.currentbp.Interesting.likou.complete;

import com.currentbp.util.all.Assert;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 20190114
 */
public class T00014 {
    /*
编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1:

输入: ["flower","flow","flight"]
输出: "fl"
示例 2:

输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。
说明:

所有输入只包含小写字母 a-z 。
     */
    //https://leetcode-cn.com/problems/longest-common-prefix/

    @Test
    public void t1() {
        Assert.isTrue(longestCommonPrefix(new String[]{"c", "c"}).equals("c"), "error");
        Assert.isTrue(longestCommonPrefix(new String[]{"", ""}).equals(""), "error");
        Assert.isTrue(longestCommonPrefix(new String[]{"flower", "flow", "flight"}).equals("fl"), "error");
        Assert.isTrue(longestCommonPrefix(new String[]{"dog", "racecar", "car"}).equals(""), "error");
    }

    public String longestCommonPrefix(String[] strs) {
        if (null == strs || 0 == strs.length) {
            return "";
        }
        if (1 >= strs.length) {
            return strs[0];
        }
        String str = strs[0];
        if (0 == str.length()) {
            return "";
        }

        String result = "";
        int index = 0;
        while (true) {
            for (int i = 1; i < strs.length; i++) {
                if (str.length() <= index || strs[i].length() <= index || str.charAt(index) != strs[i].charAt(index)) {
                    return result;
                }
            }
            result += str.charAt(index);
            index++;
        }
    }
}
