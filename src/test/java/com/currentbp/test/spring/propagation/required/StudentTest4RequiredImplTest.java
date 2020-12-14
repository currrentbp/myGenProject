package com.currentbp.test.spring.propagation.required;

import com.currentbp.SpringBaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentTest4RequiredImplTest extends SpringBaseTest {
    @Autowired
    private StudentTest4Required studentTest4Required;

    @Test
    public void t1(){
        studentTest4Required.insertTwo();
    }

}