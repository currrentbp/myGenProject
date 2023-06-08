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

        if(method.getName().equals("getOneStudent")){
            int arg = (Integer)args[0];
            Student result = new Student();
            result.setId(arg);
            return result;
        }
        if(method.getName().equals("createStudent")){
            Student result = (Student)args[0];
            result.setId(2);
            return result.getId();
        }

        if (Object.class.equals(method.getDeclaringClass())) {
            return method.invoke(this, args);
        }
        StringUtil.printObject(args);
        System.out.println("调用前，参数：{}" + args);

        return 1;
    }
}