package com.currentbp.test.baseStructTest;

import com.currentbp.entry.BusinessException;
import org.junit.Test;

public class TryFinallyTest {


    @Test
    public void tryFinallyTest(){
        /*
        结论：1、先走catche，如果能捕获，则捕获异常，正常走下去
        2、如果没有被捕获异常，则直接周finally
        3、再抛出异常
         */
        doTry();
        System.out.println("end ");
    }

    private void doTry(){
        try{
            throw new BusinessException("baopan is error");
        }catch (IllegalAccessError e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            System.out.println("===>finally");
        }
    }

}
