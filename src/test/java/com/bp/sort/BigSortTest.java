package com.bp.sort;

import com.bp.util.all.MathUtil;
import com.bp.util.all.RandomUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

/**
 * bigSort的测试类
 *
 * @author current_bp
 * @createTime 20170607
 */
public class BigSortTest {
    private static Logger logger = LoggerFactory.getLogger(BigSortTest.class);

    @Test
    /*
    10000次：insert need time:20    print need time:60
    100000次：insert need time:57    print need time:300
    1000000次：insert need time:235    print need time:2292
    10000000次：insert need time:2119
    100000000次：insert need time:15699
    1000000000次：insert need time:146378
    1000000000次：insert need time:146378
     */
    public void putAndGet() {

        Long time1 = System.currentTimeMillis();
        BigSort bigSort = new BigSort();
        for (int i = 0; i < 1000000000; i++) {
            bigSort.put(RandomUtil.getRandomNum(100));
        }
        Long time2 = System.currentTimeMillis();
        logger.info("insert need time:" + (time2 - time1));

        Long time3 = System.currentTimeMillis();
        for (int i = 0; i <= bigSort.getMaxValue(); i++) {
            int count = bigSort.get(i);
            if (count != 0) {
                for (int j = 0; j < count; j++) {
                    //System.out.print(i + ",");
                }
            }
        }
        System.out.println();
        Long time4 = System.currentTimeMillis();
        logger.info("print need time:" + (time4 - time3));
    }

}