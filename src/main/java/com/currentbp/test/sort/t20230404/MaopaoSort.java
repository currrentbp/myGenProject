package com.currentbp.test.sort.t20230404;

import com.currentbp.test.sort.SortTestUtil;
import com.currentbp.util.all.StringUtil;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 4/4/2023 8:51 AM
 */
public class MaopaoSort {
    @Test
    public void t1() {
        int[] ints = {11, 1, 3, 2, 7, 5};
        myMaopaoSort(ints);
        StringUtil.printObject(ints);
    }

    private void myMaopaoSort(int[] ints) {
        for (int i = 0; i < ints.length - 1; i++) {
            for (int j = 0; j < ints.length - i - 1; j++) {
                if (ints[j] > ints[j + 1]) {
                    SortTestUtil.swap(ints, j, j + 1);
                }
            }
        }
    }
}
