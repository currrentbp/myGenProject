package com.bp.test;

import org.junit.Test;

/**
 * 关于spring 的一些方法的测试
 * @author current_bp
 * @createTime 20170306
 */
public class Spring_method_test {

    public static void main(String[] args){
        Spring_method_test smt = new Spring_method_test();

        //测试
        smt.BeanFactoryUtils();

    }

    public void BeanFactoryUtils(){
        String name = "&name";
        String beanName;
        for(beanName = name; beanName.startsWith("&"); beanName = beanName.substring("&".length())) {
            ;
        }
        System.out.println("beanName:"+beanName+" name:"+name);
    }


    @Test
    public void foreach(){
        String name = "&123";
        String beanName = "";
        for(beanName = name; beanName.startsWith("&"); beanName = beanName.substring("&".length())) {
            ;
        }
    }

    @Test
    public void stringUtilsHasText(){
        String profileSpec =  "123";
        //org.springframework.util
//        StringUtils.hasText(profileSpec);
    }
}
