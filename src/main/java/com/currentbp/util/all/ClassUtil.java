package com.currentbp.util.all;

import com.currentbp.common.model.Student;
import org.junit.Test;

import java.lang.reflect.Field;

/**
 * 专门用于解析class的
 * @author baopan
 * @createTime 20210430
 */
public class ClassUtil {

    public static Object getValue(Object obj, String fieldName){
        try {
            Class<?> aClass = obj.getClass();
            Field idField = aClass.getDeclaredField(fieldName);
            idField.setAccessible(true);
            Object o = idField.get(obj);
            return o;
        }catch (Exception e){
            System.out.println("");
        }
        return null;
    }

    @Test
    public void t1(){
        try {
            Student student = new Student(2, "11111");
            Object obj = student;
            Object id = getValue(student, "id");
            System.out.println("===>id:" + id.toString());
        }catch (Exception e){
            System.out.println("===>msg:"+e.getMessage());
        }
    }
}
