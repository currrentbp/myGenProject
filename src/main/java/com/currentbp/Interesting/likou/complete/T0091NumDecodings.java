package com.currentbp.Interesting.likou.complete;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author baopan
 * @createTime 20220830
 */
public class T0091NumDecodings {
    /*
    一条包含字母A-Z 的消息通过以下映射进行了 编码 ：
'A' -> "1"
'B' -> "2"
...
'Z' -> "26"
要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
"AAJF" ，将消息分组为 (1 1 10 6)
"KJF" ，将消息分组为 (11 10 6)
注意，消息不能分组为 (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
题目数据保证答案肯定是一个 32 位 的整数。
示例 1：
输入：s = "12"
输出：2
解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
示例 2：
输入：s = "226"
输出：3
解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
示例 3：
输入：s = "0"
输出：0
解释：没有字符映射到以 0 开头的数字。
含有 0 的有效映射是 'J' -> "10" 和 'T'-> "20" 。
由于没有字符，因此没有有效的方法对此进行解码，因为所有数字都需要映射。
提示：
1 <= s.length <= 100
s 只包含数字，并且可能包含前导零。
     */

    @Test
    public void t1() {
        System.out.println(numDecodings1("111111111111111111111111111111111111111111111"));
//        System.out.println(Integer.parseInt("01"));
    }

    public int numDecodings(String s) {
        Set<String> result = new HashSet<>();

        return result.size();
    }

    /**
     * 递归：超时了
     * 10
     * 1213
     * 1     12
     * 2 13   1 3
     * 21 3   13
     */
    public int numDecodings1(String s) {
        if (s == null || s.equals("")) {
            return 1;
        }
        if (s.length() == 1) {
            return canDecoding(s) ? 1 : 0;
        }
        String one = s.substring(0, 1);
        String two = s.substring(0, 2);

        int result1 = 1;
        int result2 = 1;
        if (canDecoding(one)) {
            result1 *= numDecodings1(s.substring(1));
        }else{
            result1 = 0;
        }
        if (canDecoding(two)) {
            result2 *= numDecodings1(s.substring(2));
        }else{
            result2=0;
        }
        return result1 + result2;
    }

    private boolean canDecoding(String s) {
        if (s == null || s.equals("")) {
            return false;
        }
        if (Integer.parseInt(s) <= 0 || Integer.parseInt(s) > 26) {
            return false;
        }
        if (s.indexOf("0") == 0) {
            return false;
        }
        return true;
    }
}
