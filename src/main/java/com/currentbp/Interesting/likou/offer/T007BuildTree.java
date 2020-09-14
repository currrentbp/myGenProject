package com.currentbp.Interesting.likou.offer;

import com.currentbp.common.entity.TreeNode;
import com.currentbp.util.all.StringUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author baopan
 * @createTime 2020/8/31 10:48
 */
public class T007BuildTree {
    /*
    输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
    假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
例如，给出
前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：
    3
   / \
  9  20
    /  \
   15   7
限制：
0 <= 节点个数 <= 5000
解题思路：
1、不能有重复的数字，重复意味着可能有n种情况
2、使用先序的第一个固定住root节点
3、
     */
    @Test
    public void t1() {
        TreeNode treeNode = buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        StringUtil.printObject(treeNode);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (null == preorder || 0 == preorder.length) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        TreeNode currentNode = root;
        int preIndex = 1;
        //
        Map<Integer, Integer> value2Index4InOrder = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            value2Index4InOrder.put(inorder[i], i);
        }

        doBuild(preorder, inorder, currentNode, preIndex, value2Index4InOrder,root);
        return root;
    }

    private boolean doBuild(int[] preorder, int[] inorder, TreeNode currentNode,
                            int preIndex, Map<Integer, Integer> value2Index4InOrder,TreeNode root) {
        if (currentNode == null) {
            return false;
        }
        if(preIndex>=preorder.length){
            return checkAll(root,inorder);
        }
        int value = preorder[preIndex];

        //设置到左节点
        TreeNode newCurrentNode = new TreeNode(value);
        currentNode.left = newCurrentNode;
        boolean isLeftOk = checkLeft(currentNode, newCurrentNode, value2Index4InOrder);
        if (isLeftOk) {
            return doBuild(preorder, inorder, newCurrentNode, preIndex + 1, value2Index4InOrder,root);
        } else {
            currentNode.left = null;
            currentNode.right = newCurrentNode;
            return doBuild(preorder, inorder, newCurrentNode, preIndex + 1, value2Index4InOrder,root);
        }
    }

    private boolean checkAll(TreeNode root, int[] inorder) {
        int index = 0;
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        while(index<inorder.length){

        }
        return false;
    }

    private boolean checkLeft(TreeNode currentNode, TreeNode newCurrentNode,
                              Map<Integer, Integer> value2Index4InOrder) {
        Integer currentIndex = value2Index4InOrder.get(currentNode.val);
        Integer newCurrentIndex = value2Index4InOrder.get(newCurrentNode.val);
        return newCurrentIndex < currentIndex;
    }


}
