package com.currentbp.Interesting.likou.complete;

import org.junit.Test;

import java.util.*;

/**
 * @author baopan
 * @createTime 2020/7/20 10:57
 */
public class T00149 {
/*
给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
示例 1:
输入: [[1,1],[2,2],[3,3]]
输出: 3
解释:
|
|        o
|     o
|  o  
+------------->
0  1  2  3  4
示例 2:
输入: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
输出: 4
解释:
^
|
|  o
|     o        o
|       o
|  o          o
+------------------->
0  1   2  3  4  5  6

解题思路：
1、两个点确定一条直线，如果第三个点在这个线上，则表明：y=k*x + b
2、公式经过简化后得到：（x2-x1）*y - （y2-y1）*x = y1*x2 -y2*x1
3、该题还有一个思维障碍就是不能计算重复的线，使用一个二维数组表示是否已经访问过，
4、本题不考虑重复的点，这个观点和原题不符合
 */

    @Test
    public void t1() {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> table = new Hashtable<>();
        table.put(1, 2);
        int[][] points = new int[][]{{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};
        int i = maxPoints(points);
        System.out.println(i);
    }

    @Test
    public void t2() {
        int[][] points = new int[][]{{0, 0}, {1, 65536}, {65536, 0}};
        System.out.println(65536 * 65536);
        int i = maxPoints(points);
        System.out.println(i);
    }

    @Test
    public void t3() {
        int[][] points = new int[][]{{1, 1}, {0, 0}, {3, 4}, {4, 5}, {5, 6}, {7, 8}, {8, 9}};
        int i = maxPoints(points);
        System.out.println(i);
    }

    public int maxPoints(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        //排出相同的点
        points = removeTheSamePoint(points);

        if (points.length == 1) {
            return 1;
        }
        boolean[][] choose = new boolean[points.length][points.length];
        int max = 0;

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (needCalculation(choose, i, j)) {
                    int temp = getMaxPoints(points, choose, i, j);
                    max = Math.max(temp, max);
                }
            }
        }
        return max;
    }

    private int[][] removeTheSamePoint(int[][] points) {
        List<Integer[]> temp = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            if (temp.size() == 0) {
                temp.add(new Integer[]{points[i][0], points[i][1]});
                continue;
            }
            int x = points[i][0];
            int y = points[i][1];
            boolean needInsert = true;
            for (int j = 0; j < temp.size(); j++) {
                int x1 = temp.get(j)[0];
                int y1 = temp.get(j)[1];
                if (x == x1 && y == y1) {
                    needInsert = false;
                    break;
                }
            }
            if(needInsert){
                temp.add(new Integer[]{x, y});
            }
        }
        int[][] result = new int[temp.size()][2];
        for (int i = 0; i < temp.size(); i++) {
            result[i][0] = temp.get(i)[0];
            result[i][1] = temp.get(i)[1];
        }
        return result;
    }

    /**
     * 1、计算出这两个点上的所有点
     * 2、将已经在一条线上的标记出来
     */
    private int getMaxPoints(int[][] points, boolean[][] choose, int firstPoint, int secondPoint) {
        //解释：为啥使用long，因为乘的时候可能会发生越界
        int max = 0;
        //公式:（x2-x1）*y - （y2-y1）*x = y1*x2 -y2*x1
        long xRemain = points[secondPoint][0] - points[firstPoint][0];
        long yRemain = points[secondPoint][1] - points[firstPoint][1];
        long xyRemain = 1L * points[firstPoint][1] * points[secondPoint][0] - 1L * points[secondPoint][1] * points[firstPoint][0];

        int[] temp = new int[points.length];//默认有两个点已经在一条线上了
        temp[firstPoint] = 1;
        temp[secondPoint] = 1;


        for (int index = 0; index < points.length; index++) {//排出当前两个点外的计算
            if (index == firstPoint || index == secondPoint) {
                continue;
            }
            long remain = 1L * xRemain * points[index][1] - 1L * yRemain * points[index][0];
            if (remain == xyRemain) {
                temp[index] = 1;
            }
        }

        for (int i = 0; i < temp.length; i++) {
            max += temp[i];
        }

        //填充已经在一条直线的，包括点本身
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp.length; j++) {
                if (1 == temp[i] && 1 == temp[j]) {
                    choose[i][j] = true;
                    choose[j][i] = true;
                }
            }
        }
        return max;
    }

    /**
     * 判断这两个点是否需要计算，有些点在之前已经计算过了
     */
    private boolean needCalculation(boolean[][] choose, int firstPoint, int secondPoint) {
        boolean b = choose[firstPoint][secondPoint];
        return !b;
    }


}
