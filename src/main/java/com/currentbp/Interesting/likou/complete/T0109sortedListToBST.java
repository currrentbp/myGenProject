package com.currentbp.Interesting.likou.complete;

import com.currentbp.common.entity.ListNode;
import com.currentbp.common.entity.TreeNode;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baopan
 * @createTime 2023/4/20 21:59
 */
public class T0109sortedListToBST {
    /*
给定一个单链表的头节点 head，其中的元素 按升序排序 ，将其转换为高度平衡的二叉搜索树。
本题中，一个高度平衡二叉树是指一个二叉树每个节点的左右两个子树的高度差不超过 1。
示例 1:
输入: head = [-10,-3,0,5,9]
输出: [0,-3,9,-10,null,5]
解释: 一个可能的答案是[0，-3,9，-10,null,5]，它表示所示的高度平衡的二叉搜索树。
示例 2:
输入: head = []
输出: []
解题思路：暴力做法
1、将listNode转成列表，
2、平分列表，以中间节点为根节点，左右延伸
     */

    @Test
    public void t1() {
        TreeNode treeNode = sortedListToBST(new ListNode(Lists.newArrayList(-10, -3, 0, 5, 9)));
        treeNode.print();
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int index = list.size() / 2;
        TreeNode root = new TreeNode(list.get(index)), leftTop = root, rightTop = root;
        mergeLeftTreed(list, 0, index - 1, leftTop);
        mergeRightTreed(list, index + 1, list.size() - 1, rightTop);

        return root;
    }

    private void mergeLeftTreed(List<Integer> list, int left, int right, TreeNode top) {
        if (left > right) {
            return;
        }

        int middle = (left + right) / 2;
        TreeNode newTop = new TreeNode(list.get(middle));
        top.left = newTop;
        //左侧
        mergeLeftTreed(list, left, middle - 1, newTop);
        //右侧
        mergeRightTreed(list, middle + 1, right, newTop);
    }

    private void mergeRightTreed(List<Integer> list, int left, int right, TreeNode top) {
        if (left > right) {
            return;
        }

        int middle = (left + right) / 2;
        TreeNode newTop = new TreeNode(list.get(middle));
        top.right = newTop;
        //左侧
        mergeLeftTreed(list, left, middle - 1, newTop);
        //右侧
        mergeRightTreed(list, middle + 1, right, newTop);
    }
}
