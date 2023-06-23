package com.currentbp.Interesting.likou.complete;

import com.currentbp.common.entity.TreeNode;
import com.currentbp.util.all.StringUtil;
import org.assertj.core.util.Lists;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 2023-06-17 10:23:00
 */
public class T0437pathSum {
    /*
给定一个二叉树的根节点 root，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
示例 1：
输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
输出：3
解释：和等于 8 的路径有 3 条，如图所示。
示例 2：
输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
输出：3
case:[1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000],0
这个case一口问题，不作为我错误
     */

    @Test
    public void t1() {
//        StringUtil.printObject(pathSum(new TreeNode(Lists.newArrayList(10, 5, -3, 3, 2, null, 11, 3, -2, null, 1)), 8));
//        StringUtil.printObject(pathSum(new TreeNode(Lists.newArrayList(5,4,8,11,null,13,4,7,2,null,null,5,1)), 22));
        StringUtil.printObject(pathSum(new TreeNode(Lists.newArrayList(1,-2,-3,1,3,-2,null,-1)), -1));
        /*
        1
    -2    -3
   1  3 -2
 -1
         */
    }

    private int sum = 0;

    public int pathSum(TreeNode root, int targetSum) {
        doPathSum(root, targetSum);
        return sum;
    }

    private void doPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        doPathSum(root, targetSum, 0);

        doPathSum(root.left, targetSum);
        doPathSum(root.right, targetSum);
    }

    private void doPathSum(TreeNode root, int targetSum, int beforeValue) {
        if (root == null) {
            return;
        }
        int tempValue = root.val + beforeValue;
        if (tempValue == targetSum) {
            sum++;
        }
        doPathSum(root.left, targetSum, tempValue);
        doPathSum(root.right, targetSum, tempValue);
    }
}
