package com.currentbp.Interesting.other;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 2020/8/21 18:24
 */
public class GetAnyWhereSum {
    /*
    数组，获取数组任意区间的总和，要求获取接口时间复杂度是O(1)
     */

    @Test
    public void t1() {
        int[] source = new int[]{1, 2, 3, 4, 10, 3};
        init(source);
        int sum = getSum(source,1,2);
        StringUtil.printObject(sum);
    }

    private int getSum(int[] source,int start,int end) {
        if(start>end){
            return 0;
        }
        if(null == sumValues|| 0 == sumValues.length){
            return 0;
        }

        if(start == end){
            return source[start];
        }
        if(start == 0){
            return sumValues[end];
        }
        int result = sumValues[end] - sumValues[start-1];

        return result;
    }

    int[] sumValues = null;

    public void init(int[] source) {
        sumValues = new int[source.length];
        int sum = 0;
        for (int i = 0; i < source.length; i++) {
            sum += source[i];
            sumValues[i] = sum;
        }
    }

    private int getSum2(int[] source,int start,int end) {

        return 0;
    }

    public void init2(int[] source) {
        sumValues = new int[source.length];
        int sum = 0;
        for (int i = 0; i < source.length; i++) {
            sum += source[i];
            sumValues[i] = sum;
        }
    }
}
