package com.currentbp.test.spring.aop.jdkProxy;

import com.currentbp.common.model.Student;
import com.currentbp.util.all.StringUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author baopan
 * @createTime 2023/5/31 15:23
 */
public class OnlyInterfaceProxy implements InvocationHandler {


    public OnlyInterfaceProxy() {

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        if (Object.class.equals(method.getDeclaringClass())) {
//            return method.invoke(this, args);
//        }
        StringUtil.printObject(args);
        System.out.println("调用前，参数：{}" + args);
        //这里可以得到参数数组和方法等，可以通过反射，注解等，进行结果集的处理
        //mybatis就是在这里获取参数和相关注解，然后根据返回值类型，进行结果集的转换
        int arg = (Integer)args[0];
        Student result = new Student();
        result.setId(arg);
        return result;
    }
}