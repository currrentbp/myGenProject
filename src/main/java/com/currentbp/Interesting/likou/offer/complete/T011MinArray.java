package com.currentbp.Interesting.likou.offer.complete;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 2020/8/31 21:39
 */
public class T011MinArray {
    /*
    把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
    输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
示例 1：
输入：[3,4,5,1,2]
输出：1
示例 2：
输入：[2,2,2,0,1]
输出：0
     */
    @Test
    public void t1(){
        StringUtil.printObject(minArray(new int[]{3,4,5,1,2}));
        StringUtil.printObject(minArray(new int[]{2,2,2,0,1}));
    }

    public int minArray(int[] numbers) {
        if(null == numbers || 0 == numbers.length){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<numbers.length;i++){
            min = Math.min(min,numbers[i]);
        }
        return min;
    }
}
