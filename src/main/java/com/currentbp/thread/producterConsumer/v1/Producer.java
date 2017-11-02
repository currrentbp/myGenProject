package com.currentbp.thread.producterConsumer.v1;

/**
 * 生产者
 *
 * @author current_bp
 * @createTime 20170629
 */
public class Producer implements Runnable {

    private int count;
    private Storage storage;

    public Producer(Storage storage) {
        this.storage = storage;
    }

    /**
     */
    public void run() {
        storage.product(count);
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
