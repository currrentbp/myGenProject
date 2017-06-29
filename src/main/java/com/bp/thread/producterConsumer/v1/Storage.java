package com.bp.thread.producterConsumer.v1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 仓库
 *
 * @author current_bp
 * @createTime 20170626
 */
public class Storage {

    private static Logger logger = LoggerFactory.getLogger(Storage.class);

    private final int Max_Num = 100;
    private volatile int now_num = 0;

    private Object lock = new Object();


    public void product(int count) {
        synchronized (lock) {
            while (now_num + count > 100) {
                logger.info("===>生产者：生产数量：" + count + " 当前数量：" + now_num + " 等待生产中。。。。。");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


            now_num = now_num + count;
            logger.info("===>生产者：生产数量：" + count + " 生产后的数量：" + now_num);
            lock.notifyAll();

        }
    }

    public void consume(int count) {
        synchronized (lock) {
            while (now_num - count < 0) {
                logger.info("===>消费者：消费数量：" + count + " 当前数量：" + now_num + " 等待消费中。。。。。");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            now_num = now_num - count;
            logger.info("===>消费者：消费数量：" + count + " 消费后的数量：" + now_num);
        }
    }
}
