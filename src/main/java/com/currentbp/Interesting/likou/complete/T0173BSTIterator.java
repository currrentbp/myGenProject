package com.currentbp.Interesting.likou.complete;

import com.currentbp.common.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author baopan
 * @createTime 2023/5/30 21:10
 */
public class T0173BSTIterator {

}

/*
实现一个二叉搜索树迭代器类BSTIterator ，表示一个按中序遍历二叉搜索树（BST）的迭代器：
BSTIterator(TreeNode root) 初始化 BSTIterator 类的一个对象。BST 的根节点 root 会作为构造函数的一部分给出。
指针应初始化为一个不存在于 BST 中的数字，且该数字小于 BST 中的任何元素。
boolean hasNext() 如果向指针右侧遍历存在数字，则返回 true ；否则返回 false 。
int next()将指针向右移动，然后返回指针处的数字。
注意，指针初始化为一个不存在于 BST 中的数字，所以对 next() 的首次调用将返回 BST 中的最小元素。
你可以假设next()调用总是有效的，也就是说，当调用 next()时，BST 的中序遍历中至少存在一个下一个数字。
示例：
输入
["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
[[[7, 3, 15, null, null, 9, 20]], [], [], [], [], [], [], [], [], []]
输出
[null, 3, 7, true, 9, true, 15, true, 20, false]
解释
BSTIterator bSTIterator = new BSTIterator([7, 3, 15, null, null, 9, 20]);
bSTIterator.next();    // 返回 3
bSTIterator.next();    // 返回 7
bSTIterator.hasNext(); // 返回 True
bSTIterator.next();    // 返回 9
bSTIterator.hasNext(); // 返回 True
bSTIterator.next();    // 返回 15
bSTIterator.hasNext(); // 返回 True
bSTIterator.next();    // 返回 20
bSTIterator.hasNext(); // 返回 False
解题思路：
1、遍历就是一个中序遍历，可以将这个结果存储在list中，然后弄一个游标，标记遍历到哪里了
 */
class BSTIterator {
    TreeNode root = null;
    List<TreeNode> inorders = new ArrayList<>();
    int cursor = -1;

    public BSTIterator(TreeNode root) {
        this.root = root;
        build(root);
    }

    private void build(TreeNode root) {
        if (root == null) {
            return;
        }
        build(root.left);
        inorders.add(root);
        build(root.right);
    }

    public int next() {
        cursor = cursor + 1;
        if (cursor >= inorders.size()) {
            return -1;
        }
        TreeNode treeNode = inorders.get(cursor);
        return treeNode.val;
    }

    public boolean hasNext() {
        if (cursor + 1 >= inorders.size()) {
            return false;
        }
        return true;
    }
}
