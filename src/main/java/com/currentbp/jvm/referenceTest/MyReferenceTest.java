package com.currentbp.jvm.referenceTest;

import org.junit.Test;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.*;

/**
 * @author baopan
 * @createTime 20200608
 */
public class MyReferenceTest {
    private static List<Object> list = new ArrayList<>();

    @Test
    public void t1() {
        testStrongReference();
    }

    @Test
    public void t2() {
        testSoftReference();
    }

    @Test
    public void t3(){
        testWeakReference();
    }

    private static void testStrongReference() {
        // 当 new byte为 1M 时，程序运行正常
        /* -Xms2M -Xmx3M -verbose:gc
        java.lang.OutOfMemoryError: Java heap space
        */
        byte[] buff = new byte[1024 * 1024 * 2];
    }

    private static void testSoftReference() {
        for (int i = 0; i < 10; i++) {
            byte[] buff = new byte[1024 * 1024];
            SoftReference<byte[]> sr = new SoftReference<>(buff);
            list.add(sr);
        }

        System.gc(); //主动通知垃圾回收

        for (int i = 0; i < list.size(); i++) {
            Object obj = ((SoftReference) list.get(i)).get();
            System.out.println(obj);
        }
/*
[Full GC (Ergonomics)  2695K->2354K(3584K), 0.0132773 secs]
[GC (Allocation Failure)  2354K->2354K(3584K), 0.0003937 secs]
...
[GC (System.gc())  2266K->2298K(3584K), 0.0002295 secs]
[Full GC (System.gc())  2298K->2266K(3584K), 0.0023250 secs]
null
null
null
null
null
null
null
null
null
[B@39a054a5
打印结果总是只有最后一个对象被保留，其他的obj全都被置空回收了。
这里就说明了在内存不足的情况下，软引用将会被自动回收。
值得注意的一点 , 即使有 byte[] buff 引用指向对象,
且 buff 是一个strong reference, 但是 SoftReference sr 指向的对象仍然被回收了，
这是因为Java的编译器发现了在之后的代码中, buff 已经没有被使用了, 所以自动进行了优化。
 */
    }

    private static void testWeakReference() {
        for (int i = 0; i < 10; i++) {
            byte[] buff = new byte[1024 * 1024];
            WeakReference<byte[]> sr = new WeakReference<>(buff);
            list.add(sr);
        }

        System.gc(); //主动通知垃圾回收

        for(int i=0; i < list.size(); i++){
            Object obj = ((WeakReference) list.get(i)).get();
            System.out.println(obj);
        }
    }


}
