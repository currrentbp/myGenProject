package com.currentbp.Interesting.likou.complete;

import com.currentbp.common.entity.TreeNode;
import org.assertj.core.util.Lists;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 20220907
 */
public class T0124MaxPathSum {

    /*
路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。
该路径 至少包含一个 节点，且不一定经过根节点。
路径和 是路径中各节点值的总和。
给你一个二叉树的根节点 root ，返回其 最大路径和 。
示例 1：
    1
  2   3
输入：root = [1,2,3]
输出：6
解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
示例 2：
        -10
      9     20
           15  7
输入：root = [-10,9,20,null,null,15,7]
输出：42
解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
提示：
树中节点数目范围是 [1, 3 * 104]
-1000 <= Node.val <= 1000
     */
    /*
解题思路：
1、只需要直到最大值，不是路径。用一个值记录最大值，
1.1、分别递归计算左右节点的最大值，然后给出当前节点的全路径的最大值判断是否是最大值
1.2、给出当前节点的最大贡献路径，只能从左右分支中选一个
     */
    @Test
    public void t1() {
        TreeNode treeNode = new TreeNode(Lists.newArrayList(-10, 9, 20, null, null, 15, 7));

        System.out.println(maxPathSum(treeNode));
//        treeNode.print();
        TreeNode treeNode2 = new TreeNode(Lists.newArrayList(3,
                9, 20,
                null, 311, 1511, 7,
                1, 2, null, 10, 12, null,
                null, null, 3, 55, 66, 77, 13, null));
        treeNode2.print();
    }

    Integer maxValue = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        getMax(root);
        return maxValue;
    }

    private int getMax(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMax = Math.max(getMax(root.left), 0);
        int rightMax = Math.max(getMax(root.right), 0);

        int currentMax = root.val + leftMax + rightMax;
        maxValue = Math.max(maxValue, currentMax);
        // 返回节点的最大贡献值
        return root.val + Math.max(leftMax, rightMax);
    }
}
