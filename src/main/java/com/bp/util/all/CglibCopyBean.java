package com.bp.util.all;

import net.sf.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

/**
 * cglib使用动态代理,BeanUtils使用反射机制
 *
 * @author current_bp
 * @createTime 20170718
 */
public class CglibCopyBean {

    /**
     * 对象间名称相同可以copy属性值,不相同的属性为null
     *
     * @param source 源
     * @param target 目标
     */
    public static void BasicCopyBean(Object source, Object target) {
        if (null != source) {
            BeanCopier copier = BeanCopier.create(source.getClass(), target.getClass(), false);
            copier.copy(source, target, null);
        }
    }


    /**
     * 对象间名称相同可以copy属性值,不相同的属性为null
     *
     * @param source 源
     * @param c      目标类型
     * @param <T>    目标类型
     * @return 目标
     * @throws Exception
     */
    public static <T> T doClone(Object source, Class<T> c) throws Exception {
        Object target = null;
        if (source == null) {
            return null;
        }
        target = c.newInstance();
        BeanCopier copier = BeanCopier.create(source.getClass(), c, false);
        copier.copy(source, target, null);
        return (T) target;
    }


    /**
     * 批量复制bean,copy一个list对象
     *
     * @param src 源
     * @param c   目标类型
     * @param <T> 目标类型
     * @return 目标
     * @throws Exception
     */
    public static <T> List<T> doBatchClone(List<? extends Object> src, Class<T> c) throws Exception {
        if (src == null || src.size() == 0) {
            return null;
        }
        List<T> list = new ArrayList<T>(src.size());
        for (Object obj : src) {
            T doClone = doClone(obj, c);
            list.add(doClone);
        }
        return list;
    }
}
