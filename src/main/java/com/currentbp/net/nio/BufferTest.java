package com.currentbp.net.nio;

import org.junit.Test;

import java.nio.IntBuffer;

public class BufferTest {

    @Test
    public void t1(){
        IntBuffer allocate = IntBuffer.allocate(3);
        for(int i=0;i<allocate.capacity();i++){
            allocate.put(i+1);
        }

        allocate.flip();//读写切换，如果写入完成后，可以切换后就能读取了
        while (allocate.hasRemaining()){
            System.out.println(allocate.get());
        }
    }
}
