package com.currentbp.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author baopan
 * @createTime 2020/10/30 17:12
 */

@Component
@Aspect
public class LogSpringFunctionInterceptor {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogSpringFunctionInterceptor.class);
    {
        System.out.println("===>init LogSpringFunctionInterceptor======");
    }

    public void t1(){
        LOGGER.info("====================");
    }

    @Pointcut("execution(* com.currentbp.test.spring.propagation.required.StudentTest2.*(..))")
    public void pointCut1(){
        LOGGER.info("=========222222222===========StudentTest2");
    };

    @Before("pointCut1()")
    public void logStart() {
        MDC.put("invokeNo", UUID.randomUUID().toString().replaceAll("-", ""));
        System.out.println("======>logStart===========>");
    }

    @Around("pointCut1()")
    public Object process(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            MDC.put("invokeNo", UUID.randomUUID().toString().replaceAll("-", ""));
            System.out.println("======>process===========>");
            Object obj = joinPoint.proceed();
            return obj;
        } catch (Throwable throwable) {
            LOGGER.error("MDC标识添加异常:", throwable);
            throw new RuntimeException("TraceIDAscept.process,MDC标识invokeNo添加异常");
        } finally {
            MDC.clear();
        }
    }

}
