package com.currentbp.test.collectionTest;

import com.currentbp.util.all.StringUtil;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baopan
 * @createTime 2020/10/30 9:56
 */
public class ListTest {
    @Test
    public void t1(){
        List<Integer> l1 = Lists.newArrayList(1,2,3,4);
        List<Integer> l2 = Lists.newArrayList(1,2,3,4,5,6,7,8,9,10,11);
        if(!CollectionUtils.isEmpty(l2)){
            if(10 - l1.size()>l2.size()){
                l1.addAll(l2);
            }else {
                List<Integer> integers = l2.subList(0, 10 - l1.size());
                l1.addAll(integers);
            }
        }
        StringUtil.printObject(l1);
    }

    @Test
    public void t2(){
        List<Integer> l1 = Lists.newArrayList(1,2,3,4);
        List<Integer> integers = l1.subList(0, 1);
        StringUtil.printObject(integers);
    }

    @Test
    public void t3(){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        String[] strings = new String[11];
        System.out.println("address:"+strings.hashCode());
        String[] strings1 = list.toArray(strings);
        list.toArray();
        System.out.println("value:"+strings1+" address:"+strings1.hashCode());

    }

    @Test
    public void t4(){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        String[] strings = new String[1];
        System.out.println("address:"+strings.hashCode());
        String[] strings1 = list.toArray(strings);
        Object[] objects = list.toArray();//此处指定的类型时object，如果需要String类型，则需要使用上面的方式
        System.out.println("value:"+strings1+" address:"+strings1.hashCode());

    }
}
