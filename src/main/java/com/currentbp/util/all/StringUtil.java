package com.currentbp.util.all;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    private final static Logger logger = LoggerFactory.getLogger(StringUtil.class);

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
     * @return 列表
     */
    public static List<String> stringToList(String source) {
        return stringToList(source, ",");
    }

    /**
     * 将字符串转为列表,去除为空的数据
     *
     * @param source  源数据
     * @param splitBy 分割符
     * @return 列表
     */
    public static List<String> stringToList(String source, String splitBy) {
        return stringToList(source, true, splitBy);
    }

    /**
     * 将字符串根据规则转换为列表
     *
     * @param source     字符串
     * @param deleteNull 是否删除空和null
     * @param splitBy    分割符
     * @return 列表
     */
    public static List<String> stringToList(String source, boolean deleteNull, String splitBy) {
        Assert.notNull(source, "源数据不能为空");
        Assert.notNull(splitBy, "分割符不能为空");
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
     * 列表转换城字符串，分割符“,”
     *
     * @param source list
     * @return 字符串
     */
    public static String list2String(List source) {
        return list2String(source, ",");
    }

    /**
     * 列表转换城字符串
     *
     * @param source list
     * @param split  分割符
     * @return 字符串
     */
    public static String list2String(List source, String split) {
        StringBuilder result = new StringBuilder("");
        if (CheckUtil.isEmpty(source)) {
            return result.toString();
        }

        for (Object o : source) {
            result.append(o.toString() + split);
        }

        if (0 != result.length()) {
            result.delete(result.lastIndexOf(split), result.length());
        }

        return result.toString();
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
            String reg = "(<" + label + "(.*)>)(.*)(</" + label + ">)";
            Pattern pattern = Pattern.compile(reg);
            Matcher matcher = pattern.matcher(label1);
            result.add(matcher.replaceAll("$3"));
        }
        return result;
    }

    /**
     * 打印对象
     */
    public static void printObject(Object o) {
        printObject("", o);
    }
    /**
     * 打印对象：匹配格式"{}"
     */
    public static void printObject(String format, Object ... objects) {
        if (null == format) {
            System.out.println("");
        }
        if (null == objects || 0 == objects.length) {
            System.out.println(format);
        }
        String[] formatSplit = format.split("\\{\\}");
        int fIndex = 0, obIndex = 0;
        StringBuilder str = new StringBuilder();
        while (true) {
            if (fIndex >= formatSplit.length && obIndex >= objects.length) {
                break;
            }
            if (fIndex < formatSplit.length) {
                str.append(formatSplit[fIndex++]);
            }
            if (obIndex < objects.length) {
                str.append(JSON.toJSONString(objects[obIndex++]));
            }
        }
        System.out.println(str);
    }

    /**
     * 获取驼峰格式的字符串
     *
     * @param source 源：abc_der_fz
     * @return 结果：abcDerFz
     */
    public static String getHumpFormat(String source) {
        if (CheckUtil.isEmpty(source)) {
            return source;
        }
        String[] split = source.split("_");
        StringBuilder result = new StringBuilder(split[0].substring(0, 1).toLowerCase() + split[0].substring(1));
        for (int i = 1; i < split.length; i++) {
            result.append(split[i].substring(0, 1).toUpperCase() + split[i].substring(1));
        }
        return result.toString();
    }

}
