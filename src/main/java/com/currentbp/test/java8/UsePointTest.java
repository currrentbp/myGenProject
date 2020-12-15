package com.currentbp.test.java8;

import com.currentbp.common.model.Student;
import org.junit.Test;

import java.util.function.Function;

/**
 * @author baopan
 * @createTime 20201127
 */
public class UsePointTest {

    @Test
    public void t1(){
        useFunction2();
    }

    private UseStudentInterface useFunction2(){
        return this::useFunction;
    }


    private UseStudentInterface useFunction(){
        return null;
    }

}


