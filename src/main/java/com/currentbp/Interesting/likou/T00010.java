package com.currentbp.Interesting.likou;

import com.currentbp.util.all.Assert;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 20190109
 */
public class T00010 {
    /*
    给定一个字符串 (s) 和一个字符模式 (p)。实现支持 '.' 和 '*' 的正则表达式匹配。

'.' 匹配任意单个字符。
'*' 匹配零个或多个前面的元素。
匹配应该覆盖整个字符串 (s) ，而不是部分字符串。

说明:

s 可能为空，且只包含从 a-z 的小写字母。
p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
示例 1:

输入:
s = "aa"
p = "a"
输出: false
解释: "a" 无法匹配 "aa" 整个字符串。
示例 2:

输入:
s = "aa"
p = "a*"
输出: true
解释: '*' 代表可匹配零个或多个前面的元素, 即可以匹配 'a' 。因此, 重复 'a' 一次, 字符串可变为 "aa"。
示例 3:

输入:
s = "ab"
p = ".*"
输出: true
解释: ".*" 表示可匹配零个或多个('*')任意字符('.')。
示例 4:

输入:
s = "aab"
p = "c*a*b"
输出: true
解释: 'c' 可以不被重复, 'a' 可以被重复一次。因此可以匹配字符串 "aab"。
示例 5:

输入:
s = "mississippi"
p = "mis*is*p*."
输出: false
     */

    //todo not work
    //https://leetcode-cn.com/problems/regular-expression-matching/

    @Test
    public void t1() {
        Assert.isTrue(!isMatch1("aa", "a"), "error");
        Assert.isTrue(isMatch1("aa", "a*"), "error");
        Assert.isTrue(isMatch1("ab", ".*"), "error");
        Assert.isTrue(isMatch1("aab", "c*a*b"), "error");
        Assert.isTrue(!isMatch1("mississippi", "mis*is*p*."), "error");
    }

    public boolean isMatch1(String s, String p) {
        //都为空或者空串时，表示匹配
        if ((null == s && null == p) || ("".equals(s) && "".equals(p))) {
            return true;
        }
        //如果输入的字符串不为空，但是匹配项为空，表示不符
        if("".equals(p) && !"".equals(s)){
            return false;
        }
        p = p.trim();
        for (int i = 0; i < s.length(); i++) {
            switch (p.charAt(0)) {
                case '.':
                    if (p.length() >= 2 && p.charAt(1) == '*') {
                        while(true){

                            break;
                        }
                        return isMatch1(s,p);
                    }
                break;
                case '*':
                    break;
                default:
                    break;
            }
        }
        return false;
    }
}
