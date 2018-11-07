package com.currentbp.algorithm;

/**
 * 快速排序
 *
 * @author baopan
 * @createTime 20181018
 */
public class FastSort {
/*
1 从数列中挑出一个元素，称为 "基准"（pivot），

2 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作。

3 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。

递归的最底部情形，是数列的大小是零或一，也就是永远都已经被排序好了。虽然一直递归下去，但是这个算法总会退出，因为在每次的迭代（iteration）中，它至少会把一个元素摆到它最后的位置去。
 */
    public static void main(String[] args) {
        int[] a = {5,4,3,2,1};
        int start = 0;
        int end = a.length - 1;
        FastSort fastSort = new FastSort();

        fastSort.sort(a, start, end);
        SortUtils.printArray(a);

    }

    public void sort(int[] a, int low, int high) {
        int start = low;
        int end = high;
        int key = a[low];

        while (end > start) {
            //从后往前比较
            //如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
            while (end > start && a[end] >= key) {
                end--;
            }
            if (a[end] <= key) {
                swap(a,start,end);
            }
            //从前往后比较
            //如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
            while (end > start && a[start] <= key) {
                start++;
            }
            if (a[start] >= key) {
                swap(a,start,end);
            }
            //此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，右边的值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用
        }
        //递归
        if (start > low) {
            sort(a, low, start - 1);//左边序列。第一个索引位置到关键值索引-1
        }
        if (end < high) {
            sort(a, end + 1, high);//右边序列。从关键值索引+1到最后一个
        }
    }

    private void swap(int[] a,int start,int end){
        int temp = a[end];
        a[end] = a[start];
        a[start] = temp;
    }
}
