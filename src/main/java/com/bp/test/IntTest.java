package com.bp.test;

import org.junit.Test;

/**
 * 关于int的测试
 *
 * @author current_bp
 * @createTime 20170602
 */
public class IntTest {

    @Test
    public void float2Int() {
        int x = Math.round(0.4F + 0.5F);
        int y = Math.round(0.4F);
        int z = Math.round(0.5F);
        int k = Math.round(0.7F + 0.5F);
        System.out.println("===>x:" + x + " y:" + y + " z:" + z + " k:" + k);
        //===>x:1 y:0 z:1 k:1
    }


    //============          测试方法的私有方法            ==============================================//


}
