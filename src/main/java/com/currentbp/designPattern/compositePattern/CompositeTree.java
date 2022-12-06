package com.currentbp.designPattern.compositePattern;

import java.util.List;

public class CompositeTree {
    private String name;
    private List<CompositeTree> trees;

    public CompositeTree(){}
    public CompositeTree(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CompositeTree> getTrees() {
        return trees;
    }

    public void setTrees(List<CompositeTree> trees) {
        this.trees = trees;
    }
}
