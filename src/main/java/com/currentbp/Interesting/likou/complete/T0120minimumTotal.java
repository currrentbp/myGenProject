package com.currentbp.Interesting.likou.complete;

import com.currentbp.util.all.ListUtil;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baopan
 * @createTime 2024/6/15 20:27
 */
public class T0120minimumTotal {
    /*
给定一个三角形 triangle ，找出自顶向下的最小路径和。
每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
示例 1：
输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
输出：11
解释：如下面简图所示：
   2
  3 4
 6 5 7
4 1 8 3
自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
示例 2：
输入：triangle = [[-10]]
输出：-10
     */
    /*
    解题思路：
    1、动态规划？
    1.1、min(n,i) = MIN(min(n-1,i-1)+ f(n,i), min(n-1,i)+ f(n,i))   其中n为第n层，i为第i个数字

    解题思路2：
    1、构建一个新的杨辉三角
    2、杨辉三角每个位置都是一个数组[leftValue,rightValue]
    2.1、f(n,i) = 
    3、最后只需要计算最后一层的每个元素的最小值就行
     */

    @Test
    public void t1() {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Lists.newArrayList(2));
        triangle.add(Lists.newArrayList(3, 4));
        triangle.add(Lists.newArrayList(6, 5, 7));
        triangle.add(Lists.newArrayList(4, 1, 8, 3));
        ListUtil.printTri(triangle);
        System.out.println(minimumTotal(triangle));
    }

    @Test
    public void t2() {
        int[][] temp = new int[][]{{-7}, {-2, 1}, {-5, -5, 9}, {-4, -5, 4, 4}, {-6, -6, 2, -1, -5}, {3, 7, 8, -3, 7, -9}, {-9, -1, -9, 6, 9, 0, 7}, {-7, 0, -6, -8, 7, 1, -4, 9}, {-3, 2, -6, -9, -7, -6, -9, 4, 0}, {-8, -6, -3, -9, -2, -6, 7, -5, 0, 7}, {-9, -1, -2, 4, -2, 4, 4, -1, 2, -5, 5}, {1, 1, -6, 1, -2, -4, 4, -2, 6, -6, 0, 6}, {-3, -3, -6, -2, -6, -2, 7, -9, -5, -7, -5, 5, 1}};
        List<List<Integer>> lists = ListUtil.arrays2Lists(temp);
        ListUtil.printTri1(lists);
        System.out.println(minimumTotal(lists));
    }


    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int minValue = Integer.MAX_VALUE;
        //构建所有数据
        List<List<Integer>> newTriangle = buildNewTriangle(triangle);
        ListUtil.printTri(newTriangle);

        int level = newTriangle.size() - 1;//最底层
        List<Integer> lowLevels = newTriangle.get(level);
        for (int i = 0; i < lowLevels.size(); i++) {//最底层的每个元素都要遍历
            // 每个元素遍历，最多两个元素
            minValue = Math.min(minValue, lowLevels.get(i));
        }

        return minValue;
    }

    /**
     * 构建所有数据的和
     */
    private List<List<Integer>> buildNewTriangle(List<List<Integer>> triangle) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> zeroLevels = new ArrayList<>();//第零层的构建
        zeroLevels.add(triangle.get(0).get(0));
        result.add(zeroLevels);
        for (int level = 1; level < triangle.size(); level++) {//层数，从第一层开始
            List<Integer> indexList = triangle.get(level);
            for (int index = 0; index < indexList.size(); index++) {//每层的元素遍历
                buildSmallList(triangle, level, index, result);//构建一层的index位置
            }
        }
        return result;
    }

    private void buildSmallList(List<List<Integer>> triangle, int level, int index,
                                List<List<Integer>> newTriangle) {
        int topLevel = level - 1;//上层数
        List<Integer> topLevels = newTriangle.get(topLevel);//上一层的数据
        Integer current = triangle.get(level).get(index);//当前值
        if (index == 0) {//最左侧
            List<Integer> temp = new ArrayList<>();
            Integer lefts = topLevels.get(0);
            temp.add(lefts + current);
            newTriangle.add(temp);
            return;
        }

        List<Integer> currentLists = newTriangle.get(newTriangle.size() - 1);//当前层

        if (index == topLevels.size()) {//最右侧
            Integer rights = topLevels.get(index - 1);
            currentLists.add(rights + current);
            return;
        }

        //在中间的都有2个值
        int topLeftIndex = index - 1;
        int topRightIndex = index;
        Integer topLefts = topLevels.get(topLeftIndex);
        Integer topRights = topLevels.get(topRightIndex);
        int minValue = Math.min(topLefts + current, topRights + current);
        currentLists.add(minValue);

        return;
    }


}
