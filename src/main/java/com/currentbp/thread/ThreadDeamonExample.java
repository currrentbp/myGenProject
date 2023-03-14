package com.currentbp.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @author baopan
 * @createTime 2020/6/20 17:00
 */
public class ThreadDeamonExample {

    public static void main(String[] args) {
          ExecutorService executorService = Executors.newFixedThreadPool(1, new ThreadFactory() {
              @Override
              public Thread newThread(Runnable r) {
                  Thread thread = new Thread(r);
//                  thread.setDaemon(true);
                  return  thread;
              }
          });

        executorService.execute( () -> new ThreadDeamonRunnable());
        System.out.println("====================end===================");
    }

   static class  ThreadDeamonRunnable implements  Runnable{


       @Override
       public void run() {
           try {

               System.out.println("====================run1===================");
//               Thread.sleep(1000);
               System.out.println("====================run2===================");
           } catch (Exception e) {
               e.printStackTrace();
           }
       }
   }


}
