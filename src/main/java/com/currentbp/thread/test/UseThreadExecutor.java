package com.currentbp.thread.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @author current_bp
 * @createTime 20170925
 */
public class UseThreadExecutor {
    private final static Logger logger = LoggerFactory.getLogger(UseThreadExecutor.class);
    /*
    假如有Thread1、Thread2、Thread3、Thread4四条线程分别统计C、D、E、F四个盘的大小，所有线程都统计完毕交给Thread5线程去做汇总，应当如何实现？
     */

    @Test
    public void getAllCount() {
        Integer allCount = 0;
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<Future<Integer>> result = new ArrayList<Future<Integer>>();
        for (int i = 0; i < 60; i++) {
            Future<Integer> future = executorService.submit(new PlateThread(i));
            result.add(future);
        }
        while (true) {
            if (result.size() == 0) {
                break;
            }
            for (int i = 0; i < result.size(); i++) {
                try {
                    Integer count = result.get(i).get();
                    if (null != count) {
                        allCount += count;
                        logger.info("===>count:" + count + " allCount:" + allCount);
                        result.remove(i);
                        i--;
                    } else {
                        logger.info("i:" + i + " no result!");
                        continue;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class PlateThread implements Callable {
        private Integer count;

        public PlateThread(Integer count) {
            this.count = count;
        }

        public Integer call() throws Exception {
            int c = 0;
            for(int i=0;i<(10000 + new Random().nextInt(20000));i++){
                c += i;
            }
            return count;
        }
    }
}
