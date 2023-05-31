package com.currentbp.Interesting.likou.complete;

import com.currentbp.common.entity.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author baopan
 * @createTime 2023/5/28 16:59
 */
public class T0106buildTree {
    /*
给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗二叉树。
示例 1:
输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
输出：[3,9,20,null,null,15,7]
示例 2:
输入：inorder = [-1], postorder = [-1]
输出：[-1]

中序：[[左节点]根节点[右节点]]
后序：[[左节点][右节点]根节点]
     */

    @Test
    public void t1() {
        buildTree(new int[]{-1}, new int[]{-1}).print();
        buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3}).print();
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return null;
        }

        int[] leftInorder = getInorder(inorder, postorder[postorder.length - 1], true);
        int[] rightInorder = getInorder(inorder, postorder[postorder.length - 1], false);
        int[] leftPostorder = getPostorder(postorder, leftInorder);
        int[] rightPostorder = getPostorder(postorder, rightInorder);

        TreeNode head = new TreeNode(postorder[postorder.length - 1]);
        head.left = buildTree(leftInorder, leftPostorder);
        head.right = buildTree(rightInorder, rightPostorder);

        return head;
    }

    private int[] getPostorder(int[] postorder, int[] inorder) {
        Set<Integer> inorderSets = new HashSet<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderSets.add(inorder[i]);
        }
        int[] result = new int[inorder.length];
        for (int i = 0, j = 0; i < postorder.length; i++) {
            if (inorderSets.contains(postorder[i])) {
                result[j++] = postorder[i];
            }
        }
        return result;
    }

    private int[] getInorder(int[] inorder, int rootValue, boolean isLeft) {
        List<Integer> lefts = new ArrayList<>();
        List<Integer> rights = new ArrayList<>();
        boolean flag = true;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootValue) {
                flag = false;
                continue;
            }
            if (flag) {
                lefts.add(inorder[i]);
            } else {
                rights.add(inorder[i]);
            }
        }

        if (isLeft) {
            int[] result = new int[lefts.size()];
            for (int i = 0; i < lefts.size(); i++) {
                result[i] = lefts.get(i);
            }
            return result;
        } else {
            int[] result = new int[rights.size()];
            for (int i = 0; i < rights.size(); i++) {
                result[i] = rights.get(i);
            }
            return result;
        }
    }
}
