package com.currentbp.Interesting.other;

import org.junit.Test;

/**
 * @author baopan
 * @createTime 20190419
 */
public class T1 {
    /*
    1个1个拿，正好拿完。
2个2个拿，还剩1个。
3个3个拿，正好拿完。
4个4个拿，还剩1个。
5个5个拿，还差1个。
6个6个拿，还剩3个。
7个7个拿，正好拿完。
8个8个拿，还剩1个。
9个9个拿，正好拿完。
     */

    @Test
    public void t1(){
        int i=0;
        while(true){
            if(c2(i*3*7)&&c4(i*3*7)&&c5(i*3*7)&&c6(i*3*7)&&c8(i*3*7)&&c9(i*3*7)){
                System.out.println("minNum:"+(i*3*7));
//                return;
            }
            i++;
            if(i>1000000){
                break;
            }
        }
    }
    private boolean c2(int i){
        return 0 == ((i-1)%2);
    }
    private boolean c4(int i){
        return 0 == ((i-1)%4);
    }
    private boolean c5(int i){
        return 0 == ((i+1)%5);
    }
    private boolean c6(int i){
        return 0 == ((i-3)%6);
    }
    private boolean c8(int i){
        return 0 == ((i-1)%8);
    }
    private boolean c9(int i){
        return 0 == (i%9);
    }
}
