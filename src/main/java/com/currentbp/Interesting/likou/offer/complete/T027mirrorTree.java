package com.currentbp.Interesting.likou.offer.complete;

import com.currentbp.common.entity.TreeNode;

/**
 * @author baopan
 * @createTime 20221226
 */
public class T027mirrorTree {
    /*
请完成一个函数，输入一个二叉树，该函数输出它的镜像。
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode treeNode = new TreeNode(root.val);
        doCopy(root, treeNode);

        return treeNode;
    }

    private void doCopy(TreeNode root, TreeNode treeNode) {
        if(root == null){
            return;
        }

        if (root.left != null) {
            treeNode.right = new TreeNode(root.left.val);
        } else {
            treeNode.right = null;
        }
        if(root.right != null){
            treeNode.left = new TreeNode(root.right.val);
        }else{
            treeNode.left = null;
        }
        doCopy(root.left,treeNode.right);
        doCopy(root.right,treeNode.left);
    }


}
