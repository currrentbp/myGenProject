package com.currentbp.util.all;


import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.exception.ExcelDataConvertException;
import com.alibaba.excel.write.handler.WriteHandler;
import com.alibaba.fastjson2.JSON;
import org.apache.poi.ss.formula.functions.T;
import org.assertj.core.util.Lists;
import org.junit.Test;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 阿里巴巴excel
 *
 * @author baopan
 * @createTime 20200601
 */
public class EasyExcelUtil {



/*
使用前注意：需要对应的jar包(alibaba下的)
 */




    /**
     * 同步无模型读（默认读取sheet0,从第2行开始读）
     * @param filePath
     * @return
     */
    public static List<Map<Integer, String>> syncRead(String filePath){
        return EasyExcelFactory.read(filePath).sheet().doReadSync();
    }

    /**
     * 同步无模型读（默认表头占一行，从第2行开始读）
     * @param filePath
     * @param sheetNo sheet页号，从0开始
     * @return
     */
    public static List<Map<Integer, String>> syncRead(String filePath, Integer sheetNo){
        return EasyExcelFactory.read(filePath).sheet(sheetNo).doReadSync();
    }

    /**
     * 同步无模型读（指定sheet和表头占的行数）
     * @param inputStream
     * @param sheetNo sheet页号，从0开始
     * @param headRowNum 表头占的行数，从0开始（如果要连表头一起读出来则传0）
     * @return List<Map<colNum, cellValue>>
     */
    public static List<Map<Integer, String>> syncRead(InputStream inputStream, Integer sheetNo, Integer headRowNum){
        return EasyExcelFactory.read(inputStream).sheet(sheetNo).headRowNumber(headRowNum).doReadSync();
    }

    /**
     * 同步无模型读（指定sheet和表头占的行数）
     * @param file
     * @param sheetNo sheet页号，从0开始
     * @param headRowNum 表头占的行数，从0开始（如果要连表头一起读出来则传0）
     * @return List<Map<colNum, cellValue>>
     */
    public static List<Map<Integer, String>> syncRead(File file, Integer sheetNo, Integer headRowNum){
        return EasyExcelFactory.read(file).sheet(sheetNo).headRowNumber(headRowNum).doReadSync();
    }

    /**
     * 同步无模型读（指定sheet和表头占的行数）
     * @param filePath
     * @param sheetNo sheet页号，从0开始
     * @param headRowNum 表头占的行数，从0开始（如果要连表头一起读出来则传0）
     * @return List<Map<colNum, cellValue>>
     */
    public static List<Map<Integer, String>> syncRead(String filePath, Integer sheetNo, Integer headRowNum){
        return EasyExcelFactory.read(filePath).sheet(sheetNo).headRowNumber(headRowNum).doReadSync();
    }

    /**
     * 同步按模型读（默认读取sheet0,从第2行开始读）
     * @param filePath
     * @param clazz 模型的类类型（excel数据会按该类型转换成对象）
     * @return
     */
    public static List<T> syncReadModel(String filePath, Class clazz){
        return EasyExcelFactory.read(filePath).sheet().head(clazz).doReadSync();
    }

    /**
     * 同步按模型读（默认表头占一行，从第2行开始读）
     * @param filePath
     * @param clazz 模型的类类型（excel数据会按该类型转换成对象）
     * @param sheetNo sheet页号，从0开始
     * @return
     */
    public static List<T> syncReadModel(String filePath, Class clazz, Integer sheetNo){
        return EasyExcelFactory.read(filePath).sheet(sheetNo).head(clazz).doReadSync();
    }

    /**
     * 同步按模型读（指定sheet和表头占的行数）
     * @param inputStream
     * @param clazz 模型的类类型（excel数据会按该类型转换成对象）
     * @param sheetNo sheet页号，从0开始
     * @param headRowNum 表头占的行数，从0开始（如果要连表头一起读出来则传0）
     * @return
     */
    public static List<T> syncReadModel(InputStream inputStream, Class clazz, Integer sheetNo, Integer headRowNum){
        return EasyExcelFactory.read(inputStream).sheet(sheetNo).headRowNumber(headRowNum).head(clazz).doReadSync();
    }

    /**
     * 同步按模型读（指定sheet和表头占的行数）
     * @param file
     * @param clazz 模型的类类型（excel数据会按该类型转换成对象）
     * @param sheetNo sheet页号，从0开始
     * @param headRowNum 表头占的行数，从0开始（如果要连表头一起读出来则传0）
     * @return
     */
    public static List<T> syncReadModel(File file, Class clazz, Integer sheetNo, Integer headRowNum){
        return EasyExcelFactory.read(file).sheet(sheetNo).headRowNumber(headRowNum).head(clazz).doReadSync();
    }

    /**
     * 同步按模型读（指定sheet和表头占的行数）
     * @param filePath
     * @param clazz 模型的类类型（excel数据会按该类型转换成对象）
     * @param sheetNo sheet页号，从0开始
     * @param headRowNum 表头占的行数，从0开始（如果要连表头一起读出来则传0）
     * @return
     */
    public static List<T> syncReadModel(String filePath, Class clazz, Integer sheetNo, Integer headRowNum){
        return EasyExcelFactory.read(filePath).sheet(sheetNo).headRowNumber(headRowNum).head(clazz).doReadSync();
    }

    /**
     * 异步无模型读（默认读取sheet0,从第2行开始读）
     * @param excelListener 监听器，在监听器中可以处理行数据LinkedHashMap，表头数据，异常处理等
     * @param filePath 表头占的行数，从0开始（如果要连表头一起读出来则传0）
     * @return
     */
    public static void asyncRead(String filePath, AnalysisEventListener<T> excelListener){
        EasyExcelFactory.read(filePath, excelListener).sheet().doRead();
    }

    /**
     * 异步无模型读（默认表头占一行，从第2行开始读）
     * @param filePath 表头占的行数，从0开始（如果要连表头一起读出来则传0）
     * @param excelListener 监听器，在监听器中可以处理行数据LinkedHashMap，表头数据，异常处理等
     * @param sheetNo sheet页号，从0开始
     * @return
     */
    public static void asyncRead(String filePath, AnalysisEventListener<T> excelListener, Integer sheetNo){
        EasyExcelFactory.read(filePath, excelListener).sheet(sheetNo).doRead();
    }

    /**
     * 异步无模型读（指定sheet和表头占的行数）
     * @param inputStream
     * @param excelListener 监听器，在监听器中可以处理行数据LinkedHashMap，表头数据，异常处理等
     * @param sheetNo sheet页号，从0开始
     * @param headRowNum 表头占的行数，从0开始（如果要连表头一起读出来则传0）
     * @return
     */
    public static void asyncRead(InputStream inputStream, AnalysisEventListener<T> excelListener, Integer sheetNo, Integer headRowNum){
        EasyExcelFactory.read(inputStream, excelListener).sheet(sheetNo).headRowNumber(headRowNum).doRead();
    }

    /**
     * 异步无模型读（指定sheet和表头占的行数）
     * @param file
     * @param excelListener 监听器，在监听器中可以处理行数据LinkedHashMap，表头数据，异常处理等
     * @param sheetNo sheet页号，从0开始
     * @param headRowNum 表头占的行数，从0开始（如果要连表头一起读出来则传0）
     * @return
     */
    public static void asyncRead(File file, AnalysisEventListener<T> excelListener, Integer sheetNo, Integer headRowNum){
        EasyExcelFactory.read(file, excelListener).sheet(sheetNo).headRowNumber(headRowNum).doRead();
    }

    /**
     * 异步无模型读（指定sheet和表头占的行数）
     * @param filePath
     * @param excelListener 监听器，在监听器中可以处理行数据LinkedHashMap，表头数据，异常处理等
     * @param sheetNo sheet页号，从0开始
     * @param headRowNum 表头占的行数，从0开始（如果要连表头一起读出来则传0）
     * @return
     */
    public static void asyncRead(String filePath, AnalysisEventListener<T> excelListener, Integer sheetNo, Integer headRowNum){
        EasyExcelFactory.read(filePath, excelListener).sheet(sheetNo).headRowNumber(headRowNum).doRead();
    }

    /**
     * 异步按模型读取（默认读取sheet0,从第2行开始读）
     * @param filePath
     * @param excelListener 监听器，在监听器中可以处理行数据LinkedHashMap，表头数据，异常处理等
     * @param clazz 模型的类类型（excel数据会按该类型转换成对象）
     */
    public static void asyncReadModel(String filePath, AnalysisEventListener<T> excelListener, Class clazz){
        EasyExcelFactory.read(filePath, clazz, excelListener).sheet().doRead();
    }

    /**
     * 异步按模型读取（默认表头占一行，从第2行开始读）
     * @param filePath
     * @param excelListener 监听器，在监听器中可以处理行数据LinkedHashMap，表头数据，异常处理等
     * @param clazz 模型的类类型（excel数据会按该类型转换成对象）
     * @param sheetNo  sheet页号，从0开始
     */
    public static void asyncReadModel(String filePath, AnalysisEventListener<T> excelListener, Class clazz, Integer sheetNo){
        EasyExcelFactory.read(filePath, clazz, excelListener).sheet(sheetNo).doRead();
    }

    /**
     * 异步按模型读取
     * @param inputStream
     * @param excelListener 监听器，在监听器中可以处理行数据LinkedHashMap，表头数据，异常处理等
     * @param clazz 模型的类类型（excel数据会按该类型转换成对象）
     * @param sheetNo  sheet页号，从0开始
     * @param headRowNum 表头占的行数，从0开始（如果要连表头一起读出来则传0）
     */
    public static void asyncReadModel(InputStream inputStream, AnalysisEventListener<T> excelListener, Class clazz, Integer sheetNo, Integer headRowNum){
        EasyExcelFactory.read(inputStream, clazz, excelListener).sheet(sheetNo).headRowNumber(headRowNum).doRead();
    }

    /**
     * 异步按模型读取
     * @param file
     * @param excelListener 监听器，在监听器中可以处理行数据LinkedHashMap，表头数据，异常处理等
     * @param clazz 模型的类类型（excel数据会按该类型转换成对象）
     * @param sheetNo  sheet页号，从0开始
     * @param headRowNum 表头占的行数，从0开始（如果要连表头一起读出来则传0）
     */
    public static void asyncReadModel(File file, AnalysisEventListener<T> excelListener, Class clazz, Integer sheetNo, Integer headRowNum){
        EasyExcelFactory.read(file, clazz, excelListener).sheet(sheetNo).headRowNumber(headRowNum).doRead();
    }

    /**
     * 异步按模型读取
     * @param filePath
     * @param excelListener 监听器，在监听器中可以处理行数据LinkedHashMap，表头数据，异常处理等
     * @param clazz 模型的类类型（excel数据会按该类型转换成对象）
     * @param sheetNo  sheet页号，从0开始
     * @param headRowNum 表头占的行数，从0开始（如果要连表头一起读出来则传0）
     */
    public static void asyncReadModel(String filePath, AnalysisEventListener<T> excelListener, Class clazz, Integer sheetNo, Integer headRowNum){
        EasyExcelFactory.read(filePath, clazz, excelListener).sheet(sheetNo).headRowNumber(headRowNum).doRead();
    }

    /**
     * 无模板写文件
     * @param filePath
     * @param head 表头数据
     * @param data 表内容数据
     */
    public static void write(String filePath, List<List<String>> head, List<List<Object>> data){
        EasyExcel.write(filePath).head(head).sheet().doWrite(data);
    }

    /**
     * 无模板写文件
     * @param filePath
     * @param head 表头数据
     * @param data 表内容数据
     * @param sheetNo sheet页号，从0开始
     * @param sheetName sheet名称
     */
    public static void write(String filePath, List<List<String>> head, List<List<Object>> data, Integer sheetNo, String sheetName){
        EasyExcel.write(filePath).head(head).sheet(sheetNo, sheetName).doWrite(data);
    }

    /**
     * 根据excel模板文件写入文件
     * @param filePath
     * @param templateFileName
     * @param headClazz
     * @param data
     */
    public static void writeTemplate(String filePath, String templateFileName, Class headClazz, List data){
        EasyExcel.write(filePath, headClazz).withTemplate(templateFileName).sheet().doWrite(data);
    }

    /**
     * 根据excel模板文件写入文件
     * @param filePath
     * @param templateFileName
     * @param data
     */
    public static void writeTemplate(String filePath, String templateFileName, List data){
        EasyExcel.write(filePath).withTemplate(templateFileName).sheet().doWrite(data);
    }

    /**
     * 按模板写文件
     * @param filePath
     * @param headClazz 表头模板
     * @param data 数据
     */
    public static void write(String filePath, Class headClazz, List data){
        EasyExcel.write(filePath, headClazz).sheet().doWrite(data);
    }

    /**
     * 按模板写文件
     * @param filePath
     * @param headClazz 表头模板
     * @param data 数据
     * @param sheetNo sheet页号，从0开始
     * @param sheetName sheet名称
     */
    public static void write(String filePath, Class headClazz, List data, Integer sheetNo, String sheetName){
        EasyExcel.write(filePath, headClazz).sheet(sheetNo, sheetName).doWrite(data);
    }

    /**
     * 按模板写文件
     * @param filePath
     * @param headClazz 表头模板
     * @param data 数据
     * @param writeHandler 自定义的处理器，比如设置table样式，设置超链接、单元格下拉框等等功能都可以通过这个实现（需要注册多个则自己通过链式去调用）
     * @param sheetNo sheet页号，从0开始
     * @param sheetName sheet名称
     */
    public static void write(String filePath, Class headClazz, List data, WriteHandler writeHandler, Integer sheetNo, String sheetName){
        EasyExcel.write(filePath, headClazz).registerWriteHandler(writeHandler).sheet(sheetNo, sheetName).doWrite(data);
    }

    /**
     * 按模板写文件（包含某些字段）
     * @param filePath
     * @param headClazz 表头模板
     * @param data 数据
     * @param includeCols 过滤包含的字段，根据字段名称过滤
     * @param sheetNo sheet页号，从0开始
     * @param sheetName sheet名称
     */
    public static void writeInclude(String filePath, Class headClazz, List data, Set<String> includeCols, Integer sheetNo, String sheetName){
        EasyExcel.write(filePath, headClazz).includeColumnFiledNames(includeCols).sheet(sheetNo, sheetName).doWrite(data);
    }

    /**
     * 按模板写文件（排除某些字段）
     * @param filePath
     * @param headClazz 表头模板
     * @param data 数据
     * @param excludeCols 过滤排除的字段，根据字段名称过滤
     * @param sheetNo sheet页号，从0开始
     * @param sheetName sheet名称
     */
    public static void writeExclude(String filePath, Class headClazz, List data, Set<String> excludeCols, Integer sheetNo, String sheetName){
        EasyExcel.write(filePath, headClazz).excludeColumnFiledNames(excludeCols).sheet(sheetNo, sheetName).doWrite(data);
    }










    //=================         test function         ===========================//

    @Test
    public void t2() {
        long startTime = System.currentTimeMillis();
        List<Map<Integer, String>> sources = syncRead("financialSources.xlsx", 0, 1);
        long readEndTime = System.currentTimeMillis();
        System.out.println("===>read excel used time:"+(readEndTime-startTime)/1000);
        System.out.println(JSON.toJSONString(sources.get(0)));
        System.out.println(JSON.toJSONString(sources.get(2)));
        System.out.println(JSON.toJSONString(sources.get(466140)));

        List<List<String>> titles = new ArrayList<>();
        titles.add(Lists.newArrayList("订单号"));
        titles.add(Lists.newArrayList("详情id"));
        titles.add(Lists.newArrayList("收入类型编码"));
        titles.add(Lists.newArrayList("收入时间"));
        titles.add(Lists.newArrayList("爱豆"));
        titles.add(Lists.newArrayList("赠送爱豆"));
        titles.add(Lists.newArrayList("人民币"));
        titles.add(Lists.newArrayList("总额"));
        titles.add(Lists.newArrayList("收入状态"));
        titles.add(Lists.newArrayList("收入时间文本"));
        titles.add(Lists.newArrayList("状态-2确收时间"));

        List<List<Object>> contents = new ArrayList<>(sources.size());
        for (Map<Integer, String> source : sources) {
            List<Object> eachs = new ArrayList<>(12);
            for(int i=0;i<12;i++){
                eachs.add(i,source.getOrDefault(i,""));
            }
            contents.add(eachs);
        }
        long startTime1 = System.currentTimeMillis();
        write("newFinancialSources.xlsx",titles,contents);
        long writeEndTime = System.currentTimeMillis();
        System.out.println("===>write excel used time:"+(writeEndTime-startTime1)/1000);

    }


    //===========       private function         =================//


}
