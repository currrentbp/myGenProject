package com.currentbp.Interesting.likou.complete;

import com.currentbp.common.entity.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * @author baopan
 * @createTime 2023/5/17 22:04
 */
public class T0105buildTree {
    /*
    给定两个整数数组preorder 和 inorder，其中preorder 是二叉树的先序遍历， inorder是同一棵树的中序遍历，请构造二叉树并返回其根节点。
示例 1:
输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
输出: [3,9,20,null,null,15,7]
示例 2:
输入: preorder = [-1], inorder = [-1]
输出: [-1]

二叉树前序遍历的顺序为：
    先遍历根节点；
    随后递归地遍历左子树；
    最后递归地遍历右子树。
二叉树中序遍历的顺序为：
    先递归地遍历左子树；
    随后遍历根节点；
    最后递归地遍历右子树。

解题思路：
对于任意一颗树而言，前序遍历的形式总是
[ 根节点, [左子树的前序遍历结果], [右子树的前序遍历结果] ]
即根节点总是前序遍历中的第一个节点。而中序遍历的形式总是
[ [左子树的中序遍历结果], 根节点, [右子树的中序遍历结果] ]

     */
    @Test
    public void t1(){
        buildTree(new int[]{-1},new int[]{-1}).print();
        buildTree(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7}).print();
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }

        TreeNode head = new TreeNode(preorder[0]);

        int[] leftInorder = getInorder(inorder, preorder[0], true);
        int[] rightInorder = getInorder(inorder, preorder[0], false);

        int[] leftPreorder = getPreorder(preorder, leftInorder);
        int[] rightPreorder = getPreorder(preorder, rightInorder);

        head.left = buildTree(leftPreorder, leftInorder);
        head.right = buildTree(rightPreorder, rightInorder);
        return head;
    }

    private int[] getPreorder(int[] preorder, int[] leftInorder) {
        Set<Integer> inorderSets = new HashSet<>();
        for (int i = 0; i < leftInorder.length; i++) {
            inorderSets.add(leftInorder[i]);
        }
        int[] result = new int[leftInorder.length];
        for (int i = 0, j = 0; i < preorder.length; i++) {
            if (inorderSets.contains(preorder[i])) {
                result[j++] = preorder[i];
            }
        }
        return result;
    }

    private int[] getInorder(int[] inorder, int rootValue, boolean isLeft) {
        List<Integer> lefts = new ArrayList<>();
        List<Integer> rights = new ArrayList<>();
        boolean flag = true;
        for (int i = 0; i < inorder.length; i++) {
            if (rootValue == inorder[i]) {
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
            for (int i = 0; i < result.length; i++) {
                result[i] = lefts.get(i);
            }
            return result;
        } else {
            int[] result = new int[rights.size()];
            for (int i = 0; i < result.length; i++) {
                result[i] = rights.get(i);
            }
            return result;
        }
    }

    /*
对于任意一颗树而言，前序遍历的形式总是
[ 根节点, [左子树的前序遍历结果], [右子树的前序遍历结果] ]即根节点总是前序遍历中的第一个节点。
而中序遍历的形式总是
[ [左子树的中序遍历结果], 根节点, [右子树的中序遍历结果] ]
  */

}
