package com.currentbp.Interesting.likou.cannot;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author baopan
 * @createTime 2023/4/28 21:42
 */
public class T0684findRedundantConnection {
    /*
树可以看成是一个连通且 无环的无向图。
给定往一棵n 个节点 (节点值1～n) 的树中添加一条边后的图。添加的边的两个顶点包含在 1 到 n中间，且这条附加的边不属于树中已存在的边。
图的信息记录于长度为 n 的二维数组 edges，edges[i] = [ai, bi]表示图中在 ai 和 bi 之间存在一条边。
请找出一条可以删去的边，删除后可使得剩余部分是一个有着 n 个节点的树。如果有多个答案，则返回数组edges中最后出现的边。
示例 1：
输入: edges = [[1,2], [1,3], [2,3]]
输出: [2,3]
示例 2：
输入: edges = [[1,2], [2,3], [3,4], [1,4], [1,5]]
输出: [1,4]
解题思路：
1、去掉一个路径就是说明这是一个图，去掉了才能形成树，也就是说出现了环，破除环
     */

    @Test
    public void t1() {
        StringUtil.printObject(findRedundantConnection(new int[][]{{1, 2}, {1, 3}, {2, 3}}));
        StringUtil.printObject(findRedundantConnection(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}}));
    }

    public int[] findRedundantConnection(int[][] edges) {
        if (edges == null || edges.length == 0) {
            return null;
        }

        Map<Integer, Set<Integer>> pointMap = getPointMap(edges);
        Set<Integer> circlePoints = getCirclePoints(pointMap, edges);
        if (circlePoints.isEmpty()) {
            return null;
        }
        for (int i = edges.length - 1; i >= 0; i--) {
            int[] edge = edges[i];
            if (circlePoints.contains(edge[0]) && circlePoints.contains(edge[1])) {
                return edge;
            }
        }
        return null;
    }

    private Set<Integer> getCirclePoints(Map<Integer, Set<Integer>> pointMap, int[][] edges) {
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            Set<Integer> temp = new HashSet<>();
            temp.add(edge[0]);
            temp.add(edge[1]);

            boolean isCircle = doCheckCircle(pointMap, edge, temp, Math.max(edge[0], edge[1]));
            if (isCircle) {
                return temp;
            }
        }
        return null;
    }

    private boolean doCheckCircle(Map<Integer, Set<Integer>> pointMap, int[] edge,
                                  Set<Integer> visited, Integer currentPoint) {
        visited.add(currentPoint);
        int min = Math.min(edge[0], edge[1]);
        Set<Integer> minSets = pointMap.getOrDefault(min, new HashSet<>());
        for (Integer minSet : minSets) {
            if (visited.contains(minSet) && currentPoint != edge[0] && currentPoint != edge[1]
                    && minSet != currentPoint) {
                return true;
            }
        }

        Set<Integer> nextPoints = pointMap.getOrDefault(currentPoint, new HashSet<>());
        for (Integer nextPoint : nextPoints) {
            if (doCheckCircle(pointMap, edge, visited, nextPoint)) {
                return true;
            } else {
                visited.remove(nextPoint);
            }
        }
        return false;
    }

    private Map<Integer, Set<Integer>> getPointMap(int[][] edges) {
        Map<Integer, Set<Integer>> result = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            //1->2这种指向
            if (edge[0] < edge[1]) {
                Set<Integer> set1 = result.getOrDefault(edge[0], new HashSet<>());
                set1.add(edge[1]);
                result.put(edge[0], set1);
            } else {
                Set<Integer> set2 = result.getOrDefault(edge[1], new HashSet<>());
                set2.add(edge[0]);
                result.put(edge[1], set2);
            }
        }
        return result;
    }


}
