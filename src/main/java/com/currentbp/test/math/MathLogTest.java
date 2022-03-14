package com.currentbp.test.math;

import com.currentbp.util.all.MathUtil;
import org.junit.Test;

/**
 * @author baopan
 * @createTime 20210105
 */
public class MathLogTest {

    @Test
    public void t4(){
        String x = " can not join this group, reason:user: staging_100031 already in group: 165576711405569";
        System.out.println(x.contains("already in group"));
    }

    @Test
    public void t1(){
        System.out.println(Math.log10(5));
        System.out.println(((int)Math.floor(Math.log10(5))));
        String x = "2222"+"_"+null;
        System.out.println(x);
    }

    @Test
    public void t2(){
//        System.out.println("中奖概率："+ MathUtil.c(5,32)*MathUtil.c(2,12));
//        System.out.println("中奖概率："+ (MathUtil.c(5,32)*MathUtil.c(2,12))/(1.0*MathUtil.c(5,22)*MathUtil.c(2,8)));
        System.out.println("中奖概率1：21425712  "+(22*21*20*19*18*7*4/(5*4*3*2)));
        System.out.println("中奖概率:  "+(21425712/737352));
        System.out.println("最差中奖概率:  "+(21425712/(27*26*25*24*23*5*9/(5*4*3*2))));
    }

    @Test
    public void t3(){
        double v = MathUtil.compoundInterest(10000, 0.5, 17);
        System.out.println(v);
        double v1 = MathUtil.compoundInterest3(3600, 0, 30, 3600,2);
        System.out.println(v1+" "+3600*30*1.4);
        double v2 = MathUtil.compoundInterest3(10000, 0.04, 27, 10000,2);
        System.out.println(v2);
    }

}
