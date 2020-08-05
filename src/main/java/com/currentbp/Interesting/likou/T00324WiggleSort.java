package com.currentbp.Interesting.likou;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 2020/8/4 17:54
 */
public class T00324WiggleSort {

    /*
给定一个无序的数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
示例 1:
输入: nums = [1, 5, 1, 1, 6, 4]
输出: 一个可能的答案是 [1, 4, 1, 5, 1, 6]
示例 2:
输入: nums = [1, 3, 2, 2, 3, 1]
输出: 一个可能的答案是 [2, 3, 1, 3, 1, 2]
说明:
你可以假设所有输入都会得到有效的结果。
进阶:
你能用 O(n) 时间复杂度和 / 或原地 O(1) 额外空间来实现吗？


todo not work
解题思路：
1、全部排序，然后按照小大小大的顺序排队，所有小的数是从小到大，所有大的数也是从小到大，这种策略错误（例如：4,5,5,6）
2、比较第i个数（i是偶数，从0开始）比第i+1小，第i+1大于第i+2，如果不符，则直接
     */

    @Test
    public void t1() {
        wiggleSort(new int[]{1, 5, 1, 1, 6, 4});
        wiggleSort(new int[]{1, 3, 2, 2, 3, 1});
        wiggleSort(new int[]{1, 5, 1, 1, 6, 4});
        wiggleSort(new int[]{1, 1, 2, 1, 2, 2, 1});
        wiggleSort(new int[]{4, 5, 5, 6});
    }

    public void wiggleSort(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return;
        }
        boolean flag = true;//true：小于，false：大于
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 >= nums.length) {
                continue;
            }
            if (flag) {//需要当前数字比下一个数字小
                if (nums[i] < nums[i + 1]) {
                    continue;
                } else {
                    needChange(nums, i, flag);
                }
                flag = !flag;
            } else {
                if (nums[i] > nums[i + 1]) {
                    continue;
                } else {
                    needChange(nums, i, flag);
                }
                flag = !flag;
            }

        }
        StringUtil.printObject(nums);
    }

    private void needChange(int[] nums, int index, boolean flag) {
    }

    public void wiggleSort2(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return;
        }
        sort(nums);

        boolean flag = nums.length % 2 == 0;//是否是偶数
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int index = i * 2;
            if (index < nums.length) {
                result[index] = nums[i];
            } else {
                if(flag) {
                    result[index - nums.length + 1] = nums[i];
                }else{
                    result[index - nums.length] = nums[i];
                }
            }
        }
        System.arraycopy(result, 0, nums, 0, result.length);
    }

    private void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
}


