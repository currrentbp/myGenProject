package com.currentbp.thread.producterConsumer.v2;

/**
 * @author baopan
 * @createTime 20180726
 */
public class Storage {

    private Integer max_num = 100;
    private volatile Integer num = 0;
    private Object lock = new Object();

    public void product(int n) {
        synchronized (lock) {
            while (num + n > max_num) {
                System.out.println("===>仓库数量:" + num + " 无法添加:" + n);
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            num += n;
            System.out.println("===>仓库数量:" + num + " 添加的数量:" + n);
            lock.notifyAll();
        }
    }

    public void consume(int n) {
        synchronized (lock) {
            while (num - n < 0) {
                System.out.println("===>仓库数量:" + num + " 无法消费:" + n);
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            num -= n;
            System.out.println("===>仓库数量:" + num + " 消费的数量:" + n);
            lock.notifyAll();
        }
    }

}
