package com.currentbp.Interesting.likou.complete;

import com.currentbp.util.all.ListUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author baopan
 * @createTime 20190202
 */
public class T0018 {
    /*
    给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。

注意：

答案中不可以包含重复的四元组。

示例：

给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。

满足要求的四元组集合为：
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
     */
    //https://leetcode-cn.com/problems/4sum/
    @Test
    public void t1() {
        fourSum(new int[]{-3, -2, -1, 0, 0, 1, 2, 3}, 0);
//        fourSum(new int[]{0, 0, 0, 0}, 0);
//        fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int first = 0; first < nums.length - 3; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            //将4和变为3和
            int newTarget = target - nums[first];
            //三和
            for (int second = first + 1; second < nums.length - 2; second++) {
                if (second - 1 > first && nums[second] == nums[second - 1]) {
                    continue;
                }
                int left = second + 1, right = nums.length - 1;
                while (left < right) {
                    int threeSum = nums[second] + nums[left] + nums[right];
                    if (newTarget == threeSum) {//is need ,and remove same's result
                        List<Integer> temp = new ArrayList<>(4);
                        temp.add(nums[first]);
                        temp.add(nums[second]);
                        temp.add(nums[left]);
                        temp.add(nums[right]);
                        result.add(temp);
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (newTarget < threeSum) {
                        right--;
                    } else if (newTarget > threeSum) {
                        left++;
                    }
                }
            }
        }
        return result;
    }

    /*
    官网最佳答案
     */
    public List<List<Integer>> fourSum1(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 4) return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            if (nums[i] * 4 > target) break;// Too Big!!太大了，后续只能更大，可以直接结束循环；
            if (nums[i] + 3 * nums[nums.length - 1] < target) continue;//Too Small！太小了，当前值不需要再算，可以继续循环尝试后面的值。

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                if (nums[j] * 3 > target - nums[i]) break;//Too Big！ 注意此时不能结束i的循环，因为j是移动的 当j移动到后面的时候继续i循环也sum可能变小
                if (nums[j] + 2 * nums[nums.length - 1] < target - nums[i]) continue;// Too Small

                int begin = j + 1;
                int end = nums.length - 1;
                while (begin < end) {
                    int sum = nums[i] + nums[j] + nums[begin] + nums[end];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[begin], nums[end]));
                        while (begin < end && nums[begin] == nums[begin + 1]) {
                            begin++;
                        }
                        while (begin < end && nums[end] == nums[end - 1]) {
                            end--;
                        }
                        begin++;
                        end--;
                    } else if (sum < target) {
                        begin++;
                    } else {
                        end--;
                    }
                }
            }
        }
        return res;
    }
}