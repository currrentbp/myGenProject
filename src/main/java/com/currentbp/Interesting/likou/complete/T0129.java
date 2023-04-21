package com.currentbp.Interesting.likou.complete;

import com.currentbp.common.entity.TreeNode;
import com.currentbp.util.all.Assert;
import com.currentbp.util.all.ListUtil;
import com.currentbp.util.all.StringUtil;
import org.junit.Test;

import java.util.List;

/**
 * @author baopan
 * @createTime 2020/7/20 10:11
 */
public class T0129 {
    /*
    给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
例如，从根到叶子节点路径 1->2->3 代表数字 123。
计算从根到叶子节点生成的所有数字之和。
说明: 叶子节点是指没有子节点的节点。
示例 1:
输入: [1,2,3]
    1
   / \
  2   3
输出: 25
解释:
从根到叶子节点路径 1->2 代表数字 12.
从根到叶子节点路径 1->3 代表数字 13.
因此，数字总和 = 12 + 13 = 25.
示例 2:
输入: [4,9,0,5,1]
    4
   / \
  9   0
 / \
5   1
输出: 1026
解释:
从根到叶子节点路径 4->9->5 代表数字 495.
从根到叶子节点路径 4->9->1 代表数字 491.
从根到叶子节点路径 4->0 代表数字 40.
因此，数字总和 = 495 + 491 + 40 = 1026.
     */

    @Test
    public void t1() {
        List<Integer> values = ListUtil.newArrayList(4, 9, 0, 5, 1, null, null);
        TreeNode root = new TreeNode(values);
        int sum = sumNumbers(root);
        StringUtil.printObject(sum);
        Assert.isTrue(1026 == sum, "error");
    }

    private int sumValue = 0;//总值

    public int sumNumbers(TreeNode root) {
        if (null == root) {
            return 0;
        }
        isLeafAndSum(root, 0);
        return sumValue;
    }

    /**
     * 如果是叶子节点，就计算总值
     * 如果不是叶子节点，则继续向下循环
     *
     * @param currentNode 当前节点
     * @param beforeValue 这个节点之前的值
     */
    public void isLeafAndSum(TreeNode currentNode, int beforeValue) {
        if (null == currentNode) {//如果节点是null，表示父节点的孩子是单节点
            return;
        }

        beforeValue = beforeValue * 10 + currentNode.val;
        if (null == currentNode.left && null == currentNode.right) {
            sumValue = sumValue + beforeValue;
            return;
        }
        isLeafAndSum(currentNode.left, beforeValue);
        isLeafAndSum(currentNode.right, beforeValue);
    }
}
