package com.bp.sort;

import com.bp.util.all.CheckUtil;
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
        getKeyIndex(list,5);
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
