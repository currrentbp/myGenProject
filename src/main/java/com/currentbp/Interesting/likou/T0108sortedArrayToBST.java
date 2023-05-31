package com.currentbp.Interesting.likou;

import com.currentbp.common.entity.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baopan
 * @createTime 2023/5/28 18:10
 */
public class T0108sortedArrayToBST {
    /*
    给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
示例 1：
输入：nums = [-10,-3,0,5,9]
输出：[0,-3,9,-10,null,5]
解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
示例 2：
输入：nums = [1,3]
输出：[3,1]
解释：[1,null,3] 和 [3,1] 都是高度平衡二叉搜索树。

     */
    @Test
    public void t1() {
        sortedArrayToBST(new int[]{-10, -3, 0, 5, 9}).print();
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }


        int middle = nums.length / 2;
        TreeNode root = new TreeNode(nums[middle]);
        int[] leftNums = getNums(nums, middle, true);
        int[] rightNums = getNums(nums, middle, false);

        root.left = sortedArrayToBST(leftNums);
        root.right = sortedArrayToBST(rightNums);
        return root;
    }

    private int[] getNums(int[] nums, int middle, boolean isLeft) {
        List<Integer> lefts = new ArrayList<>();
        List<Integer> rights = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i == middle) {
                continue;
            }
            if (isLeft && i < middle) {
                lefts.add(nums[i]);
            } else if (!isLeft && i > middle) {
                rights.add(nums[i]);
            }
        }

        if (isLeft) {
            int[] result = new int[lefts.size()];
            for (int i = 0; i < lefts.size(); i++) {
                result[i] = lefts.get(i);
            }
            return result;
        } else {
            int[] result = new int[rights.size()];
            for (int i = 0; i < rights.size(); i++) {
                result[i] = rights.get(i);
            }
            return result;
        }
    }
}
