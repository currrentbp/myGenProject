package com.bp.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 通过callable获取线程返回的结果
 * @author current_bp
 * @createTime 20170109
 */
public class UseExecutorGetResult {

    private final ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String [] args){
        UseExecutorGetResult useExecutorGetResult = new UseExecutorGetResult();
        useExecutorGetResult.getResult();
    }

    public void getResult(){
        final List<String> list = new ArrayList<>();

        Callable<List<String>> task = new Callable<List<String>>() {
            @Override
            public List<String> call() throws Exception {
                list.add("baopan1");
                return list;
            }
        };

        Future<List<String>> future = executorService.submit(task);

        try {
            List<String> list1 = future.get();
            System.out.println("list1:"+list1);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
