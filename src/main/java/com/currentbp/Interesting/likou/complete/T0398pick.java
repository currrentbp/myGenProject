package com.currentbp.Interesting.likou.complete;

import org.junit.Test;

import java.util.*;

/**
 * @author baopan
 * @createTime 5/3/2023 9:57 PM
 */
public class T0398pick {
    /*
给你一个可能含有 重复元素 的整数数组nums ，请你随机输出给定的目标数字target 的索引。你可以假设给定的数字一定存在于数组中。
实现 Solution 类：
Solution(int[] nums) 用数组 nums 初始化对象。
int pick(int target) 从 nums 中选出一个满足 nums[i] == target 的随机索引 i 。如果存在多个有效的索引，则每个索引的返回概率应当相等。
示例：
输入
["Solution", "pick", "pick", "pick"]
[[[1, 2, 3, 3, 3]], [3], [1], [3]]
输出
[null, 4, 0, 2]
解释
Solution solution = new Solution([1, 2, 3, 3, 3]);
solution.pick(3); // 随机返回索引 2, 3 或者 4 之一。每个索引的返回概率应该相等。
solution.pick(1); // 返回 0 。因为只有 nums[0] 等于 1 。
solution.pick(3); // 随机返回索引 2, 3 或者 4 之一。每个索引的返回概率应该相等。

     */

    @Test
    public void t1(){
        System.out.println(new Random().nextInt(1));
        System.out.println(new Random().nextInt(1));
        System.out.println(new Random().nextInt(1));
        System.out.println(new Random().nextInt(1));
        System.out.println(new Random().nextInt(1));
    }


    class Solution {

        Map<Integer, List<Integer>> num2IndexsMap = new HashMap<>();

        public Solution(int[] nums) {
            if (nums == null || nums.length == 0) {
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                List<Integer> indexs = num2IndexsMap.getOrDefault(nums[i], new ArrayList<>());
                indexs.add(i);
                num2IndexsMap.put(nums[i], indexs);
            }
        }

        public int pick(int target) {
            List<Integer> indexs = num2IndexsMap.getOrDefault(target, new ArrayList<>());
            if (indexs.isEmpty()) {
                return -1;
            }
            return indexs.get(new Random().nextInt(indexs.size()));
        }
    }
}
