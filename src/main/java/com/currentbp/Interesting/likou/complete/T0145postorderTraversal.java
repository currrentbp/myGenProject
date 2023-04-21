package com.currentbp.Interesting.likou.complete;

import com.currentbp.common.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baopan
 * @createTime 20221229
 */
public class T0145postorderTraversal {
    /*
给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
示例 1：
输入：root = [1,null,2,3]
输出：[3,2,1]
示例 2：
输入：root = []
输出：[]
示例 3：
输入：root = [1]
输出：[1]

     */

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        getTree(root, result);
        return result;
    }

    private void getTree(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        getTree(root.left, result);
        getTree(root.right, result);
        result.add(root.val);
    }
}
