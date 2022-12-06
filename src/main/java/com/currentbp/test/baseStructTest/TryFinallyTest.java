package com.currentbp.test.baseStructTest;

import com.currentbp.entry.BusinessException;
import org.junit.Test;

public class TryFinallyTest {

    @Test
    public void testReturn() {
        System.out.println(do1());
    }

    private int do1() {
        try {
            if (1 / 0 == 0) {
//            if (1 / 1 == 0) {
                throw new RuntimeException("1111");
            }
//            return 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 2;
        }finally {
            return 3;//如果此处有return值的话，意味着catch中的内容都会执行，但是return不会执行，且tryCatch结构体外的return不能有（idea会报错的）
        }
//        return 1;
    }


    @Test
    public void tryFinallyTest() {
        /*
        结论：1、先走catche，如果能捕获，则捕获异常，正常走下去
        2、如果没有被捕获异常，则直接周finally
        3、再抛出异常
         */
        doTry();
        System.out.println("end ");
    }

    private void doTry() {
        try {
            throw new BusinessException("baopan is error");
        } catch (IllegalAccessError e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("===>finally");
        }
    }

}
