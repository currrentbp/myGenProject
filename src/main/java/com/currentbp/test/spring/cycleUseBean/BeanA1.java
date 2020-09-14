package com.currentbp.test.spring.cycleUseBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author baopan
 * @createTime 2020/7/30 10:06
 */
@Service
public class BeanA1 {
    @Autowired
    public BeanB1 beanB1;
}
