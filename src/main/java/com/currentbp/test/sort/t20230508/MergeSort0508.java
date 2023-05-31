package com.currentbp.test.sort.t20230508;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author baopan
 * @createTime 2023/5/8 22:59
 */
public class MergeSort0508 {
    /*
    归并排序
     */
    @Test
    public void t1() {
        StringUtil.printObject(mergeSort(new int[]{1, 2, 3}));
        StringUtil.printObject(mergeSort(new int[]{3, 2, 1}));
        StringUtil.printObject(mergeSort(new int[]{3, 1, 2}));
        StringUtil.printObject(mergeSort(new int[]{1, 3, 2}));
        Map<String, String> map = new HashMap<>();
        map.put("1", "2");
        map.entrySet().stream().forEach(x -> {
            System.out.println(x.getKey() + "  " + x.getValue());
        });
    }

    private int[] mergeSort(int[] sources) {
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
        for (int i = 0, j = oneLeft; i < newSources.length; i++, j++) {
            sources[j] = newSources[i];
        }
    }


}
