package com.bp.util.all;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
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
     *
     * @param list      原始数据列表
     * @param fieldName map的key字段名称
     * @param <K>       key类型
     * @param <V>       value 类型
     * @return map结构
     */
    public static <K, V> Map<K, V> getMapByList(List<V> list, String fieldName) {
        Map<K, V> result = new HashMap<K, V>();
        if(CheckUtil.isEmpty(list)){
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
     * @param list 原数据
     * @param fieldName 对象中的字段
     * @param <K> K
     * @param <V> 对象
     * @return map结构数据
     */
    public static <K, V> Map<K, List<V>> getMapListByList(List<V> list, String fieldName) {
        Map<K, List<V>> result = new HashMap<K, List<V>>();
        if(CheckUtil.isEmpty(list)){
            return result;
        }
        try {
            for (V v : list) {
                Field field1 = v.getClass().getDeclaredField(fieldName);
                field1.setAccessible(true);
                K k = (K) field1.get(v);
                if(!result.containsKey(k)){
                    result.put(k,new ArrayList<V>());
                }
                result.get(k).add(v);
            }
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
        return result;
    }

}
