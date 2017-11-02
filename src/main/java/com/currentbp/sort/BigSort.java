package com.currentbp.sort;

import java.util.BitSet;
import java.util.Map;
import java.util.TreeMap;

/**
 * 大数据量排序
 *
 * @author current_bp
 * @createTime 20170607
 */
public class BigSort {
    BitSet bitSet = new BitSet();
    Map<Integer, Integer> map = new TreeMap();
    private int maxValue = 0;
    private int size = 0;


    /**
     * 塞值
     *
     * @param value 值
     */
    public void put(int value) {
        if (0 > value) {
            throw new RuntimeException("value is not legal!!");
        }
        if (!bitSet.get(value)) {
            bitSet.set(value);
        } else {
            if (map.containsKey(value)) {
                int count = map.get(value);
                map.put(value, count + 1);
            } else {
                map.put(value, 2);//第二次出现
            }
        }
        //获取最大数字
        maxValue = maxValue >= value ? maxValue : value;
        ++size;
    }

    /**
     * 获取该值是否出现过,出现过几次
     *
     * @param value 值
     * @return 出现过几次
     */
    public int get(int value) {
        int result = 0;
        if (!bitSet.get(value)) {//没出现过
            result = 0;
        } else {//出现过
            if (map.containsKey(value)) {
                result = map.get(value);
            } else {
                result = 1;
            }
        }
        return result;
    }

    public int getSize() {
        return size;
    }


    public int getMaxValue() {
        return maxValue;
    }

}
