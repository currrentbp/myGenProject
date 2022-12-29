package com.currentbp.Interesting.likou.offer.complete;

import org.junit.Test;

import java.util.Set;

/**
 * @author baopan
 * @createTime 20221228
 */
public class T046translateNum {
    /*
给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
示例 1:
输入: 12258
输出: 5
解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"

解题思路1：
1、使用递归判断能否分解，如果能分解到最后则种类+1，不能分解到最后则种类+0
解题思路2：
1、使用动态规划：f(n)=f(n-1)+f(n-2)
2、具体的方程：
     */

    @Test
    public void t1(){
        System.out.println(translateNum(506));
    }

    public int translateNum(int num) {
        return tr(num + "");
    }

    private int tr(String num) {
        if (num == null || num.length() == 0) {
            return 1;
        }
        if (num.length() == 1) {
            return 1;
        }
        String two = num.substring(0, 2);
        if(0 <= Integer.parseInt(two) && Integer.parseInt(two) <= 9){
            return tr(num.substring(1));
        }
        return 0 <= Integer.parseInt(two) && Integer.parseInt(two) <= 25 ?
                tr(num.substring(2)) + tr(num.substring(1)) : tr(num.substring(1));
    }

    /**
     * 官方最佳答案
     */
    public int translateNum2(int num) {
        char str[] = String.valueOf(num).toCharArray();
        int n = str.length;
        int f[] = new int[n+1];


        for(int i=0;i<n;i++) {
            if(i==0) f[i] = f[i+1] = 1;
            else {
                if(str[i-1]=='1') f[i+1] = f[i] + f[i-1];
                else if(str[i-1]=='2' && str[i]>='0' && str[i]<='5') f[i+1] = f[i] + f[i-1];
                else f[i+1] = f[i];
            }
        }
        return f[n];
    }
}
