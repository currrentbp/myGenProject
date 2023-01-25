package com.currentbp.Interesting.likou.offer;

import com.currentbp.common.entity.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author baopan
 * @createTime 1/19/2023 9:10 AM
 */
public class T007buildTree {
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
