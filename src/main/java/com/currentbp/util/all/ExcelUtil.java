package com.currentbp.util.all;

import com.alibaba.fastjson.JSON;
import com.currentbp.common.model.Student;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections4.ListUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.usermodel.examples.CellTypes;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.io.*;
import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * excel
 *
 * @author baopan
 * @createTime 2020/2/9 21:26
 */
public class ExcelUtil<T> {

    private static int SHEET_MAX_ROW = 65000;

/*
使用前注意：需要对应的jar包(org.apache.poi下的)
 */


    /**
     * 通过map数据集合获取excel
     */
    public static <T> void setSource2Excel2(String excelName, List<Map<String, String>> source) {
        setSource2Excel2(excelName, source, null);
    }

    /**
     * 通过map数据集合获取指定排序方式的excel
     * 如果列表长度过长，则分开放入sheet中
     * 使用多个流操作
     */
    public static <T> void setSource2Excel4(String excelName, List<Map<String, String>> source, List<String> sortWith) {
        if (null == source || 0 == source.size()) {
            return;
        }
        Map<String, String> firstMap = source.get(0);
        List<String> titles = Lists.newArrayList(firstMap.keySet());
        if (!CollectionUtils.isEmpty(sortWith)) {
            titles = sortWith;
        }

        List<List<Map<String, String>>> partition = ListUtils.partition(source, SHEET_MAX_ROW);//TODO to linkedList

        createSheets(excelName, partition.size(), titles);

        int index = 0;
        for (List<Map<String, String>> maps : partition) {
            doSetEachSheet(excelName, maps, titles, index);
            index++;
        }
    }


    /**
     * 通过map数据集合获取指定排序方式的excel
     * 如果列表长度过长，则分开放入sheet中
     */
    public static <T> void setSource2Excel3(String excelName, List<Map<String, String>> source, List<String> sortWith) {
        if (null == source || 0 == source.size()) {
            return;
        }
        Map<String, String> firstMap = source.get(0);
        List<String> titles = Lists.newArrayList(firstMap.keySet());
        if (!CollectionUtils.isEmpty(sortWith)) {
            titles = sortWith;
        }

        //创建文件
        File file = new File("" + excelName + ".xls");
        StringUtil.printObject("===>path" + file.getAbsolutePath());
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);
        } catch (Exception e) {
        }

        // 第一步，创建一个HSSFWorkbook，对应一个Excel文件
        HSSFWorkbook wb = new HSSFWorkbook();

        List<List<Map<String, String>>> partition = ListUtils.partition(source, SHEET_MAX_ROW);
        for (int index = 0; index < partition.size(); index++) {
            // 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
            HSSFSheet sheet = wb.createSheet(excelName + "_" + index);
        }
        HSSFSheet sheetAt = wb.getSheetAt(1);
        HSSFSheet sheetAt2 = wb.getSheetAt(2);
        System.out.println("===>name:" + sheetAt.getSheetName() + " name2:" + sheetAt2.getSheetName());

        for (int index = 0; index < partition.size(); index++) {
            // 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
//            HSSFSheet sheet = wb.createSheet(excelName + "_" + index);
            HSSFSheet sheet = wb.getSheetAt(index);
            wb.setActiveSheet(index);
            // 第四步，创建单元格，并设置值表头 设置表头居中
            HSSFCellStyle style = wb.createCellStyle();
//            style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
            // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制
            HSSFRow row = sheet.createRow(0);

            //声明列对象
            HSSFCell cell = null;
            //创建标题
            for (int i = 0; i < titles.size(); i++) {
                cell = row.createCell(i);
                cell.setCellValue(titles.get(i));
                cell.setCellStyle(style);
            }
            List<Map<String, String>> partitionSources = partition.get(index);
            //创建内容
            for (int i = 0; i < partitionSources.size(); i++) {
                row = sheet.createRow(i + 1);
                Map<String, String> key2ValueMap = partitionSources.get(i);
                for (int j = 0; j < titles.size(); j++) {
                    //将内容按顺序赋给对应的列对象
                    String value = key2ValueMap.get(titles.get(j));
                    row.createCell(j).setCellValue(value);
                }
            }

        }
        try {
            wb.write(outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    /**
     * 通过map数据集合获取指定排序方式的excel
     */
    public static <T> void setSource2Excel2(String excelName, List<Map<String, String>> source, List<String> sortWith) {
        if (null == source || 0 == source.size()) {
            return;
        }
        System.out.println("===>source's size:"+source.size());
        Map<String, String> firstMap = source.get(0);
        List<String> titles = Lists.newArrayList(firstMap.keySet());
        if (!CollectionUtils.isEmpty(sortWith)) {
            titles = sortWith;
        }

        //创建文件
        File file = new File("" + excelName + ".xls");
        StringUtil.printObject("===>path" + file.getAbsolutePath());
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
//        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制
        HSSFRow row = sheet.createRow(0);

        //声明列对象
        HSSFCell cell = null;
        //创建标题
        for (int i = 0; i < titles.size(); i++) {
            cell = row.createCell(i);
            cell.setCellValue(titles.get(i));
            cell.setCellStyle(style);
        }
        //创建内容
        for (int i = 0; i < source.size(); i++) {
            row = sheet.createRow(i + 1);
            Map<String, String> key2ValueMap = source.get(i);
            for (int j = 0; j < titles.size(); j++) {
                //将内容按顺序赋给对应的列对象
                String value = key2ValueMap.get(titles.get(j));
                row.createCell(j).setCellValue(value);
            }
        }

        wb.setActiveSheet(0);
        try {
            wb.write(outputStream);
            outputStream.close();
        } catch (Exception e) {
        }

    }

    /**
     * 通过类对象获取一个对应的excel
     */
    public static <T> void setSource2Excel(String excelName, List<T> source) {
        if (null == source || 0 == source.size()) {
            return;
        }
        T target = source.get(0);
        Class<?> tClass = target.getClass();
        List<String> titles = getTitles(tClass, target);

        //创建文件
        File file = new File("" + excelName + ".xls");
        StringUtil.printObject("===>path" + file.getAbsolutePath());
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
//        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制
        HSSFRow row = sheet.createRow(0);

        //声明列对象
        HSSFCell cell = null;
        //创建标题
        for (int i = 0; i < titles.size(); i++) {
            cell = row.createCell(i);
            cell.setCellValue(titles.get(i));
            cell.setCellStyle(style);
        }
        //创建内容
        for (int i = 0; i < source.size(); i++) {
            row = sheet.createRow(i + 1);
            T eTarget = source.get(i);
            for (int j = 0; j < titles.size(); j++) {
                //将内容按顺序赋给对应的列对象
                String fieldValue = getFieldValue(tClass, eTarget, titles.get(j));
                row.createCell(j).setCellValue(fieldValue);
            }
        }

        wb.setActiveSheet(0);
        try {
            wb.write(outputStream);
            outputStream.close();
        } catch (Exception e) {
        }

    }

    @Test
    public void getFinancialSourcesTest() {
        long startTime = System.currentTimeMillis();
        List<Map<String, String>> sourceFromExcel = ExcelUtil.getSourceFromExcel("1",
                Lists.newArrayList("financialOrderId", "financialDetailId", "financialIncomeType", "financialIncomeTime",
                        "financialAidou", "financialGiftAidou", "financialRmb", "financialTotal", "financialStatus", "financialText", "financialStatus2"));
        long endTime = System.currentTimeMillis();
        System.out.println("===>getFinancial's source used time:" + (endTime - startTime) / 1000);
        System.out.println(JSON.toJSONString(sourceFromExcel));
    }

    /**
     * 获取excel的数据
     *
     * @param excelFile
     * @param titles
     * @return
     */
    public static List<Map<String, String>> getSourceFromExcel(String excelFile, List<String> titles) {
        long startTime = System.currentTimeMillis();
        List<Map<String, String>> result = new ArrayList<>();
/*
if (".xls".equals(extString)) {
				wb = new HSSFWorkbook(is);
			} else if (".xlsx".equals(extString)) {
				wb = new XSSFWorkbook(is);
			} else {
				wb = null;
			}
 */
        //创建文件
        File file = new File("" + excelFile + ".xlsx");
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        StringUtil.printObject("===>path" + file.getAbsolutePath());

        // 第一步，创建一个HSSFWorkbook，对应一个Excel文件
        Workbook wb = null;
        try {
            wb = new XSSFWorkbook(fileInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Sheet sheetAt = wb.getSheetAt(0);
        System.out.println("sheetName:" + sheetAt.getSheetName());
        int endNum = sheetAt.getPhysicalNumberOfRows();

        System.out.println("sheet's row's num:" + endNum);
        DecimalFormat df = new DecimalFormat("0");//格式化number String字符串
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//日期格式
        for (int i = 1; i < endNum; i++) {
            Row row = sheetAt.getRow(i);
            if (null == row) {
                continue;
            }

            Map<String, String> temp = new HashMap<>(titles.size());
            for (int index = 0; index < titles.size(); index++) {
                try {
                    Cell cell = row.getCell(index);
                    if (null == cell) {
                        temp.put(titles.get(index), "");
                        break;
                    }
                    int cellType = cell.getCellType();
                    String value = "";
                    try {
                        switch (cellType) {
                            case Cell.CELL_TYPE_STRING:
                                value = cell.getRichStringCellValue().getString();
                                break;
                            case Cell.CELL_TYPE_NUMERIC:
                                if ("General".equals(cell.getCellStyle().getDataFormatString())) {
                                    value = df.format(cell.getNumericCellValue());
                                } else if ("m/d/yy".equals(cell.getCellStyle().getDataFormatString())) {
                                    value = sdf.format(cell.getDateCellValue());
                                } else {
                                    value = ((Double)cell.getNumericCellValue()).toString();
                                }
                                break;
                            case Cell.CELL_TYPE_BLANK:
                                value = "";
                                break;
                            default:
                                System.out.println("===>单元格的内容是其他格式,i:" + i + " index:" + index);
                                break;
                        }
                    } catch (Exception e1) {

                    }
                    temp.put(titles.get(index), value);
                } catch (Exception e) {
                    System.out.println("===>i:" + i + " index:" + index);
                    e.printStackTrace();
                }
            }
            if (0 != temp.size()) {
                result.add(temp);
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("===>read excel used time:" + (endTime - startTime) / 1000);
        return result;
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

    private static void createSheets(String excelName, int size, List<String> titles) {
        //创建文件
        File file = new File("" + excelName + ".xls");
        StringUtil.printObject("===>path" + file.getAbsolutePath());
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);
        } catch (Exception e) {
        }

        // 第一步，创建一个HSSFWorkbook，对应一个Excel文件
        HSSFWorkbook wb = new HSSFWorkbook();


        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
//        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

        for (int index = 0; index < size; index++) {
            // 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
            HSSFSheet sheet = wb.createSheet(excelName + "_" + index);
            wb.setActiveSheet(index);
            // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制
            HSSFRow row = sheet.createRow(0);

            //声明列对象
            HSSFCell cell = null;
            //创建标题
            for (int i = 0; i < titles.size(); i++) {
                cell = row.createCell(i);
                cell.setCellValue(titles.get(i));
                cell.setCellStyle(style);
            }
        }


        try {
            wb.write(outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void doSetEachSheet(String excelName, List<Map<String, String>> parrtions, List<String> titles, int index) {

        //创建文件
        File file = new File("" + excelName + ".xls");
        FileInputStream fileInputStream = null;
        POIFSFileSystem poifsFileSystem = null;
        try {
            fileInputStream = new FileInputStream(file);
            poifsFileSystem = new POIFSFileSystem(fileInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        StringUtil.printObject("===>path" + file.getAbsolutePath());
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 第一步，创建一个HSSFWorkbook，对应一个Excel文件
        HSSFWorkbook wb = null;
        try {
            wb = new HSSFWorkbook(poifsFileSystem);
        } catch (Exception e) {
            e.printStackTrace();
        }


        // 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
//            HSSFSheet sheet = wb.createSheet(excelName + "_" + index);
        wb.setActiveSheet(index);
        HSSFSheet sheet = wb.getSheetAt(index);
        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
//        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制
        HSSFRow row = null;

        //声明列对象
        HSSFCell cell = null;

        //创建内容
        for (int i = 0; i < parrtions.size(); i++) {
            row = sheet.createRow(i + 1);
            Map<String, String> key2ValueMap = parrtions.get(i);
            for (int j = 0; j < titles.size(); j++) {
                //将内容按顺序赋给对应的列对象
                String value = key2ValueMap.get(titles.get(j));
                row.createCell(j).setCellValue(value);
            }
        }

        try {
            wb.write(outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.gc();
    }
}
