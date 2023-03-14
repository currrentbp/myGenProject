package com.currentbp.sort.mergeSort;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 2023/3/3 10:02
 */
public class MergeSort {

    @Test
    public void t1() {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        doSort(arr);
        StringUtil.printObject(arr);
    }

    private void doSort(int[] arr) {
        doSimpleMergeSort(arr, 0, arr.length - 1);
    }

    private void doSimpleMergeSort(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        if (left + 1 == right) {
            do1(arr, left, left, right, right);
        } else {
            int middle = (left + right + 1) / 2;
            doSimpleMergeSort(arr, left, middle);
            doSimpleMergeSort(arr, middle, right);
            do1(arr, left, middle, middle, right);
        }

    }

    private void do1(int[] arr, int oneLeft, int oneRight, int twoLeft, int twoRight) {
        int oneIndex = oneLeft, twoIndex = twoLeft;
        int[] newArr = new int[twoRight - oneLeft + 1];
        int newIndex = -1;
        while (true) {
            newIndex++;
            if (oneIndex > oneRight && twoIndex > twoRight) {
                break;
            }
            if (oneIndex > oneRight) {
                newArr[newIndex] = arr[twoIndex];
                twoIndex++;
                continue;
            }
            if (twoIndex > twoRight) {
                newArr[newIndex] = arr[oneIndex];
                oneIndex++;
                continue;
            }
            if (arr[oneIndex] <= arr[twoIndex]) {
                newArr[newIndex] = arr[oneIndex];
                oneIndex++;
            } else {
                newArr[newIndex] = arr[twoIndex];
                twoIndex++;
            }
        }
        for (int i = 0; i < newArr.length; i++, oneLeft++) {
            arr[oneLeft] = newArr[i];
        }
    }

    private void swap(int[] arr, int left, int right) {
        if (arr == null || arr.length == 0) {
            return;
        }

        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
