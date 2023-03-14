package com.currentbp.Interesting.other;

import org.junit.Test;

/**
 * @author baopan
 * @createTime 2023/3/14 21:15
 */
public class SpecialSum {

    @Test
    public void t1(){

    }

    public int sum(int[] sources){
        int max = Integer.MIN_VALUE;
        int[] flags = new int[sources.length];
        for(int i=0;i<sources.length;i++){
            flags[i] = 1;
            max = Math.max(max,doSum(sources,flags));
            flags[i] = 0;
        }
        return max;
    }

    private int doSum(int[] sources, int[] flags) {
        for(int i=0;i<sources.length;i++){
            if(flags[i] == 1){
                continue;
            }else{

                break;
            }
        }
        return 0;
    }
}
