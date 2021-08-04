package com.currentbp.test.reflection;

import com.currentbp.common.model.*;
import com.currentbp.util.all.StringUtil;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author baopan
 * @createTime 20210802
 */
public class FatherReflectionTest {

    @Test
    public void fatherClassReflection() throws  Exception{
        Human human = new Persion();
        Field[] declaredFields = human.getClass().getDeclaredFields();
        StringUtil.printObject(declaredFields);
        for (int i = 0; i < declaredFields.length; i++) {
            Field declaredField = declaredFields[i];
            StringUtil.printObject("field:"+declaredField.getName()+" :"+isBaseType(declaredField));
            declaredField.setAccessible(true);
            if(declaredField.getName().equals("id")) {
                declaredField.set(human, 22);
            }
            if(declaredField.getName().equals("name")){
                declaredField.set(human,"name22222");
            }
        }
        StringUtil.printObject(human);
    }


    @Test
    public void fatherAndFatherReflection() throws Exception{
        Student student = new Student();
        Field[] declaredFields = student.getClass().getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            Field declaredField = declaredFields[i];
            declaredField.setAccessible(true);
            StringUtil.printObject("field:"+declaredField.getName()+" :"+isBaseType(declaredField));
            if(declaredField.getName().equals("teachers")){
                System.out.println("=====>field :teachers "+declaredField.getClass());
                Type genericType = declaredField.getGenericType();
                ParameterizedType pt = (ParameterizedType) genericType;
                Type[] types = pt.getActualTypeArguments();

                System.out.println("====> type:"+types[0].getTypeName());

                Class<?> aClass = Class.forName(types[0].getTypeName());
                Object o = aClass.newInstance();


                String typeName = genericType.getTypeName();
                if(genericType instanceof List){
                    System.out.println("is list");
                }else {
                    System.out.println("is not list"+typeName);
                }
            }
        }
    }

    private boolean isBaseType(Field declaredField) {
        String typeName = declaredField.getType().getName();
        if (typeName.equals("java.lang.String")
                || typeName.equals("java.lang.Long")
                || typeName.equals("java.lang.Integer")
                || typeName.equals("java.lang.Boolean")) {
            return true;
        }
        return false;
    }

}
