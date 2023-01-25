package com.currentbp.Interesting.likou.offer.complete;

/**
 * @author baopan
 * @createTime 1/12/2023 9:01 PM
 */
public class T040getLeastNumbers {
    /*
输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
示例 1：
输入：arr = [3,2,1], k = 2
输出：[1,2] 或者 [2,1]
示例 2：
输入：arr = [0,1,2,1], k = 1
输出：[0]
     */

    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return arr;
        }
        if (k == 0) {
            return new int[0];
        }
        if (k >= arr.length) {
            return arr;
        }
        sortIt(arr);
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    public int[] sortIt(int[] arr) {
        int left = 0, right = arr.length - 1;
        doSortIt(arr, left, right);

        return arr;
    }

    public void doSortIt(int[] source, int high, int low) {
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
        doSortIt(source, high, right - 1);
        doSortIt(source, right + 1, low);
    }
}
