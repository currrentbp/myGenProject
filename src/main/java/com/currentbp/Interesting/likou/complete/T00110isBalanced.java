package com.currentbp.Interesting.likou.complete;

import com.currentbp.common.entity.TreeNode;
import org.assertj.core.util.Lists;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 20221228
 */
public class T00110isBalanced {
/*
给定一个二叉树，判断它是否是高度平衡的二叉树。
本题中，一棵高度平衡二叉树定义为：
一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1 。
示例 1：
输入：root = [3,9,20,null,null,15,7]
输出：true
示例 2：
输入：root = [1,2,2,3,3,null,null,4,4]
输出：false
示例 3：
输入：root = []
输出：true

解题思路1：
1、遍历一个node的左右最大深度是否差值超过1，不超过，则继续遍历其左右子node
 */

    @Test
    public void t1() {
//        System.out.println(isBalanced(new TreeNode(Lists.newArrayList(3,9,20,null,null,15,7))));
        System.out.println(isBalanced(new TreeNode(Lists.newArrayList(1, 2, 3, 4, 5, 6, null, 8))));
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        return Math.abs(hight(root.left) - hight(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int hight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(hight(node.left), hight(node.right)) + 1;
    }
}
