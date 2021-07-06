package com.currentbp.Interesting.likou.offer;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 20210630
 */
public class T066ConstructArr {
    /*
给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
示例:
输入: [1,2,3,4,5]
输出: [120,60,40,30,24]
解题思路：重点：不能使用除法
     */
    @Test
    public void t1() {
        StringUtil.printObject(constructArr(new int[]{1, 2, 3, 4, 5}));
    }

    public int[] constructArr(int[] a) {
        int[] result = new int[a.length];

        return result;
    }
}
