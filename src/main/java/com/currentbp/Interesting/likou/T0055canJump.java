package com.currentbp.Interesting.likou;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baopan
 * @createTime 20201124
 */
public class T0055canJump {
    /*
给定一个非负整数数组，你最初位于数组的第一个位置。
数组中的每个元素代表你在该位置可以跳跃的最大长度。
判断你是否能够到达最后一个位置。
示例1:
输入: [2,3,1,1,4]
输出: true
解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
示例2:
输入: [3,2,1,0,4]
输出: false
解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
解题思路：
1、将0比作河，不是0的都是孤岛，
2、河为负数，孤岛需要渡河能最大走几步，如果两个和为小于等于0的话，则跳不过
3、寻找最后一个陆地0的可达地点，如果寻找不到地方，则认为不可达
     */

    @Test
    public void t1() {

//        StringUtil.printObject(canJump(new int[]{2, 0, 0, 0, 2, 0, 0, 0}));
//        StringUtil.printObject(canJump(new int[]{3, 0, 8, 2, 0, 0, 1}));
//        StringUtil.printObject(canJump(new int[]{2, 5, 0, 0}));
        StringUtil.printObject(canJump(new int[]{2, 3, 1, 1, 4}));
//        StringUtil.printObject(canJump(new int[]{3, 2, 1, 0, 4}));
    }

    public boolean canJump(int[] nums) {
        if (null == nums || nums.length <= 1) {
            return true;
        }

        List<List<Integer>> temp = getRiverAndIsland(nums);
        List<Integer> costAndSelfLength = getCostAndSelfLength(temp);

        return cal(costAndSelfLength);
    }

    public boolean cal(List<Integer> nums) {
        if (null == nums || nums.size() <= 0) {
            return true;
        }
        if (nums.size() == 1) {
            return nums.get(0) > 0;
        }
        return doCanJump(nums, 0);
    }

    private boolean doCanJump(List<Integer> nums, int currentIndex) {
        if (nums.size() <= currentIndex) {
            return true;
        }

        for (int nextIndex = currentIndex + 1; nextIndex <= nums.size(); nextIndex++) {
            if (nextIndex == nums.size()) {
                return true;
            }
            if (nums.get(nextIndex) < 0) {
                int allCost = getAllCost(nums, currentIndex, nextIndex);
                if (nums.get(currentIndex) + allCost < 0) {//不能继续前进了
                    break;
                }
            }
            if (nums.get(nextIndex) > 0) {//只有是陆地才能向下一个地方跳
                boolean temp = doCanJump(nums, nextIndex);
                if (temp) {
                    return true;
                }
            }
        }
        return false;
    }

    private int getAllCost(List<Integer> nums, int currentIndex, int nextIndex) {
        if (currentIndex == nextIndex) {
            return 0;
        }
        int result = 0;
        for (int i = currentIndex + 1; i <= nextIndex; i++) {
            result += getCost(nums.get(i));
        }
        return result;
    }

    private int getCost(int x) {
        return x >= 0 ? -x : x;
    }

    private List<Integer> getCostAndSelfLength(List<List<Integer>> temp) {
        List<Integer> result = new ArrayList<>();
        temp.forEach(x -> {
            int size = x.size();
            if (x.get(0) == 0) {
                result.add(size * -1);
            } else {
                int maxArrive = x.get(0) - size + 1;
                for (int i = 0; i < x.size(); i++) {
                    maxArrive = Math.max(maxArrive, x.get(i) - size + 1 + i);
                }
                result.add(maxArrive);
            }
        });
        return result;
    }

    /**
     * 获取河流和岛屿的结构体
     */
    private List<List<Integer>> getRiverAndIsland(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean isRiver = nums[0] == 0;//是否是河流
        for (int i = 0; i < nums.length; i++) {
            if (isRiver ^ nums[i] == 0) {//true ^ false, false^true
                if (0 != temp.size()) {
                    result.add(temp);
                }
                temp = new ArrayList<>();
                isRiver = nums[i] == 0;
            }
            temp.add(nums[i]);
        }
        if (0 != temp.size()) {
            result.add(temp);
        }
        return result;
    }


    /*
    我的第一版方案
     */
    public boolean canJump2(int[] nums) {
        if (null == nums || nums.length <= 1) {
            return true;
        }
        return doEach2(nums, 0);
    }

    private boolean doEach2(int[] nums, int currentIndex) {
        if (currentIndex >= nums.length - 1) {
            return true;
        }
        if (nums[currentIndex] == 0) {
            return false;
        }

        for (int useStep = nums[currentIndex]; useStep > 0; useStep--) {
            boolean result = doEach2(nums, currentIndex + useStep);
            if (result) {
                return true;
            }
        }
        return false;
    }


}
