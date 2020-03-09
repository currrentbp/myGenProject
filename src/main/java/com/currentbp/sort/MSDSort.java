package com.currentbp.sort;

import com.currentbp.util.all.Assert;
import com.currentbp.util.all.ListUtil;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

/**
 * 基数排序：只能排序正整数
 *
 * @author baopan
 * @createTime 20191219
 */
public class MSDSort {


    @Test
    public void t1() {

    }

    public int[] sort(int[] source) {
        if (null == source || source.length <= 1) {
            return source;
        }

        int max = 0;
        for (int s : source) {
            Assert.isTrue(s>0,"必须为正整数");
            if (max < s) {
                max = s;
            }
        }
        int length = ("" + max).length();
        int[] result = new int[source.length];

        for (int i = 0; i < length; i++) {
            //todo not work

        }
        return result;
    }
}
