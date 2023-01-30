package com.currentbp.thread.producerConsumer.v20230130;

import java.util.Random;

/**
 * @author baopan
 * @createTime 1/30/2023 9:20 AM
 */
public class Consumer0130 {

    public void consumerThing(Store0130 store) {
        new Thread(() -> {
            int timer = 10;
            while (timer > 0) {
                int num = new Random().nextInt(5) + 1;
                int flag = store.subCount(num);
                System.out.println("消费者取出" + num + "个产品" + (flag == 1 ? "成功" : "失败") + " timer:" + timer + " flag:" + flag);
                timer--;
            }
        }).start();
    }
}
