package com.currentbp.Interesting.likou.complete;

import com.currentbp.common.entity.TreeNode;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baopan
 * @createTime 20221228
 */
public class T00113pathSum {
    /*
给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
叶子节点 是指没有子节点的节点。
示例 1：
输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
输出：[[5,4,11,2],[5,8,4,5]]
示例 2
输入：root = [1,2,3], targetSum = 5
输出：[]
示例 3：
输入：root = [1,2], targetSum = 0
输出：[]
     */

    @Test
    public void t1() {
//        System.out.println(hasPathSum(new TreeNode(Lists.newArrayList(1, 2, 3)), 3));
//        System.out.println(hasPathSum(new TreeNode(Lists.newArrayList(1, 2)), 0));
        System.out.println(hasPathSum(new TreeNode(Lists.newArrayList(1, 2)), 1));
    }

    public List<List<Integer>> hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        hasPath(root, targetSum, result, temp);
        return result;
    }

    private void hasPath(TreeNode root, int targetSum, List<List<Integer>> result, List<Integer> temp) {
        if (root == null) {
            return;
        }
        if (targetSum == root.val && root.left == null && root.right == null) {
            List<Integer> t1 = new ArrayList<>(temp);
            t1.add(root.val);
            result.add(t1);
            return;
        }

        temp.add(root.val);
        hasPath(root.left, targetSum - root.val, result, temp);
        temp.remove(temp.size() - 1);

        temp.add(root.val);
        hasPath(root.right, targetSum - root.val, result, temp);
        temp.remove(temp.size() - 1);
    }
}
