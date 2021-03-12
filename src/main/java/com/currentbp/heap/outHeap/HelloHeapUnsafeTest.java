package com.currentbp.heap.outHeap;

import org.junit.Test;
import sun.misc.Unsafe;

/**
 * 堆外内存使用：unsafe
 * @author baopan
 * @createTime 20210310
 */
public class HelloHeapUnsafeTest {

    @Test
    public void t1(){
        Unsafe unsafe = Unsafe.getUnsafe();
        unsafe.allocateMemory(1024);
        unsafe.reallocateMemory(1024, 1024);
        unsafe.freeMemory(1024);
    }
}
