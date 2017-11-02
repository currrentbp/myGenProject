package com.currentbp.util.all;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 数组，列表，等的类
 *
 * @author current_bp
 * @createTime 20160513
 */
public class ListUtil {
    private final static Logger logger = LoggerFactory.getLogger(ListUtil.class);

    /**
     * 将数组填充逗号
     *
     * @param l
     * @return
     */
    public static String fill(List l) {
        return fill(l, ",");
    }

    /**
     * 将数组中填充指定的符号
     *
     * @param resourceList resourceList
     * @param fillName     fillName
     * @return
     */
    public static String fill(List resourceList, String fillName) {
        StringBuffer result = new StringBuffer("");
        // System.out.println(resourceList);
        List l = pureListWithoutNull(resourceList);
        // System.out.println(l);
        if (null != l) {
            for (int i = 0; i < l.size(); i++) {
                result.append(l.get(i) + "" + fillName);
            }
            if (result.length() != 0) {
                int lastIndex = result.lastIndexOf(fillName);
                result.delete(lastIndex, result.length());
            }
        }

        return result.toString();
    }

    /**
     * 根据列表计算每个列表的数据和
     *
     * @param list
     * @return
     */
    public static int sumNumsFromList(List<Integer> list) {
        int result = 0;

        if (null == list || 0 == list.size()) {
            return result;
        }

        for (int i = 0; i < list.size(); i++) {
            result = result + list.get(i);
        }

        return result;
    }

    /**
     * 从数组中获取所有数据的和
     *
     * @param array
     * @return
     */
    public static int sumNumsFromArray(Integer[] array) {
        int result = 0;

        if (null == array || 0 == array.length) {
            return result;
        }

        for (int i = 0; i < array.length; i++) {
            result = result + array[i];
        }

        return result;
    }

    /**
     * 通过一个列表获取一个没有null的列表
     *
     * @param l
     * @return
     */
    public static List pureListWithoutNull(List l) {
        List result = new ArrayList();

        if (null == l || 0 == l.size()) {
            return result;
        }

        for (Object o : l) {
            if (null != o) {
                result.add(o);
            }
        }

        return result;
    }

    /**
     * 翻转list
     *
     * @param resource
     * @return
     */
    public static List reverseList(List resource) {
        if (null == resource) {
            return null;
        }

        List result = new ArrayList();

        if (0 == resource.size()) {
            return result;
        }

        for (int i = resource.size() - 1; i >= 0; i--) {
            result.add(resource.get(i));
        }

        return result;
    }

    /**
     * 将string类型的列表转换成integer的列表
     *
     * @param source
     * @return
     */
    public List<Integer> stringList2IntegerList(List<String> source) {
        List<Integer> result = new ArrayList<Integer>();

        if (CheckUtil.isEmpty(source)) {
            return result;
        }

        for (String s : source) {
            try {
                result.add(Integer.parseInt(s));
            } catch (Exception e) {
            }
        }

        return result;
    }

    /**
     * 将string类型的list转为long类型的list
     *
     * @param source
     * @return
     */
    public List<Long> stringList2LongList(List<String> source) {
        List<Long> result = new ArrayList<Long>();

        if (CheckUtil.isEmpty(source)) {
            return result;
        }

        for (String s : source) {
            try {
                result.add(Long.parseLong(s));
            } catch (Exception e) {
            }
        }

        return result;
    }

    /**
     * 通过列表获取某个字段的列表
     *
     * @param list      原对象列表数据
     * @param fieldName 原对象中的某个字段
     * @param kType     返回类型
     * @param <V>       返回单个实体类型
     * @param <A>       输入的单个类型
     * @return 该字段的列表
     */
    public static <V, A> List<V> getFieldListByObjectList(List<A> list, String fieldName, Class<V> kType) {
        List<V> result = new ArrayList<V>();
        if (CheckUtil.isEmpty(list)) {
            return result;
        }

        for (A a : list) {
            try {
                Field field1 = getFieldByNameFromAnywhere(a.getClass(), fieldName);
                field1.setAccessible(true);
                V v = null;
                if (null == field1.get(a)) {
                    result.add(null);
                } else {
                    //如果类型一致
                    if (field1.getType() == kType) {
                        v = (V) field1.get(a);
                    } else {//如果类型不一致，尽量转化
                        v = kType.getConstructor(field1.getType()).newInstance(field1.get(a));
                    }
                    result.add(v);
                }
            } catch (Exception e) {
                logger.error("===>message:" + e.getMessage(), e);
            }
        }

        return result;
    }

    /**
     * 该方法私有：根据字段名称获取一个field
     *
     * @param aClass    该对象的class
     * @param fieldName 字段名称
     * @return field
     */
    private static Field getFieldByNameFromAnywhere(Class<?> aClass, String fieldName) {
        Field result = null;
        try {
            result = aClass.getDeclaredField(fieldName);
        } catch (Exception e) {
            result = getFieldByNameFromAnywhere(aClass.getSuperclass(), fieldName);
        }
        return result;
    }

}
