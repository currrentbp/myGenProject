package com.currentbp.test.spring.aop.multAop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author baopan
 * @createTime 20220221
 */
@Aspect
@Component
@Order(2)
public class MyMultAopAspectTwo {

    @Pointcut("execution(* com.currentbp.test.spring.aop.multAop..*(..))")
    public void pointCut() {
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint pjp) {
        System.out.println("====>aspect around two start ....");
        try {
            Object proceed = pjp.proceed();
            System.out.println("====>aspect around two end !!!");
            return proceed;
        } catch (Throwable e) {
            System.out.println("====>aspect around two error !!!");
        }
        return null;
    }
}
