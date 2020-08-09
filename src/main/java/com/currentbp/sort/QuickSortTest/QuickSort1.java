package com.currentbp.sort.QuickSortTest;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 2020/8/9 21:49
 */
public class QuickSort1 {

    @Test
    public void t1() {
        int[] arr = {10,7,2,4,7,62,3,4,2,1,8,9,19};
        quickSort(arr, 0, arr.length-1);
        StringUtil.printObject(arr);
    }

    /*
    排序思路：
    1、以最左边的数字A为基准，从左边开始找第一个数字B 大于A的，比较出右边第一个数字C 小于 A
    2、对调BC
    3、对调左边的数字和中间相遇的数字
    4、对中间相遇到的数字一拆为二，对两个数组分别递归
     */
    public void quickSort(int[] source, int high, int low) {
        if (low < high) {
            return;
        }
        int left = high, right = low;
        int temp = source[left];
        while (left < right) {
            //先从右边开始比较出小的数字
            while (left < right) {
                if (source[right] < temp) {
                    break;
                }
                right--;
            }
            //再从左边开始比较出大的数字
            while (left < right) {
                if (source[left] > temp) {
                    break;
                }
                left++;
            }
            if (left < right) {//对调两个数字
                int temp1 = source[left];
                source[left] = source[right];
                source[right] = temp1;
            }
        }
        //对调最左端的数字和中间相遇的数字
        source[high] = source[right];
        source[right] = temp;

        //递归左右两个数组，从right的位置分割开来
        quickSort(source, high, right - 1);
        quickSort(source, right + 1, low);
    }
}
