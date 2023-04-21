package com.currentbp.Interesting.likou.complete;

import com.currentbp.common.entity.TreeNode;
import org.assertj.core.util.Lists;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 20221228
 */
public class T0112hasPathSum {
    /*
给你二叉树的根节点root 和一个表示目标和的整数targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，
这条路径上所有节点值相加等于目标和targetSum 。如果存在，返回 true ；否则，返回 false 。
叶子节点 是指没有子节点的节点。
输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
输出：true
解释：等于目标和的根节点到叶节点路径如上图所示。
示例 2：
输入：root = [1,2,3], targetSum = 5
输出：false
解释：树中存在两条根节点到叶子节点的路径：
(1 --> 2): 和为 3
(1 --> 3): 和为 4
不存在 sum = 5 的根节点到叶子节点的路径。
示例 3：
输入：root = [], targetSum = 0
输出：false
解释：由于树是空的，所以不存在根节点到叶子节点的路径。
     */

    @Test
    public void t1() {
//        System.out.println(hasPathSum(new TreeNode(Lists.newArrayList(1, 2, 3)), 3));
//        System.out.println(hasPathSum(new TreeNode(Lists.newArrayList(1, 2)), 0));
        System.out.println(hasPathSum(new TreeNode(Lists.newArrayList(1, 2)), 1));
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.val == targetSum && root.left == null && root.right == null) {
            return true;
        }

        return hasPath(root, targetSum);
    }

    private boolean hasPath(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (targetSum == root.val && root.left == null && root.right == null) {
            return true;
        }

        return hasPath(root.left, targetSum - root.val) || hasPath(root.right, targetSum - root.val);
    }
}
