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
        try {
            System.out.println("====>aspect around  start ....");
            Object[] args = pjp.getArgs();
            StringUtil.printObject(args);
            System.out.println("====>aspect around function start ....");
            Object proceed = pjp.proceed();
            System.out.println("====>aspect around function end !!!");
            StringUtil.printObject(proceed);
            System.out.println("====>aspect around  end !!!");
            return proceed;
        } catch (Throwable e) {
            System.out.println("====>aspect around one error !!!");
        }
        return null;
    }

    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {
        System.out.println("=======before====>");
        Object[] objs = joinPoint.getArgs();
        StringUtil.printObject(objs);
        System.out.println("<===args====before====>");
    }

    @After("pointCut()")
    public void after(JoinPoint joinPoint) {
        System.out.println("=======after====>");
        Object[] args = joinPoint.getArgs();
        StringUtil.printObject(args);
        System.out.println("=======after====>");
    }

    @AfterReturning(value = "pointCut()", returning = "obj")
    public Object afterReturning(JoinPoint joinPoint, Object obj) {
        System.out.println("=======afterReturning====>");
        Object[] args = joinPoint.getArgs();
        StringUtil.printObject(args);
        StringUtil.printObject(obj);
        System.out.println("=======afterReturning====>");
        return joinPoint;
    }
}
