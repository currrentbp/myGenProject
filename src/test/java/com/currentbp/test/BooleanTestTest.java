package com.currentbp.test;

import com.alibaba.fastjson.JSONArray;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.*;

/**
 * Created by issuser on 2017/4/7.
 */
public class BooleanTestTest {
    private BooleanTest booleanTest = new BooleanTest();
    private boolean t1;

    public Boolean getT1() {
        return t1;
    }

    public void setT1(boolean t1) {
        this.t1 = t1;
    }




    @Test
    public void testParseObject(){
        String ss= "{\"fieldCode\":\"305c8027d10847103920579b4bf2d52d\"," +
                "\"fieldLabel\":\"工作内容\"," +
                "\"fieldName\":\"content\"," +
                "\"fieldValue\":\"1.接受培训完成授课任务\n2.与家长联系，及时通知学生信息\n3.如果教学过关，参与部门工作\"\n\"," +
                "\"templateCode\":\"e6996061edc240178d383d7cc93ec023\"," +
                "\"businessTypeCode\":\"rczx\"," +
                "\"sortNo\":2," +
                "\"fieldType\":\"textarea\"," +
                "\"unitInfo\":\"\"}";
        Object parse = JSONArray.parse(ss);
        System.out.println(parse);
    }

    @Test
    public void map(){
        Map<String,String> map = new HashMap<>();

    }
    @Test
    public void t12(){
//        setT1(true);
        if(getT1()){
            System.out.println("==========");
        }else{
            System.out.println("+++++++++++++");
        }
    }

    @Test
    public  void removeAll(){
        List<Integer> l1 = new ArrayList<>();
        Set<Integer> set = new HashSet<>(l1);
        List<Integer> list = Lists.newArrayList(10,11,12);
        list.removeAll(set);
        System.out.println(list);
    }

    @Test
    public void mod(){
        ArrayList<String> strings = Lists.newArrayList("2018", "2019", "2017", "2000", "2010");
        System.out.println(strings);
        Arrays.sort(strings.toArray());

        System.out.println(strings);
//        for(int i=0;i<200;i++){
//            System.out.println("result = "+(i % 50 == 0)+" i="+i);
//        }
    }

    @Test
    public void simpleTypeHasDefaultValue() throws Exception {
        booleanTest.simpleTypeHasDefaultValue();
    }

    @Test
    public void eachOperatorResult(){
        booleanTest.eachOperatorResult();
    }

}