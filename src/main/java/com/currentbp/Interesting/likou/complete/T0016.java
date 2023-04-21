package com.currentbp.Interesting.likou.complete;

import com.currentbp.util.all.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author baopan
 * @createTime 20190116
 */
public class T0016 {
    /*
    给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.

与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
     */
    //https://leetcode-cn.com/problems/3sum-closest/

    @Test
    public void t1() {
        Assert.isTrue(threeSumClosest(new int[]{-1, 2, 1, -4}, 1) == 2, "error");
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);//排序的目的是为了计算值的大小问题
        int closeResult = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (target == closeResult) {
                    return closeResult;
                }
                int threeSum = nums[i] + nums[left] + nums[right];
                if (Math.abs(target - closeResult) > Math.abs(target - (threeSum))) {
                    closeResult = threeSum;
                }
                if (threeSum > target) {
                    right--;
                } else if (threeSum < target) {
                    left++;
                } else {
                    return threeSum;
                }

            }
        }
        return closeResult;
    }
}
