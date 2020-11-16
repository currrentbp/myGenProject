package com.currentbp.Interesting.likou.complete;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author baopan
 * @createTime 20201116
 */
public class T0047permuteUnique {
    /*
给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
示例 1：
输入：nums = [1,1,2]
输出：
[[1,1,2],
 [1,2,1],
 [2,1,1]]
示例 2：
输入：nums = [1,2,3]
输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     */

    @Test
    public void t1() {
        StringUtil.printObject(permuteUnique(new int[]{1}));
//        StringUtil.printObject(permuteUnique(new int[]{1, 2, 1}));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return new ArrayList<>();
        }
        if (1 == nums.length) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> x = new ArrayList<>();
            x.add(nums[0]);
            result.add(x);
            return result;
        }
        List<List<Integer>> result = new ArrayList<>();
        boolean[] flag = new boolean[nums.length];
        doEach(nums, flag, result, new ArrayList<>(), new HashSet<>());
        return result;
    }

    private void doEach(int[] nums, boolean[] flag, List<List<Integer>> result,
                        List<Integer> current, Set<String> strings) {
        if (current.size() == nums.length) {
            String curs = toMyString(current);
            if (!strings.contains(curs)) {
                result.add(current);
                strings.add(curs);
            }
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!flag[i]) {
                flag[i] = true;
                List<Integer> newTemp = new ArrayList<>(current);
                newTemp.add(nums[i]);
                doEach(nums, flag, result, newTemp, strings);
                flag[i] = false;
            }
        }
    }

    private String toMyString(List<Integer> current) {
        StringBuffer result = new StringBuffer("");
        for (Integer integer : current) {
            result.append("_").append(integer);
        }
        return result.toString();
    }
}
