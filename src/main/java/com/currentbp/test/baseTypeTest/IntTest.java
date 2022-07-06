package com.currentbp.test.baseTypeTest;

import com.currentbp.common.model.Student;
import com.currentbp.util.all.StringUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 关于int的测试
 *
 * @author current_bp
 * @createTime 20170602
 */
public class IntTest {

    @Test
    public void t11(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"1"));
        students.add(new Student(2,"2"));
        students.add(new Student(3,"3"));
        students.add(new Student(4,"4"));
        students.add(new Student(5,"5"));

        StringUtil.printObject(students);
        List<Integer> ids = new ArrayList<>();
        ids.add(5);
        ids.add(2);
        ids.add(3);
        ids.add(1);
        ids.add(4);
//        students.sort(Student::getId,ids);

    }

    @Test
    public void IntegerEqString(){
        Integer integer = 2;
        String str  = "2";
        System.out.println(integer.toString().equals(str));
        System.out.println(1<<2);
    }

    @Test
    public void t3(){
        int i=5;
        int a = i++;
        int b = ++i;
        i= (a) + (b);
        System.out.println(i+" a:"+a+" b:"+b);
    }

    @Test
    public void t1(){
        String s1 = " 1, 2";
        String[] split = s1.split(",");
        int i = Integer.parseInt(split[0]);
        System.out.println(i);
    }

    @Test
    public void cacheTest(){
        int i = 128;
        Integer i2 = 128;
        Integer i3 = new Integer(128);
        //Integer会自动拆箱为int，所以为true
        System.out.println(i == i2);//true
        System.out.println(i == i3);//true
        System.out.println("**************");
        Integer i5 = 127;//java在编译的时候,被翻译成-> Integer i5 = Integer.valueOf(127);
        Integer i6 = 127;
        System.out.println(i5 == i6);//true
        Integer i9 = 128;
        Integer i10 = 128;
        System.out.println(i9 == i10);//false
        Integer ii5 = new Integer(127);
        System.out.println(i5 == ii5); //false
        Integer i7 = new Integer(128);
        Integer i8 = new Integer(128);
        System.out.println(i7 == i8);  //false
    }

    @Test
    public void getTime(){
        System.out.println(System.currentTimeMillis());
        System.out.println((System.currentTimeMillis()-(1000*(2019)*365*24*60*60)));
        System.out.println(System.currentTimeMillis()/1000/60);
    }

    @Test
    public void float2Int() {
        int x = Math.round(0.4F + 0.5F);
        int y = Math.round(0.4F);
        int z = Math.round(0.5F);
        int k = Math.round(0.7F + 0.5F);
        System.out.println("===>x:" + x + " y:" + y + " z:" + z + " k:" + k);
        //===>x:1 y:0 z:1 k:1
    }


    @Test
    public void IntegerEquals(){
        Integer i1 = 1;
        Integer i2 = 1;
        Integer i3 = new Integer(1);
        Assert.assertTrue(i1 == i2);
        Assert.assertTrue(i1 >= i3);
        Assert.assertTrue(i1.intValue() == i3.intValue());
//        Assert.assertTrue(i1 == i3);//判断的是两个地址，一个地址使用的是固定的（缓存中的），一个是实时新建出的
    }


    @Test
    public void IntegerEquals2(){
        Integer i1 = 1;
        Integer i2 = 1;
        Integer i3 = new Integer(1);
        Assert.assertTrue(i1 == i2);
        Assert.assertTrue(i1 >= i3);
        Assert.assertTrue(i1.intValue() == i3.intValue());
//        Assert.assertTrue(i1 == i3);//结果：false，原因：判断的是两个地址，一个地址使用的是固定的（缓存中的），一个是实时新建出的
    }

    //============          测试方法的私有方法            ==============================================//


}
