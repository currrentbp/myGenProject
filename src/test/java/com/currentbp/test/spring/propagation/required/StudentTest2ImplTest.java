package com.currentbp.test.spring.propagation.required;

import com.currentbp.SpringBaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentTest2ImplTest extends SpringBaseTest {
    @Autowired
    private StudentTest2 studentTest2;

    @Test
    public void t1(){
        studentTest2.insertTwo();
    }

}