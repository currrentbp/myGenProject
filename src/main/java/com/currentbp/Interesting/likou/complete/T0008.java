package com.currentbp.Interesting.likou.complete;

import com.currentbp.util.all.Assert;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author baopan
 * @createTime 20190108
 */
public class T0008 {
    /*
    请你来实现一个 atoi 函数，使其能将字符串转换成整数。

首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。

当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。

该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。

注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。

在任何情况下，若函数不能进行有效的转换时，请返回 0。

说明：

假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，qing返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。

示例 1:

输入: "42"
输出: 42
示例 2:

输入: "   -42"
输出: -42
解释: 第一个非空白字符为 '-', 它是一个负号。
     我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
示例 3:

输入: "4193 with words"
输出: 4193
解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
示例 4:

输入: "words and 987"
输出: 0
解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
     因此无法执行有效的转换。
示例 5:

输入: "-91283472332"
输出: -2147483648
解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
     因此返回 INT_MIN (−231) 。
     */

    //https://leetcode-cn.com/problems/string-to-integer-atoi/

    @Test
    public void t1() {
        Assert.isTrue(myAtoi("2147483648") == -2147483648, "error");
        Assert.isTrue(myAtoi("+") == Integer.MIN_VALUE, "error");
        Assert.isTrue(myAtoi("4193sf") == 4193, "error");
        Assert.isTrue(myAtoi("   -42") == -42, "error");
        Assert.isTrue(myAtoi("4193 with words") == 4193, "error");
        Assert.isTrue(myAtoi("words and 987") == 0, "error");
        Assert.isTrue(myAtoi("-91283472332") == -2147483648, "error");
    }

    @Test
    public void t2() {
        String str = "+";
        String pattern = "(((^\\+)|(^-)|^\\d)\\d*)";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str.trim());
        Assert.isTrue(m.find(), "error");
        String group = m.group(0);
        System.out.println("===" + group + "++++");
        Assert.isTrue(group.equals("4193"), "error");
    }

    public int myAtoi(String str) {
        if (null == str || str.trim().equals("")) {
            return 0;
        }
        int result = 0;
        String pattern = "(((^\\+)|(^-)|^\\d)\\d*)";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str.trim());
        if (m.find()) {
            String group = m.group(0);
            if ("+".equals(group) || "-".equals(group)) {
                return 0;
            }
            try {
                result = Integer.parseInt(group);
            } catch (Exception e) {
                if ("-".equals(group.substring(0, 1))) {
                    result = Integer.MIN_VALUE;
                } else {
                    result = Integer.MAX_VALUE;
                }
            }

        } else {
            result = 0;
        }
        return result;
    }

    /*
    官方最佳答案
     */
    public int myAtoi2(String s) {
        int state = 0;
        long sum = 0;
        boolean isPositive = true;
        for (int index = 0; index < s.length(); index++) {
            final char current = s.charAt(index);
            switch (state) {
                case 0:
                    if (current == '-') {
                        isPositive = false;
                        state = 1;
                    } else if (current == '+') {
                        state = 1;
                    } else if (current >= '0' && current <= '9') {
                        state = 1;
                        index = index - 1;
                    } else if (current == ' ') {
                        continue;
                    } else {
                        return 0;
                    }
                    break;
                case 1:
                    if (current >= '0' && current <= '9') {
                        sum = sum * 10 + (current - '0');
                        if (isPositive && sum >= Integer.MAX_VALUE) {
                            sum = Integer.MAX_VALUE;
                            return ((int) sum);
                        } else if (!isPositive && sum * -1 <= Integer.MIN_VALUE) {
                            sum = Integer.MIN_VALUE;
                            return ((int) sum);
                        }
                    } else {
                        if (!isPositive) {
                            sum = sum * -1;
                        }
                        return ((int) sum);
                    }
                    break;
            }
        }
        if (!isPositive) {
            sum = sum * -1;
        }
        return ((int) sum);
    }
}
