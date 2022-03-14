package com.currentbp.test.spring.aop;

import com.currentbp.common.model.Student;
import org.springframework.stereotype.Component;

/**
 * @author baopan
 * @createTime 20220108
 */
@Component
public class MyAopServiceImpl implements MyAopService{
    @Override
    public String getMyStudent(Integer id) {
        return new Student().toString();
    }
}
