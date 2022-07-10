package com.currentbp.sort.skipList;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

public class MySkipListTest {
    @Test
    public void createHead(){
        MySkipList mySkipList = new MySkipList();
        mySkipList.insert(1,"123");
        StringUtil.printObject(MySkipList.header);
    }
}
