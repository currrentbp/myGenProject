package com.currentbp.Interesting.likou.complete;

import com.currentbp.common.entity.TreeNode;

/**
 * @author baopan
 * @createTime 20221227
 */
public class T0104maxDepth {
    /*
给定一个二叉树，找出其最大深度。
二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
说明: 叶子节点是指没有子节点的节点。
     */

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(maxDepth(root.left, 1), maxDepth(root.right, 1));
    }

    private int maxDepth(TreeNode root, int level) {
        if (null == root) {
            return level;
        }
        return Math.max(maxDepth(root.left, level + 1), maxDepth(root.right, level + 1));
    }
}
