package com.currentbp.test.spring.aop.multAop.service;

import org.springframework.stereotype.Service;

/**
 * @author baopan
 * @createTime 2023/4/29 22:06
 */
@Service
public class MultAopServiceImpl implements MultAopService {
    @Override
    public String doSome(String arg) {
        return arg + "1";
    }
}
