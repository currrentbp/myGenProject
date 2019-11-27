package com.currentbp.test;

import org.junit.Assert;
import org.junit.Test;

/**
 * 关于int的测试
 *
 * @author current_bp
 * @createTime 20170602
 */
public class IntTest {

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
