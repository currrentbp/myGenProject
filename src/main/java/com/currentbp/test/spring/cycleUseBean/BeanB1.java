package com.currentbp.test.spring.cycleUseBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author baopan
 * @createTime 2020/7/30 10:06
 */
@Service
public class BeanB1 {
    @Autowired
    private BeanC1 beanC1;
}
