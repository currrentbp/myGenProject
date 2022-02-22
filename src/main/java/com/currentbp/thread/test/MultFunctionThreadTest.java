package com.currentbp.thread.test;

import com.currentbp.util.all.StringUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.function.Function;

/**
 * @author baopan
 * @createTime 20211225
 */
public class MultFunctionThreadTest {

    public static void main(String[] args) {
        CountDownLatch await = new CountDownLatch(3);
        CountDownLatch await2 = new CountDownLatch(3);
        MultFunctionThreadTest multFunctionThreadTest = new MultFunctionThreadTest();
        Map<String, Long> result = new HashMap<>();
        multFunctionThreadTest.do1(await, result);
        multFunctionThreadTest.do2(await, result);
        multFunctionThreadTest.do3(await, result);
        if (await.getCount() <= 0) {
            StringUtil.printObject(result);
        }

    }

    public void do1(CountDownLatch await, Map<String, Long> result) {
        MyRunnable myRunnable = new MyRunnable(await, 10L, (x) -> {
            System.out.println("====" + x);
            result.put("t1", 1L);
            return 1L;
        });
        new Thread(myRunnable).start();
    }

    public void do2(CountDownLatch await, Map<String, Long> result) {
        MyRunnable myRunnable = new MyRunnable(await, 10L, (x) -> {
            System.out.println("====" + x);
            result.put("t2", 2L);
            return 1L;
        });
        new Thread(myRunnable).start();
    }

    public void do3(CountDownLatch await, Map<String, Long> result) {
        MyRunnable myRunnable = new MyRunnable(await, 10L, (x) -> {
            System.out.println("====" + x);
            result.put("t3", 3L);
            return 1L;
        });
        new Thread(myRunnable).start();
    }


    class MyRunnable implements Runnable {
        private CountDownLatch await;
        private Function<Long, Long> func;
        private Long uid ;

        public MyRunnable(CountDownLatch await, Long uid, Function<Long, Long> func) {
            this.await = await;
            this.func = func;
            this.uid = uid;
        }

        @Override
        public void run() {
            try {
                System.out.println("子线程" + Thread.currentThread().getName() + "处理自己事情");
                func.apply(uid);
                await.countDown();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        private void multFunc(Long str, Function<Long, Long> func) {
            Long apply = func.apply(str);
            System.out.println("str:" + str + ",apply:" + apply);
        }
    }
}
