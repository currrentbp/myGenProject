package com.currentbp.Interesting.likou.complete;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baopan
 * @createTime 20201116
 */
public class T0046permute {
    /*
给定一个 没有重复 数字的序列，返回其所有可能的全排列。
示例:
输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
     */

    @Test
    public void t1() {
        StringUtil.printObject(permute(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] flag = new boolean[nums.length];
        doEach(nums, flag, result, new ArrayList<>());
        return result;
    }

    private void doEach(int[] nums, boolean[] flag, List<List<Integer>> result, List<Integer> current) {
        if(current.size() == nums.length){
            result.add(current);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(!flag[i]) {
                flag[i] = true;
                List<Integer> newTemp = new ArrayList<>(current);
                newTemp.add(nums[i]);
                doEach(nums, flag, result, newTemp);
                flag[i] = false;
            }
        }
    }


}
