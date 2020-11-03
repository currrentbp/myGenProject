package com.currentbp.test.other;

import com.alibaba.fastjson.JSON;
import com.currentbp.sort.BigSort;
import com.currentbp.util.all.RandomUtil;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * 排序测试
 *
 * @author current_bp
 * @createTime 20170607
 */
public class SortTest {

    private static Logger logger = LoggerFactory.getLogger(SortTest.class);

    @Test
    public void java8Sort(){
        List<String> sorts = Lists.newArrayList("失败","成功","失败","成功");
        System.out.println(JSON.toJSONString(sorts));
        sorts.sort((o1,o2)->o1.compareTo(o2));
        System.out.println(JSON.toJSONString(sorts));
    }

    /*
    需时测试：
    arrayListSort: 100000000 :insert time:3900  sort time:75554 insertAndSort time:79454
    bigSort: 100000000 :insert need time:15392
    结论：arrayListSort排序时插入和排序不是同时操作，所以耗时，
        bigSort排序时，插入时就直接排序了
     */
    @Test
    public void arrayListSort() {
        Long time1 = System.currentTimeMillis();
        List<Integer> list = new ArrayList();
        for (int i = 0; i < 100000000; i++) {
            list.add(RandomUtil.getRandomNum(100));
        }
        Long time2 = System.currentTimeMillis();
        logger.info("===>insert time:" + (time2 - time1));

        Long time3 = System.currentTimeMillis();
        Arrays.sort(list.toArray());
        Long time4 = System.currentTimeMillis();
        logger.info("===>sort time:" + (time4 - time3));


    }

    @Test
    public void bigSort() {
        Long time1 = System.currentTimeMillis();
        BigSort bigSort = new BigSort();
        for (int i = 0; i < 100000000; i++) {
            bigSort.put(RandomUtil.getRandomNum(100));
        }
        Long time2 = System.currentTimeMillis();
        logger.info("insert need time:" + (time2 - time1));

        Long time3 = System.currentTimeMillis();
        for (int i = 0; i <= bigSort.getMaxValue(); i++) {
            int count = bigSort.get(i);
            if (count != 0) {
                for (int j = 0; j < count; j++) {
                }
            }
        }
        System.out.println();
        Long time4 = System.currentTimeMillis();
        logger.info("print need time:" + (time4 - time3));
    }


}
