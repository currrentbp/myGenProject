package com.currentbp.Interesting.likou.complete;

import com.currentbp.common.entity.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baopan
 * @createTime 2023/5/28 10:58
 */
public class T0095generateTrees2 {
    /*
给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
示例 1：
输入：n = 3
输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
示例 2：
输入：n = 1
输出：[[1]]
     */
    @Test
    public void t1() {
        generateTrees(3).stream().forEach(x->{x.print();});
    }

    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }

        return doGenerateTrees(1, n);
    }

    private List<TreeNode> doGenerateTrees(int leftIndex, int rightIndex) {
        if (leftIndex > rightIndex) {
            List<TreeNode> temp = new ArrayList<>();
            temp.add(null);
            return temp;
        }
        int start = leftIndex;
        List<TreeNode> result = new ArrayList<>();
        for (; start <= rightIndex; start++) {
            List<TreeNode> leftTreeNodes = doGenerateTrees(leftIndex, start - 1);
            List<TreeNode> rightTreeNodes = doGenerateTrees(start + 1, rightIndex);

            for (int i = 0; i < leftTreeNodes.size(); i++) {
                for (int j = 0; j < rightTreeNodes.size(); j++) {
                    TreeNode startNode = new TreeNode(start);
                    startNode.left = leftTreeNodes.get(i);
                    startNode.right = rightTreeNodes.get(j);
                    result.add(startNode);
                }
            }
        }


        return result;
    }
}
