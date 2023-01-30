package com.currentbp.thread.producerConsumer.v2;

/**
 * @author baopan
 * @createTime 20180726
 */
public class ConsumeProduct {

    public static void main(String[] args) {
        Storage storage = new Storage();
        for(int i=0;i< 6;i++){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    storage.consume(10);
                }
            });
            thread.start();
        }
        for(int i=0;i< 6;i++){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    storage.product(10);
                }
            });
            thread.start();
        }
    }
}
