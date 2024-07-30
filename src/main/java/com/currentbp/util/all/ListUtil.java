package com.currentbp.util.all;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * 数组，列表，等的类
 *
 * @author current_bp
 * @createTime 20160513
 */
public class ListUtil<V> {
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
     * 将array转换成list
     */
    public static <V> List<V> array2List(V[] source) {
        if (null == source || 0 == source.length) {
            return new ArrayList<>();
        }
        List<V> result = new ArrayList<>(source.length);
        for (V v : source) {
            result.add(v);
        }
        return result;
    }

    public static List<List<Integer>> arrays2Lists(int[][] sources){
        if(sources == null){
            return null;
        }
        if(sources.length==0){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int[] levels : sources) {
            List<Integer> temps = new ArrayList<>();
            for (int i = 0; i < levels.length; i++) {
                temps.add(levels[i]);
            }
            result.add(temps);
        }
        return result;
    }

    /**
     * 将list转换成array
     */
    public static <V> V[] list2Array(List<V> source) {
        if (null == source || 0 == source.size()) {
            return (V[]) new Object[]{};
        }
        V[] result = (V[]) Array.newInstance(source.get(0).getClass(), source.size());
        for (int i = 0; i < source.size(); i++) {
            result[i] = source.get(i);
        }
        return result;
    }

    public static int[] list2intArray(List<Integer> source) {
        Assert.notEmpty(source, "数据源不能为空");
        int[] result = new int[source.size()];
        for (int i = 0; i < source.size(); i++) {
            result[i] = source.get(i);
        }
        return result;
    }

    public static <V> List<V> newArrayList(V... values) {
        if (null == values || 0 == values.length) {
            return new ArrayList<>();
        }
        List<V> result = new ArrayList<>(values.length);
        for (V value : values) {
            result.add(value);
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

    public static <V> void printList(List<V> list) {
        System.out.print("[");
        if (null != list) {
            for (int i = 0; i < list.size(); i++) {
                printMiddle(list.get(i), i < list.size() - 1);
            }
        }
        System.out.println("]");
    }

    public static void printList(Object[] array) {
        System.out.print("[");
        if (null != array) {
            for (int i = 0; i < array.length; i++) {
                printMiddle(array[i], i < array.length - 1);
            }
        }
        System.out.println("]");
    }

    public static void printList(String[] array) {
        System.out.print("[");
        if (null != array) {
            for (int i = 0; i < array.length; i++) {
                printMiddle(array[i], i < array.length - 1);
            }
        }
        System.out.println("]");
    }

    public static void printList(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print("" + array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printList(int[] array) {
        System.out.print("[");
        if (null != array) {
            for (int i = 0; i < array.length; i++) {
                printMiddle(array[i], i < array.length - 1);
            }
        }
        System.out.println("]");
    }

    public static void printList(char[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            printMiddle(array[i], i < array.length - 1);
        }
        System.out.println("]");
    }

    public static void printList(boolean[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            printMiddle(array[i], i < array.length - 1);
        }
        System.out.println("]");
    }

    private static void printMiddle(Object o, boolean isNotEnd) {
        if (isNotEnd) {
            System.out.print(o + ", ");
        } else {
            System.out.print(o);
        }
    }

    public static <V> void printTri(List<List<V>> tris) {
        if (tris == null || tris.size() == 0) {
            return;
        }
        int level = tris.size() - 1;
        int maxLength = tris.get(level).size();
        for (int currentLevel = 0; currentLevel <= level; currentLevel++) {
            for (int whiteIndex = 0; whiteIndex < (maxLength / 2) - currentLevel + 1; whiteIndex++) {
                System.out.print(String.format("%3s", " "));
            }
            List<V> currentLevels = tris.get(currentLevel);
            for (int index = 0; index < currentLevels.size(); index++) {
                System.out.print(String.format("%3s", currentLevels.get(index)));
            }
            System.out.println();
        }
    }

    public static <V> void printTri1(List<List<V>> tris) {
        if (tris == null || tris.size() == 0) {
            return;
        }

        // 获取最大宽度（即杨辉三角最底层元素的数量）
        int maxWidth = tris.get(tris.size() - 1).size();

        // 遍历每一层
        for (int level = 0; level < tris.size(); level++) {
            List<V> currentLevel = tris.get(level);

            // 计算并打印前置空格，以对齐元素
            int leadingSpaces = maxWidth / 2 - currentLevel.size() / 2;
            for (int i = 0; i < leadingSpaces; i++) {
                System.out.print("   ");
            }

            // 打印当前层的元素
            for (V value : currentLevel) {
                System.out.print(String.format("%3s", value.toString()));
            }

            // 换行
            System.out.println();
        }
    }
}
