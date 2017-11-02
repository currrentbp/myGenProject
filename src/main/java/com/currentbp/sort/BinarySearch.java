package com.currentbp.sort;

import com.currentbp.util.all.CheckUtil;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 二分法查找
 *
 * @author current_bp
 * @createTime 20170625
 */
public class BinarySearch {

    private static Logger logger = LoggerFactory.getLogger(BinarySearch.class);

    @Test
    public void test1() {
        List<Integer> list = new ArrayList<Integer>();
        list.addAll(Arrays.asList(new Integer[]{1,2,3,4,5,6,7}));
        int k1 = getKeyIndex(list,5);
        Assert.assertTrue(k1 == 4);

        list.clear();
        list.addAll(Arrays.asList(new Integer[]{1,2,3,4,5,6,7}));
        int k2 = getKeyIndex(list,4);
        Assert.assertTrue(k2 == 3);

        list.clear();
        list.addAll(Arrays.asList(new Integer[]{1,2,3,4,5,6,7}));
        int k3 = getKeyIndex(list,3);
        Assert.assertTrue(k3 == 2);

        list.clear();
        list.addAll(Arrays.asList(new Integer[]{1,2,3,4,5,6,7}));
        int k4 = getKeyIndex(list,2);
        Assert.assertTrue(k4 == 1);

        list.clear();
        list.addAll(Arrays.asList(new Integer[]{1,2,3,4,5,6,7}));
        int k5 = getKeyIndex(list,1);
        Assert.assertTrue(k5 == 0);

        list.clear();
        list.addAll(Arrays.asList(new Integer[]{1,2,3,4,5,6,7}));
        int k6 = getKeyIndex(list,6);
        Assert.assertTrue(k6 == 5);

        list.clear();
        list.addAll(Arrays.asList(new Integer[]{1,2,3,4,5,6,7}));
        int k7 = getKeyIndex(list,7);
        Assert.assertTrue(k7 == 6);
    }


    /**
     * 根据二分法获取key所在的位置
     *
     * @param source 从小到大排序的原数据
     * @param key    需要查找的内容
     * @return key所在的位置，-1：不存在
     */
    public int getKeyIndex(List<Integer> source, int key) {
        if (CheckUtil.isEmpty(source)) {
            return -1;
        }
        int left = 0, right = source.size() - 1, centor = (left + right) / 2;

        while (true) {
            int temp = source.get(centor);
            if (left == right && temp != key) {
                break;
            }
            if (temp == key) {
                return centor;
            } else if (key < temp) {//key在前半段
                right = centor - 1;
                centor = (left + right) / 2;
            } else {//key 在后半段
                left = centor + 1;
                centor = (left + right) / 2;
            }
        }

        return 0;
    }
}
