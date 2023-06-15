package com.currentbp.test.baseStructTest;

/**
 * @author baopan
 * @createTime 2023-06-14 11:45:02
 */
public class SynchronizeTest {
    public static void main(String[] args) {
        Object lockObject = new Object();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                synchronized (lockObject) {
                    try {
                        System.out.println("threadName:" + Thread.currentThread().getName() + " sleep...");
                        lockObject.notifyAll();
                        lockObject.wait();
                        Thread.sleep(1000);
                        System.out.println("threadName:" + Thread.currentThread().getName() + " sleep end");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, "thread" + i).start();
        }

        try{
            Thread.sleep(20000);
            lockObject.notifyAll();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
