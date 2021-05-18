package com.currentbp.designPattern.templateMethodPattern;

import com.currentbp.util.all.TimeUtil;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UseCar {

    @Test
    public void t1(){
        CarH1Model carH1Model = new CarH1Model();
        carH1Model.setNeedAlarm(false);
        carH1Model.run();
    }

    @Test
    public void t2(){
        CarH2Model carH2Model = new CarH2Model();
        carH2Model.run();
    }

    @Test
    public void t3(){
        String time;
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyyMMddHHmmsss");
        time = s.format(d);
        System.out.println(time);
        System.out.println(Long.parseLong(time));
    }
}
