package com.currentbp.thread.test;

/**
 * @author current_bp
 * @createTime 20170925
 */
public class ThreadStartMore {
    /*
    线程的start运行多次,
    会抛异常：
    Exception in thread "main" java.lang.IllegalThreadStateException
	at java.lang.Thread.start(Thread.java:705)
	at com.currentbp.thread.annotationForTest.ThreadStartMore.main(ThreadStartMore.java:19)
     */
    public static void  main(String[] args){
        Thread thread = new Thread(new Runnable() {
            public void run() {
                System.out.println("thread is running....end !!");
            }
        });

        thread.start();
        thread.start();
        thread.start();
        thread.start();
        thread.start();
        thread.start();
    }
}
