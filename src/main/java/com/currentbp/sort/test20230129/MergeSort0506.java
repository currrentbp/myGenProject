package com.currentbp.sort.test20230129;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 5/6/2023 9:04 AM
 */
public class MergeSort0506 {
    /*
    归并排序
     */

    @Test
    public void t1() {
        StringUtil.printObject(mergeSort(new int[]{1, 2, 3}));
        StringUtil.printObject(mergeSort(new int[]{3, 2, 1}));
        StringUtil.printObject(mergeSort(new int[]{3, 1, 2}));
        StringUtil.printObject(mergeSort(new int[]{11, 9, 10, 3, 1, 2, 7, 8, 6, 5, 4, 2}));
    }

    public int[] mergeSort(int[] sources) {
        if (sources == null || sources.length <= 1) {
            return sources;
        }

        doMergeSort(sources, 0, sources.length - 1);
        return sources;
    }

    private void doMergeSort(int[] sources, int left, int right) {
        if (left >= right) {
            return;
        }

        if (left + 1 == right) {
            doMerge(sources, left, left, right, right);
        } else {
            int middle = (left + right) / 2;
            doMergeSort(sources, left, middle);
            doMergeSort(sources, middle + 1, right);
            doMerge(sources, left, middle, middle + 1, right);
        }
    }

    private void doMerge(int[] sources, int oneLeft, int oneRight, int twoLeft, int twoRight) {
        if (oneLeft > oneRight || twoLeft > twoRight) {
            return;
        }
        int[] newSources = new int[twoRight - oneLeft + 1];
        int oneIndex = oneLeft, twoIndex = twoLeft, newIndex = 0;
        while (oneIndex <= oneRight || twoIndex <= twoRight) {
            if (oneIndex > oneRight) {
                newSources[newIndex++] = sources[twoIndex++];
                continue;
            }
            if (twoIndex > twoRight) {
                newSources[newIndex++] = sources[oneIndex++];
                continue;
            }
            if (sources[oneIndex] < sources[twoIndex]) {
                newSources[newIndex++] = sources[oneIndex++];
            } else {
                newSources[newIndex++] = sources[twoIndex++];
            }
        }
        for (int i = oneLeft, j = 0; i <= twoRight; i++, j++) {
            sources[i] = newSources[j];
        }
    }

}
