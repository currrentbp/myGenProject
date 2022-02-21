package com.currentbp.test.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author baopan
 * @createTime 20220221
 */
@Aspect
@Component
public class MyAopAspect {

    @Pointcut("execution(* * com.currentbp.test.spring.*(..)")
    public void pointCut() {
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint pjp) {
        System.out.println("====>ssssssss");
        try {
            return pjp.proceed();
        } catch (Throwable e) {
            System.out.println("====>ssssssss2222");
        }
        return null;
    }
}
