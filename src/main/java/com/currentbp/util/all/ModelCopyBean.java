package com.currentbp.util.all;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author baopan
 * @createTime 20190125
 */
public class ModelCopyBean {

    /**
     * 类和类之间属性复制，必须存在get和set方法的属性才可以复制
     *
     * @param source 源对象
     * @param target 目标对象
     * @return
     */
    public static void copy(Object source, Object target) {
        Field[] fields = source.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            copyField(source, target, fields[i]);
        }
    }

    private static void copyField(Object source, Object target, Field field) {
        String fieldName = null;
        String getFieldName = null;
        String setFieldName = null;
        Object value = null;
        try {
            fieldName = field.getName();
            String mFieldName = fieldName.replaceFirst(fieldName.substring(0, 1), fieldName.substring(0, 1).toUpperCase());
            getFieldName = "get" + mFieldName;
            Method getMethod = source.getClass().getMethod(getFieldName, new Class[]{});
            value = getMethod.invoke(source, new Object[]{});
            if (value == null) {
                return;
            }
            setFieldName = "set" + mFieldName;
            Method setMethod = getMethod(target, setFieldName);
            if (setMethod == null) {
                return;
            }
            setMethod.invoke(target, new Object[]{value});
        } catch (Exception e) {
        }
    }

    private static Method getMethod(Object target, String setFieldName) {
        Method method = null;
        Method[] methods = target.getClass().getMethods();
        for (int i = 0; i < methods.length; i++) {
            method = methods[i];
            if (method.getName().equals(setFieldName)) {
                return method;
            }
        }
        return null;
    }
}
