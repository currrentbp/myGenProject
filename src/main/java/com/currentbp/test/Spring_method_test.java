package com.currentbp.test;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.util.StringUtils;

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

    @Test
    public void tokenizeToStringArray(){
        //类似分隔符
        String s = "1;,; 2;,; 3";
        String[] result = StringUtils.tokenizeToStringArray(s, ",; ");
        System.out.println("===>result:"+ JSON.toJSONString(result));
        String[] result2 = StringUtils.tokenizeToStringArray(s, ";");
        System.out.println("===>result:"+ JSON.toJSONString(result2));
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
