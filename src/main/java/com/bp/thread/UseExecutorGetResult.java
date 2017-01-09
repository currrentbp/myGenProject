package com.bp.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 通过callable获取线程返回的结果
 *
 * @author current_bp
 * @createTime 20170109
 */
public class UseExecutorGetResult {

    private final ExecutorService executorService = Executors.newFixedThreadPool(10);
    private List<String> list = new ArrayList<String>();
    private static int count = 1;

    public static void main(String[] args) {
        UseExecutorGetResult useExecutorGetResult = new UseExecutorGetResult();
        //这个例子没有考虑线程安全问题，只是单纯的通过线程拿到数据的demo
        useExecutorGetResult.getResult();
        useExecutorGetResult.getResult();
        useExecutorGetResult.getResult();
        useExecutorGetResult.getResult();
        //必须手动关闭线程池
        useExecutorGetResult.executorService.shutdown();

        /*
        list1:[baopan1]
list1:[baopan1, baopan2]
list1:[baopan1, baopan2, baopan3]
list1:[baopan1, baopan2, baopan3, baopan4]
//主线程一直没有关闭
         */
    }

    public void getResult() {


        Callable<List<String>> task = new Callable<List<String>>() {
            @Override
            public List<String> call() throws Exception {
                list.add("baopan" + count);
                count++;
                return list;
            }
        };

        Future<List<String>> future = executorService.submit(task);

        try {
            List<String> list1 = future.get();
            System.out.println("list1:" + list1 + " hashCode:" + list1.hashCode());

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
