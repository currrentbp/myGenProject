package com.currentbp.Interesting.likou.mianshiti.complete;

import java.util.HashSet;
import java.util.Set;

/**
 * @author baopan
 * @createTime 2020/9/11 17:25
 */
public class T0101 {
    /*
    实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
示例 1：
输入: s = "leetcode"
输出: false
示例 2：
输入: s = "abc"
输出: true
限制：
0 <= len(s) <= 100
如果你不使用额外的数据结构，会很加分。
解题思路：
1、使用set，通过判断是否已近存在该值
2、使用bigmap这种结构，判断是否存在
     */

    public boolean isUnique(String astr) {
        Set<Character> keys = new HashSet<>();
        boolean result = true;

        for (int i = 0; i < astr.length(); i++) {
            if (keys.contains(astr.charAt(i))) {
                result = false;
                break;
            }
            keys.add(astr.charAt(i));
        }

        return result;
    }
}
