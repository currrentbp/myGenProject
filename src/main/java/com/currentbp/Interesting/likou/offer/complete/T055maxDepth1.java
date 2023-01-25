package com.currentbp.Interesting.likou.offer.complete;

import com.currentbp.common.entity.TreeNode;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 1/12/2023 9:27 PM
 */
public class T055maxDepth1 {
    /*
输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
     */

    @Test
    public void t1() {
        System.out.println(maxDepth(new TreeNode(0)));
    }


    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int max = doMax(root, 0);
        return max;
    }

    private int doMax(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        int currentDepth = depth + 1;
        return Math.max(doMax(root.left, currentDepth),
                doMax(root.right, currentDepth));
    }
}
