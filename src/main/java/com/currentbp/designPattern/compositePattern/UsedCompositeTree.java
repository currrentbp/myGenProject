package com.currentbp.designPattern.compositePattern;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UsedCompositeTree {

    @Test
    public void t1() {
        CompositeTree top = new CompositeTree("top");
        CompositeTree one = new CompositeTree("one");
        CompositeTree two = new CompositeTree("two");
        CompositeTree three = new CompositeTree("three");
        List<CompositeTree> sub = new ArrayList<>();
        sub.add(one);
        sub.add(two);
        sub.add(three);

        top.setTrees(sub);
        StringUtil.printObject(top);
    }
}
