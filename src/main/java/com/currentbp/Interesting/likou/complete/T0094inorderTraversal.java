package com.currentbp.Interesting.likou.complete;

import com.currentbp.common.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baopan
 * @createTime 2020/9/14 12:21
 */
public class T0094inorderTraversal {
    /*
给定一个二叉树，返回它的中序 遍历。
示例:
输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,3,2]
     */

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (null == root) {
            return result;
        }
        doInOrder(root, result);
        return result;
    }

    private void doInOrder(TreeNode currentNode, List<Integer> result) {
        if (null == currentNode) {
            return;
        }
        doInOrder(currentNode.left, result);
        result.add(currentNode.val);
        doInOrder(currentNode.right, result);
    }
}
