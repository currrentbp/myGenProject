package com.currentbp.thread.test;


import org.assertj.core.util.Lists;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;


public class ProcessComplete {
    private final static Logger log = LoggerFactory.getLogger(ProcessComplete.class);
    private ThreadLocal<DecimalFormat> decimalFormatThreadLocal = ThreadLocal.withInitial(() -> new DecimalFormat("##.##%"));
    private ExecutorService executorService = Executors.newFixedThreadPool(5);

    @Test
    public void t1() {
        importFictionsToBranch1(Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        try {
            Thread.sleep(10 * 1000);
        } catch (Exception e1) {
            log.info("sleep is error2222");
        }
    }

    /**
     * 测试多线程完成任务，并记录任务进度
     */
    public void importFictionsToBranch1(List<Integer> list) {
        AtomicInteger totalSize = new AtomicInteger(list.size());
        AtomicInteger finishSize = new AtomicInteger(0);
        executorService.submit(() -> {
            long startTime = System.currentTimeMillis();
            try {
                list.stream().parallel().forEach(fictionId -> {
                    try {
                        int i = new Random().nextInt(5);
                        Thread.sleep(10 + i);
                    } catch (Exception e1) {
                        log.info("sleep is error,fictionId:{}", fictionId);
                    }
                    String process = decimalFormatThreadLocal.get().format((float) finishSize.incrementAndGet() / (float) totalSize.get());
                    log.info("totalSize :{} ,finishSize :{} ,process: {} ", totalSize.get(), finishSize.get(), process);
                });
                if (totalSize.get() == finishSize.get()) {
                    log.info("end, totalSize :{} ,finishSize :{}", totalSize.get(), finishSize.get());
                }
            } catch (Exception e) {
//                log.error("import fiction to branch fail!", e);
            } finally {
//                log.info("import fictions use {} ms, fiction: {}", System.currentTimeMillis() - startTime, list);
            }
        });
    }

    public void importFictionsToBranch2(List<Integer> list) {
        AtomicInteger totalSize = new AtomicInteger(list.size());
        AtomicInteger finishSize = new AtomicInteger(0);
        executorService.submit(() -> {
            long startTime = System.currentTimeMillis();
            try {
                list.forEach(fictionId -> {
                    try {
                        int i = new Random().nextInt(5);
                        Thread.sleep(10 + i);
                    } catch (Exception e1) {
                        log.info("sleep is error,fictionId:{}", fictionId);
                    }
                    String process = decimalFormatThreadLocal.get().format((float) finishSize.incrementAndGet() / (float) totalSize.get());
                    log.info("totalSize :{} ,finishSize :{} ,process: {} ", totalSize.get(), finishSize.get(), process);
                    decimalFormatThreadLocal.remove();
                });
            } catch (Exception e) {
                log.error("import fiction to branch fail!", e);
            } finally {
                log.info("import fictions use {} ms, fiction: {}", System.currentTimeMillis() - startTime, list);
            }
        });
    }

    public void importFictionsToBranch3(List<Integer> list) {
        AtomicInteger totalSize = new AtomicInteger(list.size());
        AtomicInteger finishSize = new AtomicInteger(0);
        executorService.submit(() -> {
            long startTime = System.currentTimeMillis();
            try {
                list.stream().parallel().forEach(fictionId -> {
                    try {
                        int i = new Random().nextInt(5);
                        Thread.sleep(10 + i);
                    } catch (Exception e1) {
                        log.info("sleep is error,fictionId:{}", fictionId);
                    }
                    String process = decimalFormatThreadLocal.get().format((float) finishSize.incrementAndGet() / (float) totalSize.get());
                    log.info("totalSize :{} ,finishSize :{} ,process: {} ", totalSize.get(), finishSize.get(), process);
                    decimalFormatThreadLocal.remove();
                });
            } catch (Exception e) {
                log.error("import fiction to branch fail!", e);
            } finally {
                log.info("import fictions use {} ms, fiction: {}", System.currentTimeMillis() - startTime, list);
            }
        });
    }
}
