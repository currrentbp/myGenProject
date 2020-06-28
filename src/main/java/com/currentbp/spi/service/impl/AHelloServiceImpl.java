package com.currentbp.spi.service.impl;

import com.currentbp.spi.service.HelloService;

/**
 * @author baopan
 * @createTime 2020/6/28 10:57
 */
public class AHelloServiceImpl  implements HelloService {


    @Override
    public String sayHello(String content) {
        return "A:"+content;
    }
}
