package com.currentbp.thread.race;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**使用队列做为锁
 * @author baopan
 * @createTime 20200423
 */
public class BlockingQueuePrint {

    private static BlockingQueue<String> t1 = new ArrayBlockingQueue<String>(1);
    private static BlockingQueue<String> t2 = new ArrayBlockingQueue<String>(1);

}
