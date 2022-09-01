package com.currentbp.Interesting.likou.complete;

import com.currentbp.common.entity.TreeNode;
import com.currentbp.util.all.StringUtil;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baopan
 * @createTime 20220831
 */
public class T0095GenerateTrees {
    /*
    给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
示例 1：
输入：n = 3
输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
示例 2：
输入：n = 1
输出：[[1]]
提示：
1 <= n <= 8
     */
    @Test
    public void t1() {
        StringUtil.printObject(generateTrees(4));
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 1) {
            return Lists.newArrayList(new TreeNode(1));
        }
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> allTreeNodes = new ArrayList<>();
        if (start > end) {
            allTreeNodes.add(null);
            return allTreeNodes;
        }

        for (int i = start; i < end + 1; i++) {
            List<TreeNode> leftTreeNodes = generateTrees(start, i - 1);
            List<TreeNode> rightTreeNodes = generateTrees(i + 1, end);

            for (TreeNode leftTreeNode : leftTreeNodes) {
                for (TreeNode rightTreeNode : rightTreeNodes) {
                    TreeNode currentNode = new TreeNode(i);
                    currentNode.left = leftTreeNode;
                    currentNode.right = rightTreeNode;

                    allTreeNodes.add(currentNode);
                }
            }
        }

        return allTreeNodes;
    }
}
