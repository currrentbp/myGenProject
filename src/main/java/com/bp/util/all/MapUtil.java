package com.bp.util.all;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 关于map的集合类
 *
 * @author baopan
 * @createTime 20170830
 */
public class MapUtil {


    /**
     * 从list转换成map结构
     * @param list 原始数据列表
     * @param field map的key字段名称
     * @param <K> key类型
     * @param <V> value 类型
     * @return map结构
     */
    public static <K, V> Map<K, V> getMapByList(List<V> list, String field) {
        Map<K, V> result = new HashMap<K, V>();
        try {
            for (V v : list) {
                Field field1 = v.getClass().getDeclaredField("id");
                field1.setAccessible(true);
                result.put((K)field1.get(v),v);
            }
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
        return result;
    }

}
