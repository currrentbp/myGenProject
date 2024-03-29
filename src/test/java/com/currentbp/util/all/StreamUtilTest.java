package com.currentbp.util.all;

import com.alibaba.fastjson2.JSON;
import org.junit.Test;

import java.io.FileWriter;

/**
 * 流测试类
 *
 * @author current_bp
 * @createTime 20170503
 */
public class StreamUtilTest {


    @Test
    public void writeSomethingToFile() throws Exception {
        StreamUtil.writeSomethingToFile("baopan\n","baopan1.txt");
        StreamUtil.writeSomethingToFile("baopan2","baopan1.txt",true);
    }

    @Test
    public void createMyFile() throws Exception {
        Assert.notNull(StreamUtil.createMyFile("baopan.txt",true),"");
        Assert.notNull(StreamUtil.createMyFile("/home/currentbp/baopan.txt",false),"");
    }

    @Test
    public void createMyFile2() throws Exception {
        FileWriter fileWriter = StreamUtil.createFileWriter("/daletou/daletou_history.txt", true, false);
        Assert.notNull(fileWriter,"sssssssssss");
        fileWriter.write("baopan");
        fileWriter.flush();
        fileWriter.close();
    }

    @Test
    public void test_isFile() {
        Assert.isTrue(StreamUtil.isFile("/daletou/config.properties"), "bushi yige wenjian");
    }
    @Test
    public void test_isFile2() {
        Assert.isTrue(StreamUtil.isFile("/daletou/config.properties",false), "bushi yige wenjian");
    }
    @Test
    public void createFileWriter() throws Exception {
        FileWriter fileWriter = StreamUtil.createFileWriter("/daletou/daletou_history.txt");
        Assert.notNull(fileWriter,"is null");
    }

}