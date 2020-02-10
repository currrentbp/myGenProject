package com.currentbp.util.all;

import com.currentbp.common.model.Student;
import org.apache.poi.hssf.usermodel.*;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * excel
 * @author baopan
 * @createTime 2020/2/9 21:26
 */
public class ExcelUtil<T> {

/*
使用前注意：需要对应的jar包(org.apache.poi下的)
 */


    /**
     * 通过类对象获取一个对应的excel
     */
    public static <T> void setSource2Excel2(String excelName, List<Map<String,String>> source){
        if(null == source || 0 == source.size()){
            return;
        }
        Map<String, String> firstMap = source.get(0);
        List<String> titles = Lists.newArrayList(firstMap.keySet());

        //创建文件
        File file = new File(""+excelName+".xls");
        StringUtil.printObject("===>path"+file.getAbsolutePath());
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);
        } catch (Exception e) {
        }

        // 第一步，创建一个HSSFWorkbook，对应一个Excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        // 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet(excelName);
        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制
        HSSFRow row = sheet.createRow(0);

        //声明列对象
        HSSFCell cell = null;
        //创建标题
        for(int i=0;i<titles.size();i++){
            cell = row.createCell(i);
            cell.setCellValue(titles.get(i));
            cell.setCellStyle(style);
        }
        //创建内容
        for(int i=0;i<source.size();i++){
            row = sheet.createRow(i + 1);
            Map<String,String> key2ValueMap = source.get(i);
            for(int j=0;j<titles.size();j++){
                //将内容按顺序赋给对应的列对象
                String value = key2ValueMap.get(titles.get(j));
                row.createCell(j).setCellValue(value);
            }
        }

        wb.setActiveSheet(0);
        try {
            wb.write(outputStream);
            outputStream.close();
        }catch (Exception e){
        }

    }

    /**
     * 通过类对象获取一个对应的excel
     */
    public static <T> void setSource2Excel(String excelName, List<T> source){
        if(null == source || 0 == source.size()){
            return;
        }
        T target = source.get(0);
        Class<?> tClass = target.getClass();
        List<String> titles = getTitles(tClass,target);

        //创建文件
        File file = new File(""+excelName+".xls");
        StringUtil.printObject("===>path"+file.getAbsolutePath());
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);
        } catch (Exception e) {
        }

        // 第一步，创建一个HSSFWorkbook，对应一个Excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        // 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet(excelName);
        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制
        HSSFRow row = sheet.createRow(0);

        //声明列对象
        HSSFCell cell = null;
        //创建标题
        for(int i=0;i<titles.size();i++){
            cell = row.createCell(i);
            cell.setCellValue(titles.get(i));
            cell.setCellStyle(style);
        }
        //创建内容
        for(int i=0;i<source.size();i++){
            row = sheet.createRow(i + 1);
            T eTarget = source.get(i);
            for(int j=0;j<titles.size();j++){
                //将内容按顺序赋给对应的列对象
                String fieldValue = getFieldValue(tClass, eTarget, titles.get(j));
                row.createCell(j).setCellValue(fieldValue);
            }
        }

        wb.setActiveSheet(0);
        try {
            wb.write(outputStream);
            outputStream.close();
        }catch (Exception e){
        }

    }


    //=================         test function         ===========================//

    @Test
    public void t1(){
        List<Student> students = Lists.newArrayList(new Student(1, "bp1"),
                new Student(2, "bp2"),
                new Student(3, "bp3"));
        setSource2Excel("student", students);

    }

    //===========       private function         =================//

    /**
     * 获取该类下的所有属性作为excel的表头
     */
    private static  <T> List<String> getTitles(Class<?> tClass, T target){
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
    private static <T> String getFieldValue(Class<?> tClass,T target,String fieldName){
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
