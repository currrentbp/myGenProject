package com.currentbp.test.sort.t20230714;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

public class MergeSort20230714 {

    @Test
    public void t1() {
        int[] sources = new int[]{1, 5, 3, 2, 4};
        int[] newSources = merge(sources);
        StringUtil.printObject(newSources);
    }

    private int[] merge(int[] sources) {
        if (sources == null || sources.length == 0) {
            return sources;
        }

        doSlip(sources, 0, sources.length - 1);

        return sources;
    }

    private void doSlip(int[] sources, int left, int right) {
        if (left >= right) {
            return;
        }

        if (left + 1 == right) {
            doMerge(sources, left, left, right, right);
        } else {
            int middle = (left + right) / 2;
            doSlip(sources, left, middle);
            doSlip(sources, middle + 1, right);
            doMerge(sources, left, middle, middle + 1, right);
        }
    }

    private void doMerge(int[] sources, int oneLeft, int oneRight, int twoLeft, int twoRight) {
        int oneIndex = oneLeft, twoIndex = twoLeft, newIndex = 0;
        int[] newSources = new int[twoRight - oneLeft];
        while (oneIndex<=oneRight || twoIndex<=twoRight) {
            if (oneIndex > oneRight) {
                newSources[newIndex++] = sources[twoIndex++];
            }
            if (twoIndex > twoRight) {
                newSources[newIndex++] = sources[oneIndex++];
            }
            if (sources[oneIndex] < sources[twoIndex]) {
                newSources[newIndex++] = sources[oneIndex++];
            } else {
                newSources[newIndex++] = sources[twoIndex++];
            }
        }
        for (int i = oneLeft, j = 0; i <= twoRight; i++) {
            sources[i++] = newSources[j++];
        }
    }

}
