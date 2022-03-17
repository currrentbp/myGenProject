package com.currentbp.test.sort.t20220316;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 20220316
 */
public class KuaipaiSort {
    /*
快速排序
     */
    @Test
    public void t1(){
        int[] ints = {11,1, 3, 2, 7, 5};
        myKuaipaiSort(ints);
        StringUtil.printObject(ints);
    }

    private void myKuaipaiSort(int[] ints) {

    }

    private void swap(int[] ints, int left, int right) {
        int temp = ints[left];
        ints[left] = ints[right];
        ints[right] = temp;
    }
}