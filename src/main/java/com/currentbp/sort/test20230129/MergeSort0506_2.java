package com.currentbp.sort.test20230129;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 5/6/2023 5:19 PM
 */
public class MergeSort0506_2 {
    /*
    归并算法
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

        int middle = (left + right) / 2;

        if (left + 1 == right) {
            doMerge(sources, left, left, right, right);
        } else {
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
        int newIndex = 0, oneIndex = oneLeft, twoIndex = twoLeft;
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
        for (int i = 0, j = oneLeft; i < newSources.length; i++, j++) {
            sources[j] = newSources[i];
        }

    }
}
