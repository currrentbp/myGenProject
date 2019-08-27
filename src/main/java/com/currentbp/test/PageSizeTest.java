package com.currentbp.test;

import com.currentbp.util.all.Assert;
import com.currentbp.util.all.ListUtil;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 20190826
 */
public class PageSizeTest {

    @Test
    public void t1(){
        int[] minMax1 = getMinMaxId(1, 20, 2, 3);
        ListUtil.printList(minMax1);
    }

    private int[] getMinMaxId(Integer minId, Integer maxId, int index, Integer batchSize) {
        int[] result = new int[2];

        int remain = (maxId - minId + 1) % batchSize;
        int size = 0;
        if (remain == 0) {
            size = (maxId - minId + 1) / batchSize;
        } else {
            size = (maxId - minId + 1) / batchSize + 1;

        }
        result[0] = minId + (index * size);
        result[1] = minId + ((index + 1) * size)-1;

        return result;
    }

}
