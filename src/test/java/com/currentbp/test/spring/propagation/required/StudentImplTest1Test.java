package com.currentbp.test.spring.propagation.required;

import com.currentbp.SpringBaseTest;
import org.junit.Test;

import javax.annotation.Resource;

public class StudentImplTest1Test extends SpringBaseTest {
    @Resource(name = "studentImplTest1")
    private StudentImplTest1 studentImplTest;

    @Test
    public void t1(){
        studentImplTest.getList();
    }

    @Test
    public void insertTwo(){
        studentImplTest.insertTwo();
    }
}