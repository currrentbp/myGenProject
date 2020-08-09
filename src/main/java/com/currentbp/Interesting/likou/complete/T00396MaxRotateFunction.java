package com.currentbp.Interesting.likou.complete;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 2020/8/9 10:12
 */
public class T00396MaxRotateFunction {
/*
给定一个长度为 n 的整数数组 A 。
假设 Bk 是数组 A 顺时针旋转 k 个位置后的数组，我们定义 A 的“旋转函数” F 为：
F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1]。
计算F(0), F(1), ..., F(n-1)中的最大值。
注意:
可以认为 n 的值小于 105。
示例:
A = [4, 3, 2, 6]
F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
所以 F(0), F(1), F(2), F(3) 中的最大值是 F(3) = 26 。

解题思路：
1、穷举所有可能
2、f1 = f0 + sum - n * An-1，其中sum 是数组的和
 */

    @Test
    public void t1() {
//        StringUtil.printObject(maxRotateFunction(new int[]{4, 3, 2, 6}));
        StringUtil.printObject(maxRotateFunction(new int[]{1,2,3,4,5,6,7,8,9,10}));
    }

    public int maxRotateFunction(int[] A) {
        if(null == A || 0 == A.length){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            max = Math.max(max, doMax(A, i));
        }
        return max;
    }

    private int doMax(int[] A, int index) {
        int sum = 0;
        System.out.print("F(" + index + ")= ");
        for (int i = 0; i < A.length; i++) {
            int other = (i + index) % A.length;
            sum = sum + A[i] * other;
            System.out.print(other + "*" + A[i] + " + ");
        }
        System.out.println(" = " + sum);
        return sum;
    }

    /**
     * 官网最佳答案
     */
    public int maxRotateFunction2(int[] A) {
        int sum=0;
        int dp=0;
        for(int i=0;i<A.length;i++){
            sum+=A[i];
            dp+=i*A[i];
        }
        int max=dp;
        for(int i=1;i<A.length;i++){
            dp=(dp+sum)-A.length*A[A.length-i];
            if(dp>max) max=dp;
        }
        return max;
    }
}
