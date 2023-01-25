package com.currentbp.Interesting.likou.offer.complete;

/**
 * @author baopan
 * @createTime 1/12/2023 10:32 PM
 */
public class T064sumNums {
    /*
    求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
     */

    public int sumNums(int n) {
        return n >= 0 ? sumNums(n - 1) + n : 0;
    }
}
