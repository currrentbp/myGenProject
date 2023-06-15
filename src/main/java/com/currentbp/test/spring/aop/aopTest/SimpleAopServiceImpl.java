package com.currentbp.test.spring.aop.aopTest;

import com.currentbp.common.model.Student;
import org.springframework.stereotype.Service;

/**
 * @author baopan
 * @createTime 2023-06-14 16:29:29
 */
@Service
public class SimpleAopServiceImpl implements SimpleAopService{
    @Override
    public Student getById(Integer id) {
        return null;
    }
}
