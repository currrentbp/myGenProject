package com.currentbp.Interesting.likou.complete;

import com.currentbp.common.entity.TreeNode;
import com.currentbp.util.all.StringUtil;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baopan
 * @createTime 2023/5/28 17:45
 */
public class T0107levelOrderBottom {
    /*
给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
示例 1：
输入：root = [3,9,20,null,null,15,7]
输出：[[15,7],[9,20],[3]]
示例 2：
输入：root = [1]
输出：[[1]]
示例 3：
输入：root = []
输出：[]

     */

    @Test
    public void t1() {
        StringUtil.printObject(levelOrderBottom(new TreeNode(Lists.newArrayList(3,9,20,null,null,15,7))));
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<TreeNode>> allLevels = new ArrayList<>();
        List<TreeNode> levels = new ArrayList<>();
        levels.add(root);
        allLevels.add(levels);

        while (levels != null && levels.size() != 0) {
            List<TreeNode> nextLevels = getNextLevels(levels);
            levels = nextLevels;
            if (nextLevels != null && nextLevels.size() != 0) {
                allLevels.add(nextLevels);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = allLevels.size() - 1; i >= 0; i--) {
            List<TreeNode> treeNodes = allLevels.get(i);
            List<Integer> temp = new ArrayList<>(treeNodes.size());
            treeNodes.forEach(x -> temp.add(x.val));
            result.add(temp);
        }
        return result;
    }

    private List<TreeNode> getNextLevels(List<TreeNode> levels) {
        if (levels == null || levels.size() == 0) {
            return null;
        }
        List<TreeNode> result = new ArrayList<>();
        for (TreeNode item : levels) {
            if (item.left != null) {
                result.add(item.left);
            }
            if (item.right != null) {
                result.add(item.right);
            }
        }
        return result;
    }
}
