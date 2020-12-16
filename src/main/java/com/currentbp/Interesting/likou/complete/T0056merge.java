package com.currentbp.Interesting.likou.complete;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author baopan
 * @createTime 20201216
 */
public class T0056merge {
    /*
    给出一个区间的集合，请合并所有重叠的区间。
示例 1:
输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例2:
输入: intervals = [[1,4],[4,5]]
输出: [[1,5]]
解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
     */

    @Test
    public void t1() {
        StringUtil.printObject(merge(new int[][]{{1,3},{2,6},{8,10},{15,18}}));
    }

    public int[][] merge(int[][] intervals) {
        if (null == intervals || 0 == intervals.length) {
            return intervals;
        }
        List<int[]> result = new ArrayList<>(intervals.length);
        init(result, intervals);//排序后的列表
        for (int i = 0; i < result.size(); i++) {
            while (true) {
                if (needMerge(result, i, i + 1)) {
                    doMerge(result, i);
                } else {
                    break;
                }
            }
        }

        return finish(result);
    }

    private int[][] finish(List<int[]> result) {
        int[][] temp = new int[result.size()][2];
        for(int i=0;i<result.size();i++){
            temp[i] = result.get(i);
        }
        return temp;
    }

    private void doMerge(List<int[]> result, int currentIndex) {
        int[] current = result.get(currentIndex);
        int[] next = result.get(currentIndex + 1);
        int[] temp = new int[]{current[0], Math.max(current[1], next[1])};
        result.remove(currentIndex);
        result.add(currentIndex,temp);
        result.remove(currentIndex+1);
    }

    private boolean needMerge(List<int[]> result, int index, int next) {
        if (next >= result.size()) {
            return false;
        }
        return result.get(index)[1] >= result.get(next)[0];
    }

    private void init(List<int[]> result, int[][] intervals) {
        result.addAll(Arrays.asList(intervals));
        result.sort(Comparator.comparingInt(x -> x[0]));
    }
}
