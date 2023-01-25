package com.currentbp.Interesting.likou.offer.complete;

import com.currentbp.common.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baopan
 * @createTime 1/9/2023 7:56 PM
 */
public class T034pathSum {
    /*
    给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
    叶子节点 是指没有子节点的节点。
    示例 1：
    输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
    输出：[[5,4,11,2],[5,8,4,5]]
    示例 2：
    输入：root = [1,2,3], targetSum = 5
    输出：[]
    示例 3：
    输入：root = [1,2], targetSum = 0
    输出：[]

     */
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        doPathSum(root, target, result, new ArrayList<Integer>(), 0);

        return result;
    }

    private void doPathSum(TreeNode root, int target, List<List<Integer>> result, List<Integer> temp, int tempValue) {
        if (root == null) {
            return;
        }
        if (target == tempValue + root.val && root.left == null && root.right == null) {
            temp.add(root.val);
            result.add(temp);
            return;
        }
        temp.add(root.val);
        doPathSum(root.left, target, result, new ArrayList<>(temp), tempValue + root.val);
        doPathSum(root.right, target, result, new ArrayList<>(temp), tempValue + root.val);
        temp.remove(temp.size() - 1);
    }
}
