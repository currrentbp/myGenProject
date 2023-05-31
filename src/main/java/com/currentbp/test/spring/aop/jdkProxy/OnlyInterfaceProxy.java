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
        int arg = (Integer)args[0];
        Student result = new Student();
        result.setId(arg);

        if (Object.class.equals(method.getDeclaringClass())) {
            return method.invoke(this, args);
        }
        StringUtil.printObject(args);
        System.out.println("调用前，参数：{}" + args);

        return result;
    }
}