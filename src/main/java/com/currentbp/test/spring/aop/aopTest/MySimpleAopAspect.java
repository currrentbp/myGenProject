package com.currentbp.test.spring.aop.aopTest;

import com.currentbp.util.all.StringUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author baopan
 * @createTime 20220221
 */
@Aspect
@Component
@Order(3)
public class MySimpleAopAspect {

    @Pointcut("execution(* com.currentbp.test.spring.aop.aopTest..*(..))")
    public void pointCut() {
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint pjp) {
        System.out.println("====>aspect around one start ....");
        try {
            Object proceed = pjp.proceed();
            System.out.println("====>aspect around one end !!!");
            return proceed;
        } catch (Throwable e) {
            System.out.println("====>aspect around one error !!!");
        }
        return null;
    }

    @Before("pointCut()")
    public void before(JoinPoint joinPoint){
        Object[] objs = joinPoint.getArgs();
        System.out.println("=======before====>");
        StringUtil.printObject(objs);
        System.out.println("<===args====before====>");
    }

    @After("pointCut()")
    public void after(JoinPoint joinPoint){
        System.out.println("=======after====>");
    }

    @AfterReturning("pointCut()")
    public Object afterReturning(JoinPoint joinPoint){
        System.out.println("=======afterReturning====>");
        return joinPoint;
    }
}
