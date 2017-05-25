package com.bp.util.all;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 关于字符串的类
 *
 * @author current_bp
 * @createTime 20160513
 */

public class StringUtil {

    /**
     * 删除字符串的最后一个字符
     *
     * @param s 原数据
     * @return 最终数据
     */
    public static String deleteLast(String s) {
        if (null == s) {
            return null;
        }

        if ("".equals(s)) {
            return "";
        }

        StringBuffer sb = new StringBuffer(s);

        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    /**
     * 对一个字符串删除指定的字符或者字符串,替换的内容默认为空串,
     *
     * @param resource  原字符串
     * @param replaceed 被替换的部分，数组形式，如：new String[]{"\\(","\\)"}
     * @return
     */
    public static String getStringWithOutSome(String resource, String[] replaceed) {
        String temp = resource;
        for (int i = 0; i < replaceed.length; i++) {
            temp = getStringWithOutSome(temp, replaceed[i]);
        }

        return temp;
    }

    /**
     * 一个字符串删除指定的字符或者字符串,替换的内容默认为空串, 注意特殊字符，如（"\\("，）
     *
     * @param resource  原字符串
     * @param replaceed 被替换的部分
     * @return
     */
    public static String getStringWithOutSome(String resource, String replaceed) {
        return getStringWithOutSome(resource, "", replaceed);
    }

    /**
     * 一个字符串删除指定的字符或者字符串
     *
     * @param resource  原字符串
     * @param replace   要替换成的部分
     * @param replaceed 被替换的部分
     * @return 结果
     */
    public static String getStringWithOutSome(String resource, String replace, String replaceed) {
        String result = "";

        // 如果为空或者空串，就不需要替换了
        if (null == resource || "".equals(resource)) {
            return resource;
        }

        if (null == replaceed || "".equals(replaceed)) {
            throw new RuntimeException("被替换的部分不能为空和空串！");
        }

        if (null == replace) {
            throw new RuntimeException("替换内容不能为null！");
        }

        result = resource;

        return result.replaceAll(replaceed, replace);
    }

    /**
     * 字符串左边填充0
     *
     * @param length 结果字符串的长度
     */
    public static String fillBySome(int length, int value) {
        return fillBySome(length, "" + value, "0");
    }

    /**
     * 字符串左边填充0
     *
     * @param length 结果字符串的长度
     */
    public static String fillBySome(int length, String value) {
        return fillBySome(length, value, "0");
    }

    /**
     * 左边填充字符串
     *
     * @param length 结果字符串的长度
     * @param value  给定的字符串
     * @param fill   填充的内容
     * @return
     */
    public static String fillBySome(int length, String value, String fill) {
        return fillBySome(length, value, fill, 0);
    }

    /**
     * 填充字符串
     *
     * @param length 结果字符串的长度
     * @param value  给定的字符串
     * @param fill   填充的内容
     * @param option 位置：0：左边，1：右边
     * @return
     */
    public static String fillBySome(int length, String value, String fill, int option) {
        if (null == value) {
            value = "";
        }
        if (null == fill) {
            throw new RuntimeException("填充内容不能为null!");
        }

        String result = "" + value;
        StringBuffer temp = new StringBuffer("");
        StringBuffer t1 = new StringBuffer("");

        // 如果大量的填充时
        if (length >= 10) {
            int x = length - value.length();// 剩余填充的位数
            for (int i = 0; i < 10; i++) {
                t1.append(fill);
            }
            for (int j = 0; j < x / 10; j++) {
                temp.append(t1.toString());
            }
            for (int k = 0; k < x % 10; k++) {
                temp.append(fill);
            }

        } else {// 填充东西比较小时
            if (result.length() >= length) {
            } else {
                for (int i = 0; i < length - value.length(); i++) {
                    temp.append(fill);
                }
            }
        }

        return option > 0 ? result + temp.toString() : temp.toString() + result;
    }

    /**
     * 获取首字母为大写的字符串
     *
     * @param name
     * @return
     */
    public static String getCaptureName(String name) {
        if (null == name || "".equals(name)) {
            throw new RuntimeException("该字符串为null或空串");
        }

        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }

    /**
     * 根据格式分割字符串
     *
     * @param resourceString
     * @param split
     * @return
     */
    public static String[] getSplitString(String resourceString, String split) {
        return resourceString.split(split);
    }

    /**
     * 在指定的位置插入字符串
     *
     * @param resource  原字符串
     * @param something 需要插入的内容
     * @param where     插入的位置,0:第一个位置
     * @return
     */
    public static String insertSomethingToWhere(String resource, String something, int where) {
        if (null == resource) {
            throw new RuntimeException("原字符串不能为空！");
        }
        if (null == something) {
            throw new RuntimeException("插入内容不能为空！");
        }
        if (resource.length() < where || where < 0) {
            throw new IndexOutOfBoundsException("插入的位置越界！");
        }

        StringBuffer sb = new StringBuffer(resource);
        sb.insert(where, something);

        return sb.toString();
    }

    /**
     * 将字符串转为列表，根据逗号分割，删除空和null
     *
     * @param source 字符串
     * @return
     * @throws Exception
     */
    public static List<String> stringToList(String source) throws Exception {
        return stringToList(source, true, ",");
    }

    /**
     * 将字符串根据规则转换为列表
     *
     * @param source     字符串
     * @param deleteNull 是否删除空和null
     * @param splitBy    根据什么字符分割
     * @return
     * @throws Exception
     */
    public static List<String> stringToList(String source, boolean deleteNull, String splitBy) throws Exception {
        CheckUtil.isEmpty("source", source);
        if (null == splitBy || "".equals(splitBy)) {
            throw new RuntimeException("splitBy is empty!");
        }
        source = source.replace("[", "").replace("]", "").replace("\"", "");

        String[] s = source.split(splitBy);
        List<String> result = new ArrayList<String>();

        for (String s1 : s) {
            if (deleteNull) {
                if (!CheckUtil.isEmpty(s1)) {
                    result.add(s1);
                }
            } else {
                result.add(s1);
            }
        }
        return result;
    }


    /**
     * 将字母转换成数字
     *
     * @param letter
     * @return
     */
    public static Integer letter2Int(String letter) {
        if (null == letter) {
            return -1;
        }
        return letter2Int(letter.charAt(0));
    }

    /**
     * 将字母转换成数字
     *
     * @param letter
     * @return
     */
    public static Integer letter2Int(char letter) {
        return (int) letter;
    }

    /**
     * 将数字转为字母
     *
     * @param num
     * @return
     */
    public static char int2Letter(int num) {
        return (char) num;
    }


    /**
     * 获取a标签列表
     *
     * @param resource 原数据
     * @return 获取标签体
     */
    public static List<String> getALabel(String resource) {
        return getLabel(resource, "a");
    }

    /**
     * 获取标签列表
     *
     * @param resource 源数据
     * @param label    标签名称
     * @return 该标签的列表数据
     */
    public static List<String> getLabel(String resource, String label) {
        List<String> results = new ArrayList<String>();
        String reg = "(<" + label + ".*?>([\\s\\S]*?)</" + label + ">)";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(resource);
        while (matcher.find()) {
            results.add(matcher.group());
        }
        return results;
    }

    /**
     * 获取所有的该标签中的内容
     *
     * @param resource 源数据
     * @param label    标签名称
     * @return 标签内容列表
     */
    public static List<String> getLabelContent(String resource, String label) {
        List<String> result = new ArrayList<String>();
        List<String> labels = getLabel(resource, label);
        for (String label1 : labels) {
            String reg = "(<" + label + ">)(.*)(</" + label + ">)";
            Pattern pattern = Pattern.compile(reg);
            Matcher matcher = pattern.matcher(label1);
            result.add(matcher.replaceAll("$2"));
        }
        return result;
    }





    public static void main(String[] args) throws Exception {

        System.out.println(StringUtil.letter2Int("A"));
        System.out.println(StringUtil.int2Letter(65 + 11));

//		//将字符串转换为列表
//		System.out.println(StringUtil.stringToList("2,2,2,2,"));
//		System.out.println(StringUtil.stringToList("2,2,2,2,: ss",false,":"));

        // System.out.println(StringUtil.insertSomethingToWhere("222", "1",
        // -1));
        // System.out.println(StringUtil.insertSomethingToWhere("222", "1", 0));
        // System.out.println(StringUtil.insertSomethingToWhere("222", "1", 1));
        // System.out.println(StringUtil.insertSomethingToWhere("222", "1", 2));
        // System.out.println(StringUtil.insertSomethingToWhere("222", "1", 3));
        // System.out.println(StringUtil.insertSomethingToWhere("222", "1", 4));
        // System.out.println(StringUtil.insertSomethingToWhere("222", "11111",
        // 2));

        // String ss = StringUtil.getSplitString("int(11)",
        // "int")[1].toString();
        // System.out.println(StringUtil.getStringWithOutSome(ss, new
        // String[]{"\\(","\\)"}));

        // System.out.println(StringUtil.getCaptureName("a111111a"));
        // System.out.println(StringUtil.getCaptureName(""));

        // System.out.println(StringUtil.fillBySome(20, "1"));

        // System.out.println(StringUtil.getStringWithOutSome("123456--123123",
        // "++", "-"));
        // System.out.println(StringUtil.getStringWithOutSome("123456--123123",
        // "-"));
        // System.out.println("+++++"+StringUtil.deleteLast(null)+"====");
        // new HashMap ();
    }



}
