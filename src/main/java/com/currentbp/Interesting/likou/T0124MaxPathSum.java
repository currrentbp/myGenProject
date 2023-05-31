package com.currentbp.Interesting.likou;

import com.currentbp.common.entity.TreeNode;
import org.assertj.core.util.Lists;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 20220907
 */
public class T0124MaxPathSum {

    /*
路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
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
解析：    todo 暂时不会
     */
    @Test
    public void t1(){
        TreeNode treeNode = new TreeNode(Lists.newArrayList(-10, 9, 20, null, null, 15, 7));

        System.out.println(maxPathSum(treeNode));
//        treeNode.print();
        TreeNode treeNode2 = new TreeNode(Lists.newArrayList(3,
                9, 20,
                null, 311, 1511, 7,
                1,2,null,10, 12,null,
                null,null,3,55,66,77,13,null));
        treeNode2.print();
    }

    public int maxPathSum(TreeNode root) {

        return 0;
    }
}
