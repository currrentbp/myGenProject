package com.currentbp.Interesting.other;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

/**
 * 判断一个数组（二进制的值）是否能被分为三份，而且三份的二进制表示的值是相同的
 * 例如：10101   可以表示为[0,3]
 *
 * @author baopan
 * @createTime 2020/7/22 11:31
 */
public class IsTheSameBinary {

    @Test
    public void t1() {
        int[] source = new int[]{1, 0, 1, 0, 1};
        int[] result = getBinarySplit(source);
        StringUtil.printObject(result);
    }

    @Test
    public void t2() {
        int[] source = new int[]{1, 0, 1, 0, 1};
        int value = getValue(source, 4, 4);
        StringUtil.printObject(value);
    }

    private int[] getBinarySplit(int[] source) {
        if (source.length < 3) {
            return new int[]{-1, -1};
        }
        for (int firstLocal = 0; firstLocal < source.length - 2; firstLocal++) {
            for (int secondLocal = firstLocal + 1; secondLocal < source.length - 1; secondLocal++) {
                if (isOk(source, firstLocal, secondLocal)) {
                    return new int[]{firstLocal, secondLocal + 1};//这里有一个坑，就是区间的开闭问题
                }
            }
        }
        return new int[]{-1, -1};
    }

    private boolean isOk(int[] source, int firstLocal, int secondLocal) {
        int value1 = getValue(source, 0, secondLocal);
        int value2 = getValue(source, firstLocal, secondLocal);
        int value3 = getValue(source, secondLocal, source.length - 1);
        return value1 == value2 && value2 == value3;
    }

    /**
     * 获取数组对应位置的二进制值
     * [start,end)
     */
    private int getValue(int[] source, int start, int end) {
        int sum = 0;
        if (start == end) {
            return source[start] * getTwoN(0);
        }
        for (int i = end - 1, j = 0; i >= start; i--) {
            sum += source[i] * getTwoN(j);
            j++;
        }
        return sum;
    }

    /**
     * 获取2的N次方
     */
    private int getTwoN(int n) {
        if (n == 0) {
            return 1;
        }
        return 2 * getTwoN(n - 1);
    }


}
