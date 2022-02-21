package com.currentbp.test.spring.aop;

import com.currentbp.common.model.Student;

/**
 * @author baopan
 * @createTime 20220108
 */
public class MyAopServiceImpl implements MyAopService{
    @Override
    public String getMyStudent(Integer id) {
        return new Student().toString();
    }
}
