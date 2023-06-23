package com.currentbp.Interesting.likou.complete;

import com.currentbp.common.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baopan
 * @createTime 2023-06-17 10:05:24
 */
public class T0513findBottomLeftValue {
    /*
给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
假设二叉树中至少有一个节点。
示例 1:
输入: root = [2,1,3]
输出: 1
示例 2:
输入: [1,2,3,4,null,5,6,null,null,7]
输出: 7
解题思路：
1、将树遍历成层序，然后获取最后一个列表的第一个元素就是左节点
     */


    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return -1;
        }

        List<List<TreeNode>> result = new ArrayList<>();
        List<TreeNode> level = new ArrayList<>();
        level.add(root);
        result.add(level);
        List<TreeNode> temp = new ArrayList<>();

        while (!level.isEmpty()) {
            temp = getNext(level);
            if (!temp.isEmpty()) {
                result.add(temp);
                level = temp;
            } else {
                break;
            }
        }


        return result.get(result.size() - 1).get(0).val;
    }

    private List<TreeNode> getNext(List<TreeNode> level) {
        if (level.isEmpty()) {
            return new ArrayList<>();
        }
        List<TreeNode> result = new ArrayList<>();
        for (int i = 0; i < level.size(); i++) {
            TreeNode currentNode = level.get(i);
            if (currentNode.left != null) {
                result.add(currentNode.left);
            }
            if (currentNode.right != null) {
                result.add(currentNode.right);
            }
        }
        return result;
    }
}
