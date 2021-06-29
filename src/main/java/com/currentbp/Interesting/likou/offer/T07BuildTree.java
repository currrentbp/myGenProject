package com.currentbp.Interesting.likou.offer;

import com.currentbp.common.entity.TreeNode;
import com.currentbp.util.all.StringUtil;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 20210629
 */
public class T07BuildTree {
    /*
输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
例如，给出
前序遍历 preorder =[3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：
    3
   / \
  9  20
    /  \
   15   7
解题思路：
1、根据前序直接找到顶点，然后根据顶点在中序中的位置，可以判定中序的左边都是左节点，中序的右边都是右节点，使用一个访问数组来标识是否已经访问过，用递归
     */

    @Test
    public void t1(){
        StringUtil.printObject(buildTree(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7}));
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return null;
    }
    private void doEach(TreeNode currentNode,int[] preorder, int[] inorder, int index, boolean[] visited){

    }
}
