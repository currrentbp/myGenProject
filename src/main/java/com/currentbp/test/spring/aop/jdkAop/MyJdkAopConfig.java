package com.currentbp.test.spring.aop.jdkAop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.currentbp.test.spring.aop.jdkAop")
@EnableAspectJAutoProxy
public class MyJdkAopConfig {
}
