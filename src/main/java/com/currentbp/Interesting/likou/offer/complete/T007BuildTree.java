package com.currentbp.Interesting.likou.offer.complete;

import com.currentbp.common.entity.TreeNode;
import com.currentbp.util.all.StringUtil;
import org.apache.poi.ss.formula.functions.T;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author baopan
 * @createTime 20210629
 */
public class T007BuildTree {
    /*
输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
例如，给出
前序遍历 preorder =[3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：
    3
   / \
  9  20
    /  \
   15   7
先(根)序遍历（根左右）：A B D H E I C F J K G
中(根)序遍历（左根右） : D H B E I A J F K C G
                A
        ^               ^
        |               |
        B               C
    ^       ^       ^       ^
    |       |       |       |
    D       E       F       G
      ^       ^    ^  ^
      |       |    |   |
      H       I    J   K
解题思路：
1、根据前序直接找到顶点，然后根据顶点在中序中的位置，可以判定中序的左边都是左节点，中序的右边都是右节点，使用一个访问数组来标识是否已经访问过，用递归
     */

    @Test
    public void t1() {
        StringUtil.printObject(buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}));
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (null == preorder || 0 == preorder.length) {
            return null;
        }
        if (1 == preorder.length) {
            return new TreeNode(preorder[0]);
        }
        return doEach(preorder, inorder, 0, 0, preorder.length - 1);
    }


    private TreeNode doEach(int[] preorder, int[] inorder, int rootIndex, int start, int end) {
        TreeNode treeNode = new TreeNode(preorder[rootIndex]);
        int middle = findIndex(inorder, preorder[rootIndex]);
        //左边
        int leftNextIndex = findRootIndex(preorder, inorder, start, middle - 1);
        if (start != -1 && -1 != leftNextIndex && start <= middle) {
            treeNode.left = doEach(preorder, inorder, leftNextIndex, start, middle - 1);
        }
        //右边
        int rightNextIndex = findRootIndex(preorder, inorder, middle + 1, end);
        if (end != -1 && -1 != rightNextIndex && middle <= end) {
            treeNode.right = doEach(preorder, inorder, rightNextIndex, middle + 1, end);
        }
        return treeNode;
    }

    private int findRootIndex(int[] preorder, int[] inorder, int start, int end) {
        int result = -1;
        Set<Integer> remain = new HashSet<>();
        for (int i = start; i <= end; i++) {
            remain.add(inorder[i]);
        }
        for (int i = 0; i < preorder.length; i++) {
            if (remain.contains(preorder[i])) {
                result = i;
                break;
            }
        }
        return result;
    }

    private int findIndex(int[] inorder, int value) {
        for (int i = 0; i < inorder.length; i++) {
            if (value == inorder[i]) {
                return i;
            }
        }
        return -1;
    }
}
