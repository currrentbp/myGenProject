package com.currentbp.Interesting.likou.complete;

import com.currentbp.common.entity.TreeNode;

/**
 * @author baopan
 * @createTime 20221229
 */
public class T00222countNodes {
    /*
给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，
并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~2h个节点。
示例 1
输入：root = [1,2,3,4,5,6]
输出：6
示例 2：
输入：root = []
输出：0
示例 3：
输入：root = [1]
输出：1

     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getCount(root);
    }

    private int getCount(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return getCount(node.left) + getCount(node.right) + 1;
    }
}
