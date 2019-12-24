package com.currentbp.test;

import com.currentbp.common.model.Student;
import com.currentbp.util.all.ListUtil;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * 测试代码，一个无法归类的。。。
 *
 * @author current_bp
 * @createTime 20161223
 */
public class Test1 {
    public Integer x;

    private final static Logger logger = LoggerFactory.getLogger(Test1.class);

    @Test
    public void t5(){
        Map<Integer,Integer> map = new HashMap<>();
        Integer integer = map.get(null);
        System.out.println(integer);
    }

    @Test
    public void t4(){
        Method[] methods = Student.class.getMethods();
        for (Method method : methods) {
            System.out.println("methodName:"+method.getName()+" declaringClass:"+method.getDeclaringClass()
            +" modifier:"+method.getModifiers()
            );
        }
    }
    @Test
    public void t3(){
        Class<? extends Test1> aClass = this.getClass();
        Field[] fields = aClass.getFields();
        for (Field field : fields) {
            System.out.println("fieldName:"+field.getName()+" is Pri:"+field.getType().isPrimitive());
        }
    }

    @Test
    public void t2(){
        List<Integer> l1 = Lists.newArrayList(1,2);
        List<Integer> list = l1.stream().filter(id -> !id.equals(null)).collect(Collectors.toList());
        ListUtil.printList(list);
    }
    @Test
    public void test11() {
        System.out.println("======");
    }

    @Test
    public void t1() {
        int count = 0;
        for (count++;
             count++ < 10;
             count++) {
            System.out.println("count:" + count);
        }
        System.out.println(count);
    }

    /**
     * 专门测试关于版本号的正则表达式
     */
    @Test
    public void zhengzeTest() {
        String zz = "^(\\d+\\.)*\\d+$";
        Pattern pattern = Pattern.compile(zz);
        Matcher matcher = pattern.matcher("1.1.1");
        Assert.assertTrue(matcher.find());
        Matcher matcher2 = pattern.matcher("1");
        Assert.assertTrue(matcher2.find());
        Matcher matcher3 = pattern.matcher("1.0");
        Assert.assertTrue(matcher3.find());
        Matcher matcher4 = pattern.matcher("1.2");
        Assert.assertTrue(matcher4.find());
        Matcher matcher5 = pattern.matcher("1.9");
        Assert.assertTrue(matcher5.find());

    }
}
