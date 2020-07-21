package com.currentbp.sort;

import com.currentbp.util.all.StringUtil;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 2020/7/21 12:54
 */
public class Sort1 {
    /*
    利用数组copy功能获取前10的名次
     */

    @Test
    public void t1() {
        int[] sources = new int[]{5, 3, 2, 1, 4, 3, 90, 88, 89, 50, 45, 65};

        int[] sorted = getSorted(sources, 3);
        StringUtil.printObject(sorted);

    }

    /**
     * 获取前n的数据
     *
     * @param sources 源数据
     * @param length  n
     * @return 结果
     */
    private int[] getSorted(int[] sources, int length) {
        if (length <= 0) {
            return new int[]{};
        }
        if (length == 1) {
            int max = 0;
            for (int source : sources) {
                max = Math.max(max, source);
            }
            return new int[]{max};
        }

        int[] result = new int[length];

        for (int source : sources) {
            int index = -1;//表示该数在前n以外
            for (int i = 0; i < length; i++) {
                if (result[i] < source) {
                    index = i;
                    break;
                }
            }

            if (-1 == index) {
                continue;
            } else if (index == length - 1) {//最后一个位置
                result[index] = source;
            } else {
                System.arraycopy(result, index, result, index + 1, length - index - 1);
                result[index] = source;
            }
        }

        return result;
    }


}
