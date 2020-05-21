package com.currentbp.util.all;

import com.alibaba.fastjson.JSON;
import com.currentbp.common.model.Student;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by issuser on 2017/5/25.
 */
public class StringUtilTest {



    @Test
    public void t1212(){
        Double x = 0D;
        if(1==1 ){
            x = null;
        }

        System.out.println(0D== x);//npe
    }

    @Test
    public void t123(){
        List<Integer> x = new ArrayList<>();
        x.add(1);
        x.add(2);
        x.add(3);
        x.add(4);
        x.add(5);
        List<Integer> list = x.subList(0, 3);
        StringUtil.printObject(list);

    }

    @Test
    public void t1(){
        List<Integer> s1 = new ArrayList<>(4);
        s1.add(1);
        s1.add(5);
        s1.add(3);

        Collections.sort(s1);
        s1.set(3,2);
        Collections.reverse(s1);
        StringUtil.printObject(s1);
    }

    @Test
    public void getHumpFormat(){
        System.out.println(StringUtil.getHumpFormat("bp"));
        System.out.println(StringUtil.getHumpFormat(null));
        System.out.println(StringUtil.getHumpFormat("b"));
        System.out.println(StringUtil.getHumpFormat("bp_1"));
        System.out.println(StringUtil.getHumpFormat("bp_C"));
        System.out.println(StringUtil.getHumpFormat("bp_f"));
        System.out.println(StringUtil.getHumpFormat("bp_i_k_qq"));
        System.out.println(StringUtil.getHumpFormat("Bp_i_k_qq"));
    }

    @Test
    public void deleteLast() throws Exception {

    }

    @Test
    public void getStringWithOutSome() throws Exception {

    }

    @Test
    public void getStringWithOutSome1() throws Exception {

    }

    @Test
    public void getStringWithOutSome2() throws Exception {

    }

    @Test
    public void fillBySome() throws Exception {

    }

    @Test
    public void fillBySome1() throws Exception {

    }

    @Test
    public void fillBySome2() throws Exception {

    }

    @Test
    public void fillBySome3() throws Exception {

    }

    @Test
    public void getCaptureName() throws Exception {

    }

    @Test
    public void getSplitString() throws Exception {

    }

    @Test
    public void insertSomethingToWhere() throws Exception {
        List<Student> students = Lists.newArrayList(new Student(1, "111"));
        for (int i=0;
             i<students.size();
             i++) {
            Student student = students.get(i);
            if(student.getName().equals("111")){
                students.remove(student);
                i--;
            }
        }
        StringUtil.printObject(students);
    }

    @Test
    public void stringToList() throws Exception {

    }

    @Test
    public void stringToList1() throws Exception {
        Double s = 2*199.00-397.99;
        System.out.println(s);
    }

    @Test
    public void letter2Int() throws Exception {

    }

    @Test
    public void int2Letter() throws Exception {

    }

    @Test
    public void getALabel() throws Exception {
        String source = "<em>123</em><em>456</em>";
        System.out.println(StringUtil.getLabelContent(source, "em"));
    }

    @Test
    public void removeBlank(){
        String s = "XYTG420SSJ　";
        System.out.println("====="+StringUtil.removeBlank(s)+"==========");
    }

}