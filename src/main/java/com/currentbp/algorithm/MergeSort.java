package com.currentbp.algorithm;

import com.currentbp.util.all.Assert;

/**
 * 归并算法
 *
 * @author baopan
 * @createTime 20181106
 */
public class MergeSort {
    /*
    1. 申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列

2. 设定两个指针，最初位置分别为两个已经排序序列的起始位置

3. 比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置

4. 重复步骤3直到某一指针达到序列尾

5. 将另一序列剩下的所有元素直接复制到合并序列尾
     */

    public static void main(String[] args){
        int[] array = new int[]{1, 14, 10, 3, 5, 8, 6};
        SortUtils.printArray(array);
        sort(array);
        Assert.isTrue(SortUtils.isSorted(array),"排序错误");
    }
    public static int[] sort(int[] array){
        return sort(array,0,array.length-1);
    }
    public static int[] sort(int[] a, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            sort(a, low, mid);
            sort(a, mid + 1, high);
            //左右归并
            merge(a, low, mid, high);
            SortUtils.printArray(a);
        }
        return a;
    }

    private static void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        // 把较小的数先移到新数组中
        while (i <= mid && j <= high) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = a[i++];
        }
        // 把右边边剩余的数移入数组
        while (j <= high) {
            temp[k++] = a[j++];
        }
        // 把新数组中的数覆盖nums数组
        for (int x = 0; x < temp.length; x++) {
            a[x + low] = temp[x];
        }
    }
}
