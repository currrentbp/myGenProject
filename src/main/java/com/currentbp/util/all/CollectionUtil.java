package com.currentbp.util.all;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

/**
 * 关于集合类
 *
 * @author current_bp
 * @createTime 20171203
 */
public class CollectionUtil {

    private final static Logger logger = LoggerFactory.getLogger(CollectionUtil.class);

    /**
     * 向一个列表中的固定字段插入一个固定值
     *
     * @param list       列表
     * @param methodName 该字段的set方法
     * @param v          固定值
     * @param <A>        列表对象类型
     * @param <V>        固定值类型
     */
    public static <A, V> void setFieldByMethodName(List<A> list, String methodName, V v) {
        if (CheckUtil.isEmpty(list)) {
            return;
        }
        Method method = null;
        try {
            method = list.get(0).getClass().getMethod(methodName, v.getClass());
            method.setAccessible(true);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        for (A a : list) {
            try {
                method = a.getClass().getMethod(methodName, v.getClass());
                method.setAccessible(true);
                method.invoke(a, v);//TODO not work
            } catch (Exception e) {
                logger.error("===>message:" + e.getMessage(), e);
            }
        }
    }

    /**
     * 从列表中获取某个字段的SET
     *
     * @param list       对象列表
     * @param methodName 字段get方法名词
     * @param kType      字段类型
     * @param <V>        字段类型
     * @param <A>        key类型
     * @return
     */
    public static <V, A> Set<V> getFieldSetByMethodName(List<A> list, String methodName, Class<V> kType) {
        return new HashSet<V>(getFieldListByMethodName(list, methodName, kType));
    }

    /**
     * 通过方法名称获取某个字段对应的列表
     *
     * @param list       列表
     * @param methodName 方法名词
     * @param kType      返回类型
     * @param <V>        返回类型
     * @param <A>        key值类型
     * @return
     */
    public static <V, A> List<V> getFieldListByMethodName(List<A> list, String methodName, Class<V> kType) {
        if (CheckUtil.isEmpty(list)) {
            return new ArrayList<V>();
        }
        Method method = null;
        try {
            method = list.get(0).getClass().getMethod(methodName);
            method.setAccessible(true);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        List<V> result = new ArrayList<V>(list.size());
        for (A a : list) {
            try {
                method = a.getClass().getMethod(methodName);
                method.setAccessible(true);
                result.add((V) method.invoke(a));
            } catch (Exception e) {
                logger.error("===>message:" + e.getMessage(), e);
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
        if (CheckUtil.isEmpty(list)) {
            return new ArrayList<V>();
        }
        List<V> result = new ArrayList<V>(list.size());

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


    /**
     * 从list转换成map结构
     *
     * @param list      原始数据列表
     * @param fieldName map的key字段名称
     * @param <K>       key类型
     * @param <V>       value 类型
     * @return map结构
     */
    public static <K, V> Map<K, V> getMapByList(List<V> list, String fieldName) {
        Map<K, V> result = new HashMap<K, V>();
        if (CheckUtil.isEmpty(list)) {
            return result;
        }
        try {
            for (V v : list) {
                Field field1 = v.getClass().getDeclaredField(fieldName);
                field1.setAccessible(true);
                result.put((K) field1.get(v), v);
            }
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
        return result;
    }

    /**
     * 通过list转换成map《K，list《V》 》的格式
     *
     * @param list      原数据
     * @param fieldName 对象中的字段
     * @param <K>       K
     * @param <V>       对象
     * @return map结构数据
     */
    public static <K, V> Map<K, List<V>> getMapListByList(List<V> list, String fieldName) {
        Map<K, List<V>> result = new HashMap<K, List<V>>();
        if (CheckUtil.isEmpty(list)) {
            return result;
        }
        try {
            for (V v : list) {
                Field field1 = v.getClass().getDeclaredField(fieldName);
                field1.setAccessible(true);
                K k = (K) field1.get(v);
                if (!result.containsKey(k)) {
                    result.put(k, new ArrayList<V>());
                }
                result.get(k).add(v);
            }
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
        return result;
    }


    /**
     * 将一个数组转换成列表格式
     *
     * @param source 元数据
     * @param t      目标类型
     * @param <T>    目标类型
     * @return 列表格式
     */
    public static <T> List<T> asList(Object[] source, Class<T> t) {
        if (null == source || 0 == source.length) {
            return new ArrayList<T>();
        }

        List<T> result = new ArrayList<T>(source.length);
        try {
            for (Object s : source) {
                T r;
                try {
                    r = (T) t.newInstance();
                    CglibCopyBean.BasicCopyBean(s, r);
                } catch (Exception e) {
                    r = (T) s;//尽量转化
                }
                result.add(r);
            }
        } catch (Exception e) {
            logger.error("===>asList is error! source:" + JSON.toJSONString(source), e);
        }
        return result;
    }


}
