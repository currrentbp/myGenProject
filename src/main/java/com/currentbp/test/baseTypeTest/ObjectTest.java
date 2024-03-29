package com.currentbp.test.baseTypeTest;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.currentbp.common.model.Student;
import com.currentbp.util.all.StringUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author current_bp
 * @createTime 20170913
 */
public class ObjectTest {
    private final static Logger logger = LoggerFactory.getLogger(ObjectTest.class);

    @Test
    public void optional(){
        Long sevenDay =  60 * 1000L;
        System.out.println(sevenDay);
        Student student = new Student();
        Optional.ofNullable(student).filter(x->x.getId()== null).map(x->{x.setId(1);return x;});
        StringUtil.printObject(student);
    }


    @Test
    public void t2(){
        Object student1 = new Student();
        Object students = new ArrayList<Student>();
        System.out.println(student1.getClass());
        System.out.println(students.getClass());

        if(student1 instanceof Student){
            System.out.println("+++++++++++++++");
        }else{
            System.out.println("----------------");
        }
        if(students instanceof List){
            System.out.println("+++++++++++++++");
        }
        if(students instanceof ArrayList){
            System.out.println("+++++++++++++++===============");
        }else {
            System.out.println("---------------");
        }
        student1 = null;
        if(student1 instanceof Student){
            System.out.println("+++++++++++++++");
        }else{
            System.out.println("----------------");
        }
    }

    @Test
    public void t1(){
        String source = "{\"name\":\"baopan\",\"desc\":\"baopan desc\"}";
        JSONObject json = JSON.parseObject(source);
        String name = json.getString("name");
        String desc = json.getString("desc");
        String sss = json.getString("sss");
        System.out.println(name+" "+desc+" ==>"+sss);
    }

    /**
     * 关于复杂赋值问题
     */
    @Test
    public void objectRevalue() {
        Integer i = 1;
        Integer j = 2;
        Integer k = 3;
        k = j = i;
        logger.info("===>k:" + k + " j:" + j + " i:" + i);
    }
}
