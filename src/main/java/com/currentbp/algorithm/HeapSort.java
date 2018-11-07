package com.currentbp.algorithm;

import com.currentbp.util.all.Assert;

/**
 * 堆排序
 *
 * @author baopan
 * @createTime 20181105
 */
public class HeapSort {
    /*
    创建一个堆H[0..n-1]

把堆首（最大值）和堆尾互换

3. 把堆的尺寸缩小1，并调用shift_down(0),目的是把新的数组顶端数据调整到相应位置

4. 重复步骤2，直到堆的尺寸为1
     */
    public static void main(String[] args) {
        int[] array = new int[]{1, 14, 10, 3, 5, 8, 6};
        SortUtils.printArray(array);
        HeapSort.heapSort1(array);
        SortUtils.printArray(array);
        boolean sorted = SortUtils.isSorted(array);
        Assert.isTrue(sorted, "排序不正确");
    }

    public static void heapSort1(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        buildMaxHeap(array);
        for (int i = array.length - 1; i >= 1; i--) {
            SortUtils.exchangeElements(array, 0, i);
            maxHeap(array, i, 0);
        }
    }

    private static void buildMaxHeap(int[] array) {
        int half = array.length / 2;
        for (int i = half; i >= 0; i--) {
            maxHeap(array, array.length, i);
        }
    }

    private static void maxHeap(int[] array, int heapSize, int index) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;

        int largest = index;
        if (left < heapSize && array[left] > array[index]) {
            largest = left;
        }
        if (right < heapSize && array[right] > array[largest]) {
            largest = right;
        }
        if (index != largest) {
            SortUtils.exchangeElements(array, index, largest);
            SortUtils.printArray(array);
            maxHeap(array, heapSize, largest);
        }
    }

    public static void heapSort2(int[] array) {
        int heapSize = array.length;
        //这个循环是保证所有元素都能被遍历被排序到
        for (int index = heapSize; index >= 1; index--) {
            getMaxAndSort(array, index);
            SortUtils.exchangeElements(array, index - 1, 0);
            SortUtils.printArray(array);
        }
    }

    private static void getMaxAndSort(int[] array, int heapSize) {
        for (int flag = heapSize / 2; flag >= 0; flag--) {
            int left = flag * 2 + 1;
            int right = flag * 2 + 2;

            int targer = flag;
            if (left < heapSize) {
                int leftValue = array[left];
                int targerValue = array[targer];
                if (leftValue > targerValue) {
                    targer = left;
                }
            }
            if (right < heapSize) {
                int rightValue = array[right];
                int targerValue = array[targer];
                if (rightValue > targerValue) {
                    targer = right;
                }
            }
            if (targer != flag) {
                SortUtils.exchangeElements(array, targer, flag);
                SortUtils.printArray(array);
            }
        }
    }
}
