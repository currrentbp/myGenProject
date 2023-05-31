package com.currentbp.test.spring.aop.jdkProxy;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author baopan
 * @createTime 2023/5/31 15:09
 */
@Component
public class OnlyFunctionConfig {


    @Bean
    public OnlyInterface getOne() {
        Class<OnlyInterface> interfaceType = OnlyInterface.class;
        InvocationHandler handler = new OnlyInterfaceProxy();
        return (OnlyInterface) Proxy.newProxyInstance(interfaceType.getClassLoader(),
                new Class[]{interfaceType}, handler);

    }
}
