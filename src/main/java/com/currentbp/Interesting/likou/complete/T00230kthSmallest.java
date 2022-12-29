package com.currentbp.Interesting.likou.complete;

import com.currentbp.common.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class T00230kthSmallest {
    /*
给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第k个最小元素（从 1 开始计数）。
示例 1：
输入：root = [3,1,4,null,2], k = 1
输出：1
示例 2：
输入：root = [5,3,6,2,4,null,null,1], k = 3
输出：3

     */
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        List<Integer> result = new ArrayList<>();
        getTree(root, result);
        return result.size() < k ? 0 : result.get(k-1);
    }

    private void getTree(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        getTree(root.left, result);
        System.out.println(root.val);
        result.add(root.val);
        getTree(root.right, result);
    }
}
