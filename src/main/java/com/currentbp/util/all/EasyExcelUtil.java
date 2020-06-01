package com.currentbp.util.all;


import com.currentbp.common.model.Student;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static com.currentbp.util.all.ExcelUtil.setSource2Excel;

/**
 * 阿里巴巴excel
 *
 * @author baopan
 * @createTime 20200601
 */
public class EasyExcelUtil<T> {

    private static int SHEET_MAX_ROW = 65000;

/*
使用前注意：需要对应的jar包(alibaba下的)
 */


    public void t2(){

    }


    //=================         test function         ===========================//

    @Test
    public void t1() {
        List<Student> students = Lists.newArrayList(new Student(1, "bp1"),
                new Student(2, "bp2"),
                new Student(3, "bp3"));
        setSource2Excel("student", students);

    }

    //===========       private function         =================//

    /**
     * 获取该类下的所有属性作为excel的表头
     */
    private static <T> List<String> getTitles(Class<?> tClass, T target) {
        Field[] allFields = tClass.getDeclaredFields();
        List<String> titles = new ArrayList<>(allFields.length);
        for (Field field : allFields) {
            titles.add(field.getName());
        }
        return titles;
    }

    /**
     * 获取对应属性的值
     */
    private static <T> String getFieldValue(Class<?> tClass, T target, String fieldName) {
        try {
            Field declaredField = tClass.getDeclaredField(fieldName);
            declaredField.setAccessible(true);
            Object o = declaredField.get(target);
            return o.toString();
        } catch (Exception e) {
            StringUtil.printObject(e.getMessage());
            return "";
        }
    }
}
