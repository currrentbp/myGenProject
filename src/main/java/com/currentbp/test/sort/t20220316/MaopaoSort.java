package com.currentbp.test.sort.t20220316;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 20220316
 */
public class MaopaoSort {
    /*
冒泡排序
     */
    @Test
    public void t1() {
        int[] ints = {11,1, 3, 2, 7, 5};
        myMaopaoSort(ints);
        StringUtil.printObject(ints);
    }

    private void myMaopaoSort(int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            for (int j = i + 1; j < ints.length; j++) {
                if (ints[i] > ints[j]) {
                    swap(ints, i, j);
                }
            }
        }
    }

    private void swap(int[] ints, int left, int right) {
        int temp = ints[left];
        ints[left] = ints[right];
        ints[right] = temp;
    }
}
