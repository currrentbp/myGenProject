package com.currentbp.Interesting.likou.complete;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

import java.util.*;

/**
 * @author baopan
 * @createTime 2023/4/18 22:03
 */
public class T0310findMinHeightTrees {
    /*
树是一个无向图，其中任何两个顶点只通过一条路径连接。 换句话说，一个任何没有简单环路的连通图都是一棵树。
给你一棵包含 n 个节点的树，标记为 0 到 n - 1 。给定数字 n 和一个有 n - 1 条无向边的 edges 列表（每一个边都是一对标签），
其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条无向边。
可选择树中任何一个节点作为根。当选择节点 x 作为根节点时，设结果树的高度为 h 。在所有可能的树中，具有最小高度的树（即，min(h)）被称为 最小高度树 。
请你找到所有的 最小高度树 并按 任意顺序 返回它们的根节点标签列表。
树的 高度 是指根节点和叶子节点之间最长向下路径上边的数量。

解题思路：暴力解题：
1、将二维数组转换成map结构，结构如：key：node的值，value：list（node的值）
2、然后分别遍历所有的key判断树的深度
     */

    @Test
    public void t1() {
        StringUtil.printObject(findMinHeightTrees(4, new int[][]{{1, 0}, {1, 2}, {1, 3}}));
    }


    public int maxHigh = Integer.MAX_VALUE;
    public List<Integer> tops = new ArrayList<>();

    /**
     * 超时了
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (edges == null) {
            return new ArrayList<>();
        }
        if (edges.length == 0) {
            List<Integer> result = new ArrayList<>();
            result.add(0);
            return result;
        }
        Map<Integer, List<Integer>> map = doCreateMap(edges);

        for (Integer head : map.keySet()) {
            int high = doGetHigh(head, map);
            if (maxHigh == high) {
                tops.add(head);
            } else if (high < maxHigh) {
                tops = new ArrayList<>();
                tops.add(head);
                maxHigh = high;
            }
        }
        return tops;
    }

    private int doGetHigh(Integer head, Map<Integer, List<Integer>> map) {
        int result = 0;

        Set<Integer> treeflag = new HashSet<>();
        List<Integer> tops = new ArrayList<>();
        tops.add(head);
        treeflag.add(head);

        while (true) {
            if (tops.isEmpty()) {
                break;
            }
            result++;

            List<Integer> temp = new ArrayList<>();
            for (Integer top : tops) {
                //找出top这个节点的子节点
                List<Integer> nexts = map.getOrDefault(top, new ArrayList<>());
                for (Integer next : nexts) {
                    if (!treeflag.contains(next)) {
                        temp.add(next);
                        treeflag.add(next);
                    }
                }
            }
            tops = temp;
        }

        return result;
    }

    private Map<Integer, List<Integer>> doCreateMap(int[][] edges) {
        Map<Integer, List<Integer>> result = new HashMap<>();

        for (int[] edge : edges) {
            List<Integer> list0 = result.getOrDefault(edge[0], new ArrayList<>());
            if (!list0.contains(edge[1])) {
                list0.add(edge[1]);
                result.put(edge[0], list0);
            }
            List<Integer> list1 = result.getOrDefault(edge[1], new ArrayList<>());
            if (!list1.contains(edge[0])) {
                list1.add(edge[0]);
                result.put(edge[1], list1);
            }
        }

        return result;
    }
}
