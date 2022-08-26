package com.currentbp.test.baseTypeTest;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

import com.currentbp.common.model.Student;
import com.currentbp.util.all.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;


public class StringTest {
    private final static Logger logger = LoggerFactory.getLogger(StringTest.class);

    public List<String> l1 = new ArrayList<String>();
    public List<String> l2 = new ArrayList<String>();

    @Test
    public void stringUtilsEqual() {
        System.out.println(StringUtils.equals("baopan", "baopan"));
        System.out.println(StringUtils.equals(null, "baopan"));
        System.out.println(StringUtils.equals("baopan", null));
        System.out.println(StringUtils.equals(null, null));
        System.out.println(StringUtils.equals("baopan", "baopan1"));
    }

    @Test
    public void test1() {
        System.out.println(StringUtils.endsWithIgnoreCase("ES", "es"));
        System.out.println(StringUtils.endsWithIgnoreCase("ES", "es_1"));
        System.out.println(StringUtils.endsWithIgnoreCase("ES", "2_es"));
        System.out.println(StringUtils.endsWithIgnoreCase("1ES", "es"));
        System.out.println(StringUtils.endsWithIgnoreCase("ES2", "es"));
    }

    @Test
    public void format() {
        DecimalFormat decimalFormat = new DecimalFormat("##.##%");
        String format = decimalFormat.format((float) 10 / (float) 11);
        System.out.println(format);
    }

    @Test
    public void testSort() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "a"));
        students.add(new Student(2, "Abc"));
        students.add(new Student(3, "abc"));
        students.add(new Student(4, "zab"));
        students.add(new Student(5, "Zab"));
        students.sort(Comparator.comparing(Student::getName, Comparator.nullsLast(String::compareTo)));
        StringUtil.printObject(students);
    }

    @Test
    public void testFirstChar() {
        System.out.println(getFirstChar("abc"));
        System.out.println(getFirstChar("Abc"));
        System.out.println(getFirstChar("Fbc"));
        System.out.println(getFirstChar("1"));
        System.out.println(getFirstChar("啊"));
        System.out.println(getFirstChar("看"));
        System.out.println(getFirstChar("  "));
        System.out.println(getFirstChar(null));
        System.out.println((int) 'a');
        System.out.println((int) 'A');
    }

    private String getFirstChar(String pinyin) {
        String firstChar = StringUtils.isEmpty(pinyin) ?
                "{" : ('a' <= pinyin.charAt(0) && pinyin.charAt(0) <= 'z') || ('A' <= pinyin.charAt(0) && pinyin.charAt(0) <= 'Z')
                ? ("" + pinyin.charAt(0)).toLowerCase() : "{";
        return firstChar;
    }


    @Test
    public void char2String() {
        char a = 'a';
        System.out.println(("" + a).toUpperCase());

    }

    @Test
    public void testTrim() {
        String trim = " 123    ";
        System.out.println("=======" + trim.trim() + "+++++++++");
        String trim2 = " 123\n";
        System.out.println("=======" + trim2.trim() + "+++++++++");
        String trim3 = " 123\r";
        System.out.println("=======" + trim3.trim() + "+++++++++");
        String trim4 = " 123\t   ";
        System.out.println("=======" + trim4.trim() + "+++++++++");
        String trim5 = " 123\r\n";
        System.out.println("=======" + trim5.trim() + "+++++++++");
    }

    @Test
    public void stringSort() {
        List<Student> students = new ArrayList<>();
        Student student2 = new Student(2, "2");
        Student student1 = new Student(1, "1");
        Student student7 = new Student(7, "az");
        Student student5 = new Student(5, "b");
        Student student3 = new Student(3, "a");
        Student student4 = new Student(4, "A");
        Student student6 = new Student(6, "aa");
        Student student8 = new Student(8, "za");
        Student student9 = new Student(9, "{");
        Student student10 = new Student(10, "{z");
        Student student11 = new Student(11, "{a");
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        students.add(student6);
        students.add(student7);
        students.add(student8);
        students.add(student9);
        students.add(student10);
        students.add(student11);
        List<Student> sortedStudents = students.stream()
                .sorted(Comparator.comparing(Student::getName, Comparator.nullsLast(String::compareTo)))
                .collect(Collectors.toList());
        StringUtil.printObject(sortedStudents);
    }

    @Test
    public void intern() {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        String intern = str1.intern();
        System.out.println("s1:" + (intern == str1));
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println("s2:" + (str2.intern() == str2));
    }

    //===================          测试方法          ========================================================//

    @Test
    public void join() {
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(2L);
        ids.add(4L);
        String join = StringUtils.join(ids, ",");
        StringUtil.printObject(join);
    }

    @Test
    public void specialStringSplit() {
        String names = "baopan.1";
        String[] split = names.split("\\.");
        StringUtil.printObject(split);
    }

    @Test
    public void stringSplit() {
        String s1 = "DZFW_D";
        logger.info(s1.split("_")[0]);
    }

    /**
     * 将一个字符串转换成计算公式，求出结果
     */
    @Test
    public void string2MathsGetValue() {
        try {
            String str = "a >= 0 && a <= 5";//"(a >= 0 && a <= 5)";
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("js");
            engine.put("a", -1);
            Object result = engine.eval(str);
            System.out.println("结果类型:" + result.getClass().getName() + ",计算结果:" + result);

            String str2 = "Math.ceil(10.9)";//"43*(2 + 1.4)+2*32/(3-2.1)";
            ScriptEngineManager manager2 = new ScriptEngineManager();
            ScriptEngine engine2 = manager2.getEngineByName("js");
            Object result2 = engine2.eval(str2);
            System.out.println("结果类型:" + result2.getClass().getName() + ",计算结果:" + result2);
        } catch (Exception e) {

        }
    }

    //测试格式化问题
    @Test
    public void stringFormat() {
        int i = 1;
        StringBuilder sb = new StringBuilder(11);
        sb.append("JCZB")
                .append(String.format("%02d", 1))
                .append(String.format("%03d", 2));
        logger.info("===>sb:" + sb.toString());
    }

    @Test
    //测试stringBuild有内容数时，超过时怎么样
    //结果：构造一个不带任何字符的字符串生成器，其初始容量由 capacity 参数指定。
    public void stringBuildHasCan() {
        StringBuilder stringBuilder = new StringBuilder(3);
        stringBuilder.append("12345");
        logger.info("===>sb:" + stringBuilder.toString());
    }

    @Test
    //测试string、stringbuffer、stringbformat的效率问题
    public void someFunctionEffection() {
        for (int i = 0; i < 1000; i++) {
            compareEfficiencyWithStringAndStringBufferAndStringFormat(i);
        }


    }

    @Test
    public void stringFormatNullTest() {
        String s = null;
        System.out.println(String.format("ssss%fff", s));
    }


    //==========================        测试方法中的实现方法          ===============================================================//

    /**
     * 比较string stringbuffer stringformat等的效率
     * 结论证明：stringformat 最差，
     * <p>
     * String add：446ns
     * StringBuilder add：447ns
     * StringFormat：11156ns
     * String add：2231ns
     * StringBuilder add：446ns
     */
    public void compareEfficiencyWithStringAndStringBufferAndStringFormat(int i) {

        String success_code = "0";
        String splite = "currentbp";
        StringBuffer sb = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();

        String resultMsg2 = "";
        long time7 = System.nanoTime();
        resultMsg2 = "ErrorCode1=" + success_code + splite + "ErrorMsg1=心跳包接收成功" + i;
        long time8 = System.nanoTime();
        System.out.println("String add：" + (time8 - time7) + "ns");

        long time9 = System.nanoTime();
        sb2.append("ErrorCode2=").append(success_code).append(splite).append("ErrorMsg2=心跳包接收成功").append(i);
        long time10 = System.nanoTime();
        System.out.println("StringBuilder add：" + (time10 - time9) + "ns");

        String resultMsg = "";
        long time1 = System.nanoTime();
        String.format("ErrorCode=%s%sErrorMsg=心跳包接收成功%s", success_code, splite, i);
        long time2 = System.nanoTime();
        System.out.println("StringFormat：" + (time2 - time1) + "ns");

        long time3 = System.nanoTime();
        resultMsg = "ErrorCode=" + success_code + splite + "ErrorMsg=心跳包接收成功" + i;
        long time4 = System.nanoTime();
        System.out.println("String add：" + (time4 - time3) + "ns");

        long time5 = System.nanoTime();
        sb.append("ErrorCode=").append(success_code).append(splite).append("ErrorMsg=心跳包接收成功").append(i);
        long time6 = System.nanoTime();
        System.out.println("StringBuilder add：" + (time6 - time5) + "ns");
        System.out.println("-------------------------------------------------");
    }

}
