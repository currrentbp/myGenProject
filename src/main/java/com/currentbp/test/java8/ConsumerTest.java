package com.currentbp.test.java8;

import org.junit.Test;

import java.util.function.Consumer;

/**
 * @author baopan
 * @createTime 2020/9/26 16:02
 */
public class ConsumerTest {
    @Test
    public void t1(){
        int x = 1;
        useConsumer(x,y->{System.out.println(y);});
    }

    private void useConsumer(int id, Consumer<Integer> consumer){

        if(id == 1){
            consumer.accept(id);
        }

    }

}
