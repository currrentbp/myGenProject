package com.currentbp.test.sort.t20230404;

import com.currentbp.test.sort.SortTestUtil;
import com.currentbp.util.all.StringUtil;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 4/4/2023 10:05 AM
 */
public class ShellSort {
    @Test
    public void t1() {
        int[] ints = {11, 1, 3, 2, 7, 5, 0, 4, 2};
        myMaopaoSort2(ints);
        StringUtil.printObject(ints);
    }


    private void myMaopaoSort(int[] sources) {
        int length = sources.length;
        for (int gap = (int) Math.floor(length / 2); gap > 0; gap = (int) Math.floor(gap / 2)) {

            for (int i = 0; i < length - 1; i++) {
                int minIndex = i + 1;
                for (int j = minIndex; j < length; j++) {
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

    private void myMaopaoSort2(int[] sources) {
        StringUtil.printObject(sources);
        int len = sources.length;
        for (int gap = (int) Math.floor(len / 2); gap > 0; gap = (int) Math.floor(gap / 2)) {
            // 注意：这里和动图演示的不一样，动图是分组执行，实际操作是多个分组交替执行
            for (int i = gap; i < len; i++) {
                int j = i;
                int current = sources[i];
                while (j - gap >= 0 && current < sources[j - gap]) {
                    sources[j] = sources[j - gap];
                    StringUtil.printObject(sources);
                    j = j - gap;
                }
                sources[j] = current;
                StringUtil.printObject(sources);
                System.out.println("=========================");
            }
        }
    }
}
