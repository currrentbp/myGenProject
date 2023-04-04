package com.currentbp.test.sort.t20230404;

import com.currentbp.test.sort.SortTestUtil;
import com.currentbp.util.all.StringUtil;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 4/4/2023 9:19 AM
 */
public class SelectionSort {
    @Test
    public void t1() {
        int[] ints = {11, 1, 3, 2, 7, 5, 0, 4, 2};
        myMaopaoSort(ints);
        StringUtil.printObject(ints);
    }

    private void myMaopaoSort(int[] sources) {
        for (int i = 0; i < sources.length - 1; i++) {
            int minIndex = i + 1;
            for (int j = minIndex; j < sources.length; j++) {
                if (sources[j] < sources[minIndex]) {
                    minIndex = j;
                }
            }
            if (sources[i] > sources[minIndex]) {
                SortTestUtil.swap(sources, i, minIndex);
            }
        }

    }
}
