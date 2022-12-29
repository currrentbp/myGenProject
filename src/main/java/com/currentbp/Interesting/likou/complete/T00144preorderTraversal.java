package com.currentbp.Interesting.likou.complete;

import com.currentbp.common.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baopan
 * @createTime 20221229
 */
public class T00144preorderTraversal {
    /*
给你二叉树的根节点 root ，返回它节点值的前序遍历。
示例 1：
输入：root = [1,null,2,3]
输出：[1,2,3]
示例 2：
输入：root = []
输出：[]
示例 3：
输入：root = [1]
输出：[1]
示例 4：
输入：root = [1,2]
输出：[1,2]
示例 5：
输入：root = [1,null,2]
输出：[1,2]

     */
    public List<Integer> preorderTraversal(TreeNode root) {
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
        result.add(root.val);
        getTree(root.left, result);
        getTree(root.right, result);
    }
}
