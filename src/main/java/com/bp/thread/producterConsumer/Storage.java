package com.bp.thread.producterConsumer;

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


    public void product(int count) {
        synchronized (Storage.class) {
            while (now_num + count > 100) {
                //TODO not work
                logger.info("===>");
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


            for (int i = 0; i < count; i++) {

            }

        }
    }
}
