package com.currentbp.test.spring.propagation.required;

import com.currentbp.SpringBaseTest;
import com.currentbp.interceptor.LogSpringFunctionInterceptor;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

public class StudentImplTest2Test extends SpringBaseTest {
    private final static Logger logger = LoggerFactory.getLogger(StudentImplTest2Test.class);
    @Resource(name = "studentImplTest2")
    private StudentImplTest2 studentImplTest;
    @Resource(name = "logSpringFunctionInterceptor")
    private LogSpringFunctionInterceptor logSpringFunctionInterceptor;


    @Test
    public void insertTwo(){
        logSpringFunctionInterceptor.t1();
        studentImplTest.insertTwo();
    }

    @Test
    public void t2(){
        logSpringFunctionInterceptor.t1();
    }
}