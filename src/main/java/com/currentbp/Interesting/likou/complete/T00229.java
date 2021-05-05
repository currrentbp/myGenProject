package com.currentbp.Interesting.likou.complete;

import org.junit.Test;

import java.util.*;

public class T00229 {
    /**
     * 给定一个大小为n的整数数组，找出其中所有出现超过 n/3 ⌋次的元素。
     * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。
     * 输入：[3,2,3]
     * 输出：[3]
     * 示例 2：
     * 输入：nums = [1]
     * 输出：[1]
     * 示例 3：
     * 输入：[1,1,1,3,3,2,2,2]
     * 输出：[1,2]
     * 提示：
     * 1 <= nums.length <= 5 * 104
     * -109 <= nums[i] <= 109
     */

    @Test
    public void t1() {

    }

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (null == nums || 0 == nums.length) {
            return result;
        }

        int times = nums.length / 3;
        Map<Integer, Integer> num2Count = new HashMap<>();
        Set<Integer> keys = new HashSet<>();
        for (int num : nums) {
            Integer count = num2Count.getOrDefault(num, 0);
            num2Count.put(num, count + 1);
            if (count + 1 > times) {
                keys.add(num);
            }
        }
        result.addAll(keys);
        return result;
    }
}
