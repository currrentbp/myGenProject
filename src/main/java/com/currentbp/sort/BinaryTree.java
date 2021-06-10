package com.currentbp.sort;

import com.currentbp.common.entity.TreeNode;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的先序遍历、中序遍历、后序遍历
 */
public class BinaryTree {
    private TreeNode treeNode;

    @Before
    public void init() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(null);
        list.add(8);
        list.add(null);
        list.add(9);
        list.add(10);
        list.add(11);
        treeNode = new TreeNode(list);
    }

    @Test
    public void firstPrint() {
        /*
        先序遍历：（根左右）
         */
        firstPrint(treeNode);
    }

    private void firstPrint(TreeNode currentNode) {
        if (null == currentNode) {
            return;
        }
        System.out.print("" + currentNode.val + " ,");
        firstPrint(currentNode.left);
        firstPrint(currentNode.right);
    }

    @Test
    public void middlePrint() {
        /*
        中(根)序遍历（左根右）
         */
        middlePrint(treeNode);
    }

    private void middlePrint(TreeNode currentNode) {
        if (null == currentNode) {
            return;
        }
        middlePrint(currentNode.left);
        System.out.print("" + currentNode.val + " ,");
        middlePrint(currentNode.right);
    }

    @Test
    public void lastPrint() {
        /*
        后(根)序遍历（左右根）
         */
        lastPrint(treeNode);
    }

    private void lastPrint(TreeNode currentNode) {
        if (null == currentNode) {
            return;
        }
        lastPrint(currentNode.left);
        lastPrint(currentNode.right);
        System.out.print("" + currentNode.val + " ,");
    }
}
