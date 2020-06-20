package com.currentbp.thread.threadLocal;

import org.junit.Test;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * @author baopan
 * @createTime 2020/6/18 15:39
 */
public class ThreadLocalTestWeak {
    /**
     * 测试ThreadLocal由于内存不足会不会直接回收内存
     */

    private static ThreadLocal<List<Object>> local = new ThreadLocal<>();

    private static List<ThreadLocal<Object>> locals = new ArrayList<>();


    @Test
    public void t2(){
        //-Xms2M -Xmx3M -verbose:gc
        testThreadLocalWeak2();
    }
    private void testThreadLocalWeak2(){
        for(int i=0;i<10;i++){
            byte[] buff = new byte[1024 * 1024];
            ThreadLocal threadLocal = new ThreadLocal();
            threadLocal.set(buff);

            locals.add(threadLocal);
        }

        System.gc();
        for (ThreadLocal<Object> objectThreadLocal : locals) {
            System.out.println(objectThreadLocal.get());
        }

    }

    @Test
    public void t1(){
        testThreadLocalWeak();
    }

    private void testThreadLocalWeak(){
        List<Object> list = new ArrayList<>();
        local.set(list);

        for(int i=0;i<10;i++){
            byte[] buff = new byte[1024 * 1024];
            list.add(buff);
        }

        System.gc();

        List<Object> objects = local.get();
        objects.forEach(System.out::println);

    }


}
