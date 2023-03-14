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

	同一个Thread不能重复调用start方法。
    一旦线程启动，它就永远不能再重新启动。只有一个新的线程可以被启动，并且只能一次。
    一个可运行的线程或死线程可以被重新启动
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
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
