package com.currentbp.thread.producerConsumer.v1;

/**
 * 生产者消费者
 *
 * @author current_bp
 * @createTime 20170629
 */
public class ProducerAndConsumerUseProduct {

    public static void main(String[] args) {
        Storage storage = new Storage();
        Producer producer1 = new Producer(storage);
        Producer producer2 = new Producer(storage);
        Producer producer3 = new Producer(storage);
        Producer producer4 = new Producer(storage);
        Producer producer5 = new Producer(storage);
        Producer producer6 = new Producer(storage);
        Producer producer7 = new Producer(storage);

        Consumer consumer1 = new Consumer(storage);
        Consumer consumer2 = new Consumer(storage);
        Consumer consumer3 = new Consumer(storage);
        Consumer consumer4 = new Consumer(storage);
        Consumer consumer5 = new Consumer(storage);

        producer1.setCount(10);
        producer2.setCount(10);
        producer3.setCount(10);
        producer4.setCount(10);
        producer5.setCount(10);
        producer6.setCount(10);
        producer7.setCount(20);

        consumer1.setCount(20);
        consumer2.setCount(10);
        consumer3.setCount(30);
        consumer4.setCount(10);
        consumer5.setCount(10);


        new Thread(consumer1).start();
        new Thread(consumer2).start();
        new Thread(consumer3).start();
        new Thread(consumer4).start();
        new Thread(consumer5).start();

        new Thread(producer1).start();
        new Thread(producer2).start();
        new Thread(producer3).start();
        new Thread(producer4).start();
        new Thread(producer5).start();
        new Thread(producer6).start();
        new Thread(producer7).start();

    }
}
