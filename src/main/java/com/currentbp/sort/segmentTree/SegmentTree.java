package com.currentbp.sort.segmentTree;

/**
 * @author baopan
 * @createTime 1/27/2023 10:01 AM
 */
public class SegmentTree {

    public STree buildTree(int value) {
        STree sTree = new STree();
        sTree.setLeft(value);
        sTree.setRight(value);
        return sTree;
    }

    public void insert(STree root, int value) {
        if(root == null){
            return;
        }
        if(root.getLeft()==root.getRight()){

        }
        if (value < root.getLeft() ) {
            root.setLeft(value);
            insert(root.getLeftTree(),value);
            return;
        }
        if(root.getRight()<value){
            return;
        }

        return;
    }
}
