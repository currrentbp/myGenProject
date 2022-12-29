package com.currentbp.Interesting.likou.complete;

import com.currentbp.common.entity.TreeNode;

/**
 * @author baopan
 * @createTime 20221229
 */
public class T00226invertTree {
    /*
给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
示例 1：
输入：root = [4,2,7,1,3,6,9]
输出：[4,7,2,9,6,3,1]
示例 2：
输入：root = [2,1,3]
输出：[2,3,1]
示例 3：
输入：root = []
输出：[]

     */
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }

        trans(root);

        return root;
    }

    private void trans(TreeNode root) {
        if(root == null){
            return;
        }

        TreeNode left = root.left;

        root.left = root.right;
        root.right = left;

        trans(root.left);
        trans(root.right);
    }
}
