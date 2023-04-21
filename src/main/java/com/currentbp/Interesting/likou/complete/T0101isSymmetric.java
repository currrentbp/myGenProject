package com.currentbp.Interesting.likou.complete;

import com.currentbp.common.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baopan
 * @createTime 20221227
 */
public class T0101isSymmetric {
    /*
给你一个二叉树的根节点 root ， 检查它是否轴对称。
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        List<TreeNode> top = new ArrayList<>();
        List<TreeNode> temp = new ArrayList<>();
        top.add(root);
        while (true) {
            boolean flag = true;
            for (int i = 0; i < top.size(); i++) {
                if (top.get(i) != null) {
                    temp.add(top.get(i).left);
                    temp.add(top.get(i).right);
                    flag = false;
                } else {
                    temp.add(null);
                    temp.add(null);
                }
            }
            if (flag) {
                break;
            }

            for (int i = 0; i < top.size() / 2; i++) {
                TreeNode left = top.get(i);
                TreeNode right = top.get(top.size() - 1 - i);
                if (left == null && right == null) {
                    continue;
                }
                if (left == null ^ right == null) {
                    return false;
                }
                if (left.val != right.val) {
                    return false;
                }
            }
            top = temp;
            temp = new ArrayList<>();
        }

        return true;
    }
}
