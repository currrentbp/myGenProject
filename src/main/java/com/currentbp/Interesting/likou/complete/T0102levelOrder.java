package com.currentbp.Interesting.likou.complete;

import com.currentbp.common.entity.TreeNode;
import com.currentbp.util.all.StringUtil;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baopan
 * @createTime 2023/5/28 18:28
 */
public class T0102levelOrder {
    /*
给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
示例 1
输入：root = [3,9,20,null,null,15,7]
输出：[[3],[9,20],[15,7]]
示例 2：
输入：root = [1]
输出：[[1]]
示例 3：
输入：root = []
输出：[]

     */

    @Test
    public void t1() {
        StringUtil.printObject(levelOrder(new TreeNode(Lists.newArrayList(3, 9, 20, null, null, 15, 7))));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        List<TreeNode> levels = new ArrayList<>();
        levels.add(root);

        List<TreeNode> temps = new ArrayList<>();
        while (!levels.isEmpty()) {
            List<Integer> t1 = new ArrayList<>();
            for (TreeNode item : levels) {
                t1.add(item.val);
                if (item.left != null) {
                    temps.add(item.left);
                }
                if (item.right != null) {
                    temps.add(item.right);
                }
            }
            result.add(t1);
            levels = temps;
            temps = new ArrayList<>();
        }

        return result;
    }
}
