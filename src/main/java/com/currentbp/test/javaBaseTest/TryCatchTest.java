package com.currentbp.test.javaBaseTest;

import com.currentbp.util.all.Assert;

/**
 * @author baopan
 * @createTime 20190702
 */
public class TryCatchTest {
    public static void main(String[] args){
        TryCatchTest tryCatchTest = new TryCatchTest();
        int b = tryCatchTest.t1(2);
        int b1 = tryCatchTest.t1(1);
        System.out.println("+++b:"+b+"  b1:"+b1);
    }
    public int t1(int x){
        try{
            Assert.isTrue(x==1,"sssssss");
        }catch (Exception e){
            System.out.println("===>e:"+e.getMessage());
            return 0;
        }
        return 1;
    }
}
