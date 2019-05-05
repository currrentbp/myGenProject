package com.currentbp.Interesting.likou;


import com.currentbp.common.entity.Student;
import com.currentbp.util.all.ListUtil;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.*;

/**
 * @author baopan
 * @createTime 2019/4/6 9:34
 */
public class T00031 {
    /*
    实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

必须原地修改，只允许使用额外常数空间。

以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
1,3,2 → 2,1,3
1,2,3 → 1,3,2
3,2,1 → 1,2,3
2,3,1 → 3,1,2
1,1,5 → 1,5,1
     */

    @Test
    public void t2() {
        for (int i = -1; i >= 0; i--) {
            System.out.println("=======");
        }
    }

    @Test
    public void t1() {
        int[] nums6 = new int[]{1, 3, 2};
        nextPermutation(nums6);
        ListUtil.printList(nums6);
//        int[] nums5 = new int[]{4, 2, 0, 2, 3, 2, 0};
//        nextPermutation(nums5);
//        ListUtil.printList(nums5);
//        int[] nums4 = new int[]{1, 3, 2};
//        nextPermutation(nums4);
//        ListUtil.printList(nums4);
//        int[] nums1 = new int[]{1, 2, 3};
//        nextPermutation(nums1);
//        ListUtil.printList(nums1);
//        int[] nums2 = new int[]{3, 2, 1};
//        nextPermutation(nums2);
//        ListUtil.printList(nums2);
//        int[] nums3 = new int[]{1, 1, 5};
//        nextPermutation(nums3);
//        ListUtil.printList(nums3);
    }

    public void nextPermutation(int[] nums) {
        if (null == nums || nums.length <= 1) {
            return;
        }

        int start = -1;
        boolean flag = false;
        for (int right = nums.length - 1; right >= 0; right--) {
            if (flag) {
                break;
            }
            if (right - 1 >= 0 && nums[right - 1] < nums[right]) {
                flag = true;
                start = right - 1;
            }
        }
        if (!flag) {
            swapEach(nums);
        } else {
            int index = start + 1;
            for (int middle = start + 1; middle < nums.length; middle++) {
                if (nums[start] < nums[middle] && nums[middle] < nums[index]) {
                    index = middle;
                }
            }
            swap(nums, start, index);
            ascSort(nums, start + 1);
        }
    }

    private void ascSort(int[] nums, int start) {
        for (int i = start; i < nums.length; i++) {
            int minIndex = i;
            int tempMin = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < tempMin) {
                    minIndex = j;
                    tempMin = nums[j];
                }
            }
            swap(nums, i, minIndex);
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    private void swapEach(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
