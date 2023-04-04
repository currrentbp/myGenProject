package com.currentbp.test.sort;

/**
 * @author baopan
 * @createTime 4/4/2023 8:52 AM
 */
public class SortTestUtil {
    public static void swap(int[] sources, int oneIndex, int twoIndex) {
        if (sources == null || sources.length == 0
                || oneIndex >= sources.length
                || twoIndex >= sources.length) {
            return;
        }
        int temp = sources[oneIndex];
        sources[oneIndex] = sources[twoIndex];
        sources[twoIndex] = temp;
    }
}
