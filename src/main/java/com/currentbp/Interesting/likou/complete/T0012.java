package com.currentbp.Interesting.likou.complete;

import com.currentbp.util.all.Assert;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 20190111
 */
public class T0012 {
    /*
罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。

字符          数值
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。

通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：

I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。

示例 1:

输入: 3
输出: "III"
示例 2:

输入: 4
输出: "IV"
示例 3:

输入: 9
输出: "IX"
示例 4:

输入: 58
输出: "LVIII"
解释: L = 50, V = 5, III = 3.
示例 5:

输入: 1994
输出: "MCMXCIV"
解释: M = 1000, CM = 900, XC = 90, IV = 4.
     */
    //https://leetcode-cn.com/problems/integer-to-roman/

    @Test
    public void t1() {
        Assert.isTrue(intToRoman(500).equals("D"), "error");
        Assert.isTrue(intToRoman(3).equals("III"), "error");
        Assert.isTrue(intToRoman(4).equals("IV"), "error");
        Assert.isTrue(intToRoman(9).equals("IX"), "error");
        Assert.isTrue(intToRoman(58).equals("LVIII"), "error");
        Assert.isTrue(intToRoman(1994).equals("MCMXCIV"), "error");
    }

    public String intToRoman(int num) {
        if (num <= 0 || num > 3999) {
            return "";
        }
        String result = "";
        int precision = 1000;
        while (true) {
            int before = num / precision;
            result += get1(before, precision);
            num = num % precision;
            precision /= 10;
            if (precision == 0) {
                break;
            }
        }
        return result;
    }

    private String get1(int x, int precision) {
        String result = "";
        if (x == 0) {
            return result;
        }
        switch (precision) {
            case 1000:
                result = repeat("M", x);
                break;
            case 100:
                result = (x == 9 ? "CM" : "")
                        + (5 <= x && x <= 8 ? "D" + repeat("C", x - 5) : "")
                        + (4 == x ? "CD" : "")
                        + (x <= 3 ? repeat("C", x) : "");
                break;
            case 10:
                result = (x == 9 ? "XC" : "")
                        + (5 <= x && x <= 8 ? "L" + repeat("X", x - 5) : "")
                        + (4 == x ? "XL" : "")
                        + (x <= 3 ? repeat("X", x) : "");
                break;
            case 1:
                result = (x == 9 ? "IX" : "")
                        + (5 <= x && x <= 8 ? "V" + repeat("I", x - 5) : "")
                        + (4 == x ? "IV" : "")
                        + (x <= 3 ? repeat("I", x) : "");
                break;
            default:
                break;
        }
        return result;
    }

    private String repeat(String original, int x) {
        String result = "";
        for (int i = 0; i < x; i++) {
            result += original;
        }
        return result;
    }


    /*
    官网最佳答案
     */
    static String[] str = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    static int[] value = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    public String intToRoman2(int num) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (num > 0) {
            while (num >= value[i]) {
                num -= value[i];
                sb.append(str[i]);
            }
            i++;
        }
        return sb.toString();
    }
}
