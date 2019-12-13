package com.currentbp.common.entity;

/**
 * @author baopan
 * @createTime 2019/3/16 11:42
 */
public class CharBinaryTree {

    private char value;
    private CharBinaryTree next;

    public CharBinaryTree() {
    }

    public CharBinaryTree(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    public CharBinaryTree setValue(char value) {
        this.value = value;
        return this;
    }

    public CharBinaryTree getNext() {
        return next;
    }

    public CharBinaryTree setNext(CharBinaryTree next) {
        this.next = next;
        return this;
    }
}
