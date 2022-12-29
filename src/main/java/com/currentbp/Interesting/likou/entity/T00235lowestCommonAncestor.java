package com.currentbp.Interesting.likou.entity;

import com.currentbp.common.entity.TreeNode;
import com.currentbp.util.all.StringUtil;
import org.assertj.core.util.Lists;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 20221229
 */
public class T00235lowestCommonAncestor {
    /*
给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
例如，给定如下二叉搜索树: root =[6,2,8,0,4,7,9,null,null,3,5]
示例 1:
输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
输出: 6
解释: 节点 2 和节点 8 的最近公共祖先是 6。
示例 2:
输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
输出: 2
解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
     */

    @Test
    public void t1() {
//        TreeNode treeNode = lowestCommonAncestor(new TreeNode(Lists.newArrayList(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5)), new TreeNode(2), new TreeNode(8));
        TreeNode treeNode = lowestCommonAncestor(new TreeNode(Lists.newArrayList(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5)), new TreeNode(2), new TreeNode(4));
        treeNode.print();
        StringUtil.printObject(treeNode);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        return lowestCommon(root, p, q);
    }

    private TreeNode lowestCommon(TreeNode root, TreeNode p, TreeNode q) {
        boolean flag = isCommon(root, p, q);
        if (flag) {
            boolean leftCommon = isCommon(root.left, p, q);
            boolean rightCommon = isCommon(root.right, p, q);
            if (!leftCommon && !rightCommon) {
                return root;
            }

            if (leftCommon) {
                return lowestCommon(root.left, p, q);
            }

            if (rightCommon) {
                return lowestCommon(root.right, p, q);
            }

            return null;
        }
        return null;
    }

    private boolean isCommon(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }

        return isCommon2(root, p) && isCommon2(root, q);
    }

    private boolean isCommon2(TreeNode root, TreeNode p) {
        if (root == null) {
            return false;
        }
        if (root.val == p.val) {
            return true;
        }
        return isCommon2(root.left, p) || isCommon2(root.right, p);
    }
}
