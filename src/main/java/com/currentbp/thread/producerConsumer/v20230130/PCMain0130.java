package com.currentbp.thread.producerConsumer.v20230130;

import org.junit.Test;

import java.util.Random;

/**
 * @author baopan
 * @createTime 1/30/2023 9:23 AM
 */
public class PCMain0130 {
    @Test
    public void t1(){
        Producer0130 producer0130 = new Producer0130();
        Consumer0130 consumer0130 = new Consumer0130();
        Store0130 store0130 = new Store0130();

        producer0130.produceThing(store0130);
        consumer0130.consumerThing(store0130);

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Producer0130 producer0130 = new Producer0130();
        Consumer0130 consumer0130 = new Consumer0130();
        Store0130 store0130 = new Store0130();

        producer0130.produceThing(store0130);
        consumer0130.consumerThing(store0130);

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
