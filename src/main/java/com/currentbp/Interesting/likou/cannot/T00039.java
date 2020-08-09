package com.currentbp.Interesting.likou.cannot;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baopan
 * @createTime 2019/11/17 16:52
 */
public class T00039 {
    /*
     给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的数字可以无限制重复被选取。

说明：

所有数字（包括 target）都是正整数。
解集不能包含重复的组合。 
示例 1:

输入: candidates = [2,3,6,7], target = 7,
所求解集为:
[
  [7],
  [2,2,3]
]
示例 2:

输入: candidates = [2,3,5], target = 8,
所求解集为:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int index = candidates.length;
        getCombinationSum(candidates,target,index,result);
        return result;
    }

    private void getCombinationSum(int[] candidates, int target, int index, List<List<Integer>> result) {
        while(true) {
            if (index>=0) {
                getSonCombinationSum(candidates, target, index, result);
                index--;
            }else{
                break;
            }
        }
    }

    private void getSonCombinationSum(int[] candidates, int target, int index, List<List<Integer>> result) {

    }
}
