package com.currentbp.Interesting.likou.complete;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author baopan
 * @createTime 20220921
 */
public class T00057Insert {
    /*
给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
示例1：
输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
输出：[[1,5],[6,9]]
示例 2：
输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
输出：[[1,2],[3,10],[12,16]]
解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10]重叠。
示例 3：
输入：intervals = [], newInterval = [5,7]
输出：[[5,7]]
示例 4：
输入：intervals = [[1,5]], newInterval = [2,3]
输出：[[1,5]]
示例 5：
输入：intervals = [[1,5]], newInterval = [2,7]
输出：[[1,7]]
提示
0 <= intervals.length <= 104
intervals[i].length == 2
0 <=intervals[i][0] <=intervals[i][1] <= 105
intervals 根据 intervals[i][0] 按 升序 排列
newInterval.length == 2
0 <=newInterval[0] <=newInterval[1] <= 105
     */

    @Test
    public void t1() {
        StringUtil.printObject(insert1(new int[][]{{1, 5}}, new int[]{2, 7}));
        StringUtil.printObject(insert1(new int[][]{{1, 5}}, new int[]{2, 3}));
        StringUtil.printObject(insert1(new int[][]{}, new int[]{5, 7}));
        StringUtil.printObject(insert1(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5}));
        StringUtil.printObject(insert1(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8}));
    }

    public int[][] insert1(int[][] intervals, int[] newInterval) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            for (int j = interval[0]; j <= interval[1]; j++) {
                set.add(j);
            }
        }
        for (int i = newInterval[0]; i <= newInterval[1]; i++) {
            set.add(i);
        }
        List<Integer> list = new ArrayList<>(set);
        List<Integer> collect = list.stream().sorted().collect(Collectors.toList());

        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < collect.size(); i++) {
            Integer left = collect.get(i);
            Integer right = left;
            for (int j = i + 1; j < collect.size(); j++) {
                int temp = collect.get(j);
                if (temp == right + 1) {
                    right = temp;
                    i = j;
                } else {
                    i = j - 1;
                    break;
                }
            }
            int[] temp1 = new int[]{left, right};
            result.add(temp1);
        }
        int[][] result2 = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            result2[i] = result.get(i);
        }
        return result2;
    }

}
