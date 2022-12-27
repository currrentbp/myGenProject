package com.currentbp.Interesting.likou.complete;

import com.currentbp.common.entity.TreeNode;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baopan
 * @createTime 20220923
 */
public class T0098isValidBST {
    /*
给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
有效 二叉搜索树定义如下：
节点的左子树只包含 小于 当前节点的数。
节点的右子树只包含 大于 当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。
     */

    @Test
    public void t1() {
        System.out.println(isValidBST(new TreeNode(Lists.newArrayList(5,4,6,null,null,3,7))));
//        System.out.println(isValidBST(new TreeNode(Lists.newArrayList(2, 1, 3))));
//        System.out.println(isValidBST(new TreeNode(Lists.newArrayList(5, 1, 4, null, null, 3, 6))));
    }


    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
//        root.print();
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }
}
