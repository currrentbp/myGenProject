package com.currentbp.sort.test20230129;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 1/29/2023 11:37 AM
 */
public class MaoPao0129 {
    /*
冒泡：从小到大
     */
    @Test
    public void t1() {
        int[] source = new int[]{1,2,10,5,3,4,7,6,9,8,2};
        mpSort(source);
        StringUtil.printObject(source);
    }

    private void mpSort(int[] source) {
        if (source == null || source.length <= 1) {
            return;
        }

        for (int i = 0; i < source.length; i++) {
            for (int j = i + 1; j < source.length; j++) {
                if (source[i] > source[j]) {
                    swap(source, i, j);
                }
            }
        }
    }

    private void swap(int[] source, int i, int j) {
        int temp = source[i];
        source[i] = source[j];
        source[j] = temp;
    }
}
