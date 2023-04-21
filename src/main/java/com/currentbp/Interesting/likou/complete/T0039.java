package com.currentbp.Interesting.likou.complete;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baopan
 * @createTime 2019/11/17 16:52
 */
public class T0039 {
    /*
     给定一个无重复元素的数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
candidates中的数字可以无限制重复被选取。
说明：
所有数字（包括target）都是正整数。
解集不能包含重复的组合。
示例1:

输入: candidates = [2,3,6,7], target = 7,
所求解集为:
[
  [7],
  [2,2,3]
]
示例2:
输入: candidates = [2,3,5], target = 8,
所求解集为:
[
 [2,2,2,2],
 [2,3,3],
 [3,5]
]
     */
    @Test
    public void t1() {
        StringUtil.printObject(combinationSum(new int[]{2, 3, 5}, 8));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int currentSum = 0;
        getCombinationSum(candidates, target, currentSum, 0, result, new ArrayList<>());
        return result;
    }

    private void getCombinationSum(int[] candidates, int target, int currentSum, int startIndex,
                                   List<List<Integer>> result, List<Integer> before) {
        if (target == currentSum) {
            result.add(before);
        }
        if (target < currentSum) {
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            List<Integer> temp = new ArrayList<>(before);
            temp.add(candidates[i]);
            getCombinationSum(candidates, target, currentSum + candidates[i],i, result, temp);
        }
    }

}
