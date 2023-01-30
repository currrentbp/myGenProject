package com.currentbp.sort.segmentTree;

/**
 * @author baopan
 * @createTime 1/27/2023 10:02 AM
 */
public class STree {
    private int left;
    private int right;
    private STree leftTree;
    private STree rightTree;

    public STree() {
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public STree getLeftTree() {
        return leftTree;
    }

    public void setLeftTree(STree leftTree) {
        this.leftTree = leftTree;
    }

    public STree getRightTree() {
        return rightTree;
    }

    public void setRightTree(STree rightTree) {
        this.rightTree = rightTree;
    }
}
