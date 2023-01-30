package com.currentbp.thread.producerConsumer.v1;

/**
 * 生产者
 *
 * @author current_bp
 * @createTime 20170629
 */
public class Consumer implements Runnable {

    private int count;
    private Storage storage;


    public Consumer(Storage storage) {
        this.storage = storage;
    }

    public void run() {
        storage.consume(count);
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }
}
