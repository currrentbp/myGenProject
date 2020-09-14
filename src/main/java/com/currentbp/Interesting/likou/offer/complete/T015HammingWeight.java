package com.currentbp.Interesting.likou.offer.complete;

import com.currentbp.util.all.Assert;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 2020/9/11 17:49
 */
public class T015HammingWeight {
    /*
    请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。
    例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
示例 1：
输入：00000000000000000000000000001011
输出：3
解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
示例 2：
输入：00000000000000000000000010000000
输出：1
解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
示例 3：
输入：11111111111111111111111111111101
输出：31
解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
解题思路：
1、使用无符号右位移的算法
2、再使用与运算方法（x & 1），结果不是0就是该位置有非0数字
     */

    @Test
    public void t1() {
        Assert.isTrue(hammingWeight(9) == 2,"error");
    }

    public int hammingWeight(int n) {
        int result = 0;
        while (n != 0) {
            if ((n & 1) != 0) {
                result++;
            }
            n = n >>> 1;
        }
        return result;
    }
}
