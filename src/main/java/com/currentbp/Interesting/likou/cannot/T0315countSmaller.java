package com.currentbp.Interesting.likou.cannot;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baopan
 * @createTime 5/6/2023 10:49 AM
 */
public class T0315countSmaller {
    /*
给你一个整数数组 nums ，按要求返回一个新数组counts 。数组 counts 有该性质： counts[i] 的值是 nums[i] 右侧小于nums[i] 的元素的数量。
示例 1：
输入：nums = [5,2,6,1]
输出：[2,1,1,0]
解释：
5 的右侧有 2 个更小的元素 (2 和 1)
2 的右侧仅有 1 个更小的元素 (1)
6 的右侧有 1 个更小的元素 (1)
1 的右侧有 0 个更小的元素
示例 2：
输入：nums = [-1]
输出：[0]
示例 3：
输入：nums = [-1,-1]
输出：[0,0]
解题思路：
1、暴力计算

     */

    @Test
    public void t1() {
        StringUtil.printObject(countSmaller1(new int[]{5, 2, 6, 1}));
        StringUtil.printObject(countSmaller1(new int[]{-1}));
        StringUtil.printObject(countSmaller1(new int[]{-1, -1}));
    }

    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        return result;
    }

    /*
    超时了
     */
    public List<Integer> countSmaller1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int size = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    size++;
                }
            }
            result.add(size);
        }

        return result;
    }
}
