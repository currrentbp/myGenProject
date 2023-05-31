package com.currentbp.Interesting.likou.complete;

import com.currentbp.common.entity.TreeNode;
import com.currentbp.util.all.StringUtil;
import org.assertj.core.util.Lists;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 2023/5/27 23:34
 */
public class T0404sumOfLeftLeaves {
    /*
给定二叉树的根节点root，返回所有左叶子之和。
示例 1：
输入: root = [3,9,20,null,null,15,7]
输出: 24
解释: 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
示例2:
输入: root = [1]
输出: 0
     */

    @Test
    public void t1() {
//        StringUtil.printObject(sumOfLeftLeaves(new TreeNode(Lists.newArrayList(3, 9, 20, null, null, 15, 7))));
//        /*
//    1
//  2   3
//4  5
//         */
//        StringUtil.printObject(sumOfLeftLeaves(new TreeNode(Lists.newArrayList(1,2,3,4,5))));
        StringUtil.printObject(sumOfLeftLeaves(new TreeNode(Lists.newArrayList(-9,-3,2,null,4,4,0,-6,null,-5))));
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null) {
            return sumOfLeftLeaves(root.right);
        }
        /*
   1
  2  3

  此处只判断root=1，的左节点
         */

        if (root.left.left == null && root.left.right == null) {
            return root.left.val + sumOfLeftLeaves(root.right);
        }

        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}
