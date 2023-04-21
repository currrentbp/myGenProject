package com.currentbp.Interesting.likou.complete;

import com.currentbp.util.all.Assert;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 20190108
 */
public class T0007 {
    /*
    给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

示例 1:

输入: 123
输出: 321
 示例 2:

输入: -123
输出: -321
示例 3:

输入: 120
输出: 21
注意:

假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
     */

    @Test
    public void t1() {
        Assert.isTrue(reverse2(123) == 321, "error");
        Assert.isTrue(reverse2(-123) == -321, "error");
        Assert.isTrue(reverse(120) == 21, "error");
        Assert.isTrue(reverse(123456) == 654321, "error");
        Assert.isTrue(reverse(+123456) == 654321, "error");
        Assert.isTrue(reverse(123456789) == 987654321, "error");
    }

    //https://leetcode-cn.com/problems/reverse-integer/
    public int reverse(int x) {
        int result = 0;
        String source = "" + x;
        boolean isNegative = source.indexOf("-") > -1;
        String temp = isNegative ? "-" : "";
        for (int index = source.length() - 1; index >= 0; index--) {
            if (isNegative && index == 0) {
                break;
            }
            temp += source.substring(index, index + 1);
        }
        try {
            result = Integer.parseInt(temp);
        } catch (Exception e) {

        }
        return result;
    }

    /*
    官方最佳答案
     */
    public int reverse2(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

}
