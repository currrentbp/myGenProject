package com.currentbp.Interesting.likou.complete;

import com.currentbp.common.entity.TreeNode;
import org.assertj.core.util.Lists;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 20221228
 */
public class T0111minDepth {
    /*
给定一个二叉树，找出其最小深度。
最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
说明：叶子节点是指没有子节点的节点。

解题思路1：
1、遍历所有节点，判断是否是叶子节点，是叶子节点，则返回深度，汇总所有深度判断最小的
     */
    @Test
    public void t1() {
        System.out.println(minDepth(new TreeNode(Lists.newArrayList(2, null, 3, null, 4, null, 5, null, 6))));
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return getDepth(root);
    }

    private int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        if (node.left == null) {
            return getDepth(node.right) + 1;
        }
        if (node.right == null) {
            return getDepth(node.left) + 1;
        }

        return Math.min(getDepth(node.left), getDepth(node.right)) + 1;
    }
}
