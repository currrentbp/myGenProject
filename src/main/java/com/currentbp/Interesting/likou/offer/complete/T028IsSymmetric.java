package com.currentbp.Interesting.likou.offer.complete;

import com.currentbp.common.entity.TreeNode;
import com.currentbp.util.all.StringUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baopan
 * @createTime 20210705
 */
public class T028IsSymmetric {
    /*
请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
例如，二叉树[1,2,2,3,4,4,3] 是对称的。
  1
 / \
 2  2
/ \ / \
3 4 4 3
但是下面这个[1,2,2,null,3,null,3] 则不是镜像对称的:
  1
 / \
 2  2
 \  \
 3  3
示例 1：
输入：root = [1,2,2,3,4,4,3]
输出：true
示例 2：
输入：root = [1,2,2,null,3,null,3]
输出：false
     */
    @Test
    public void t1() {
        Integer[] temp = new Integer[]{1,2,2,3,4,4,3};
        StringUtil.printObject(isSymmetric(new TreeNode(temp)));
    }

    public boolean isSymmetric(TreeNode root) {
        List<TreeNode> nextList = new ArrayList<>();
        nextList.add(root);
        while (0 != nextList.size()) {
            boolean flag = checkMirror(nextList);
            if (!flag) {
                return false;
            }
            nextList = getNextList(nextList);
        }
        return true;
    }

    private boolean checkMirror(List<TreeNode> nextList) {
        if (null == nextList || nextList.size() <= 1) {
            return true;
        }
        for (int i = 0; i < nextList.size() / 2; i++) {
            if (null == nextList.get(i) ^ null == nextList.get(nextList.size() - i - 1)) {
                return false;
            }
            if (null == nextList.get(i) && null == nextList.get(nextList.size() - i - 1)) {
                continue;
            }
            if (nextList.get(i).val == nextList.get(nextList.size() - i - 1).val) {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }

    private List<TreeNode> getNextList(List<TreeNode> currentList) {
        List<TreeNode> result = new ArrayList<>();
        if (null == currentList || 0 == currentList.size()) {
            return result;
        }
        currentList.forEach(x -> {
            if (null != x) {
                result.add(x.left);
                result.add(x.right);
            }
        });
        return result;
    }


    /**
     * 官方最佳答案
     */
    public boolean isSymmetric2(TreeNode root) {
        if (root == null)
            return true;
        return helper(root.left, root.right);
    }

    public boolean helper(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        return root1.val == root2.val && helper(root1.left, root2.right) &&
                helper(root1.right, root2.left);
    }
}
