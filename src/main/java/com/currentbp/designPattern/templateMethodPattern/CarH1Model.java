package com.currentbp.designPattern.templateMethodPattern;

public class CarH1Model extends CarModel {
    private boolean needAlarm;
    @Override
    protected void start() {
        System.out.println("car1 is start....");
    }

    @Override
    protected void alarm() {
        System.out.println("car1 is alarm....");
    }

    @Override
    protected void stop() {
        System.out.println("car1 is stop....");
    }

    public void setNeedAlarm(boolean needAlarm){
        this.needAlarm = needAlarm;
    }

    @Override
    public void run() {
        this.start();
        if(this.needAlarm) {
            this.alarm();
        }
        this.stop();
    }
}
