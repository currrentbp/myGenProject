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
public class T0114flatten {
    /*
给你二叉树的根结点 root ，请你将它展开为一个单链表：
展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
展开后的单链表应该与二叉树 先序遍历 顺序相同。
示例 1：
输入：root = [1,2,5,3,4,null,6]
输出：[1,null,2,null,3,null,4,null,5,null,6]
示例 2：
输入：root = []
输出：[]
示例 3：
输入：root = [0]
输出：[0]

解决思路1：
1、先实现先序读取，再将数据重组
     */

    @Test
    public void t1(){
        TreeNode treeNode = new TreeNode(Lists.newArrayList(1, 2, 3));
        treeNode.print();

        flatten(treeNode);
        treeNode.print();
    }

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        List<TreeNode> result = new ArrayList<>();
        fl(root,result);

        TreeNode first = new TreeNode(0);
        TreeNode pre = first;
        for (TreeNode treeNode : result) {
            pre.right = treeNode;
            pre.left = null;
            pre = treeNode;
        }
        pre.right = null;
    }

    private void fl(TreeNode node,List<TreeNode> result){
       if(node == null){
           return;
       }
//       System.out.println(node.val+" ");
       result.add(node);
       fl(node.left,result);
       fl(node.right,result);
    }
}
