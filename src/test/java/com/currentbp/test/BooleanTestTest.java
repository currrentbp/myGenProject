package com.currentbp.test;

import com.alibaba.fastjson.JSONArray;
import com.currentbp.common.model.Student;
import com.currentbp.test.baseTypeTest.BooleanTest;
import org.assertj.core.util.Lists;
import org.junit.*;

import java.util.*;

/**
 * Created by issuser on 2017/4/7.
 */
public class BooleanTestTest {
    private BooleanTest booleanTest = new BooleanTest();
    private boolean t1;
    private static int x;

    public Boolean getT1() {
        return t1;
    }

    public void setT1(boolean t1) {
        this.t1 = t1;
    }

    @Test
    public void t2(){
        String s = "XYTG420SSJ　";
        System.out.println("===="+s.trim()+"===");
        s = s.trim().replace("\u00A0", "");
        s = s.trim().replace("\u0020", "");
        s = s.trim().replace("\u0009", "");
        s = s.trim().replace("\u0008", "");
        s = s.trim().replace("\u2028", "");
        s = s.trim().replace("\u2029", "");
        s = s.trim().replace("\uFEFF", "");
        s = s.trim().replace("\u3000", "");
        System.out.println("===="+s.trim()+"===");
    }

    //execute only once, in the starting
    @BeforeClass
    public static void beforeClass() {
        System.out.println("in before class:"+(++x));
    }

    //execute only once, in the end
    @AfterClass
    public static void  afterClass() {
        System.out.println("in after class:"+(++x));
    }

    @Before
    public void before2() {
        System.out.println("in before2:"+(++x));
    }
    //execute for each test, before executing test
    @Before
    public void before3() {
        System.out.println("in before3:"+(++x));
    }


    //execute for each test, after executing test
    @After
    public void after() {
        System.out.println("in after:"+(++x));
    }

    //test case 1
    @Test
    public void testCase1() {
        System.out.println("in test case x:"+(++x));
    }

    //test case 2
    @Test
    public void testCase2() {
        System.out.println("in test case 2");
    }



    @Test
    public void integerSwap(){
        System.out.println(15.65/(376.65-15.65));
        Integer x=10111;
        Integer y=11111;
        swap(x,y);
        System.out.println(x+":"+y);

        Student student = new Student(1,"11");
        Student student2 = new Student(2,"22");
        System.out.println("s1:"+student.hashCode());
        swapStudent(student,student2);
        System.out.println(student.toString()+"  ==== " +student2.toString());
        Student student3 = new Student(3,"3333");
        student=student3;
        student.setName("fffffffffffffffffff");
        System.out.println(student.toString()+"  ==== " +student3.toString());
        System.out.println("s1:"+student.hashCode());
        //结论：java 是值传递的，
    }
    private void swap(Integer x,Integer y){
        Integer z = x;
        x=y;
        y=z;
    }

    private void swapStudent(Student student,Student student2){
        Student temp = null;
        temp = student;
        System.out.println(" temp:" +temp.toString());
        student = student2;
        System.out.println(" student:" +student.toString());
        student2 = temp;
        System.out.println(" student2:" +student2.toString());

        student.setHobbies(Lists.newArrayList("fffffffff"));
        System.out.println(" student:" +student.toString());
        student2.setHobbies(Lists.newArrayList("kkkkkkkkkkk"));
        System.out.println(" student2:" +student2.toString());
    }


    @Test
    public void t123() {
        String t1="5:";
        String[] split = t1.split(":");
        System.out.println(split.length);

    }


    @Test
    public void testParseObject() {
        String ss = "{\"fieldCode\":\"305c8027d10847103920579b4bf2d52d\"," +
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
    public void map() {
        Map<String, String> map = new HashMap<>();

    }

    @Test
    public void t12() {
//        setT1(true);
        if (getT1()) {
            System.out.println("==========");
        } else {
            System.out.println("+++++++++++++");
        }
    }

    @Test
    public void removeAll() {
        List<Integer> l1 = new ArrayList<>();
        Set<Integer> set = new HashSet<>(l1);
        List<Integer> list = Lists.newArrayList(10, 11, 12);
        list.removeAll(set);
        System.out.println(list);
    }

    @Test
    public void mod() {
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
    public void eachOperatorResult() {
        booleanTest.eachOperatorResult();
    }

}