package com.currentbp.Interesting.likou;

import com.currentbp.util.all.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baopan
 * @createTime 20181228
 */
public class T00006 {
    /*
    将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。

比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：

L   C   I   R
E T O E S I I G
E   D   H   N
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。

请你实现这个将字符串进行指定行数变换的函数：

string convert(string s, int numRows);
示例 1:

输入: s = "LEETCODEISHIRING", numRows = 3
输出: "LCIRETOESIIGEDHN"
示例 2:

输入: s = "LEETCODEISHIRING", numRows = 4
输出: "LDREOEIIECIHNTSG"
解释:

L     D     R
E   O E   I I
E C   I H   N
T     S     G
     */

    //https://leetcode-cn.com/problems/zigzag-conversion/
    @Test
    public void t1() {
        String convert = convert1("LEETCODEISHIRING", 3);
        Assert.isTrue(convert.equals("LCIRETOESIIGEDHN"), "error");
        String convert2 = convert1("LEETCODEISHIRING", 4);
        Assert.isTrue(convert2.equals("LDREOEIIECIHNTSG"), "error");
    }

    public String convert1(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }
        if (null == s || s.length() == 0){
            return s;
        }
        String result = "";
        for (int i = 0; i < numRows; i++) {
            result += getConvert(s, i, numRows);
        }
        return result;
    }

    /*
    大概公式：N*length+(（-1*index +length）or index),这是一个类似sin函数
     */
    private String getConvert(String s, int start, int numRows) {
        String result = "";
        int flag = -1;
        int cycle = s.length() / (numRows - 1) + 1;
        for (int j = 0; j < cycle; j++) {
            if (0 == start || start == numRows - 1) {
                int x = start + (numRows - 1) * 2 * j;
                if (x >= s.length()) {
                    break;
                }
                result += s.substring(x, x + 1);
            } else {
                int x = j * (numRows - 1) + (flag == -1 ? start : (numRows - 1 - start));
                if (x >= s.length()) {
                    break;
                }
                flag *= -1;
                result += s.substring(x, x + 1);
            }
        }
        return result;
    }
}
