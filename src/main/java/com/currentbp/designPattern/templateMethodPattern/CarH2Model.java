package com.currentbp.designPattern.templateMethodPattern;

public class CarH2Model extends CarModel {
    @Override
    protected void start() {
        System.out.println("car2 is start....");
    }

    @Override
    protected void alarm() {
        System.out.println("car2 is alarm....");
    }

    @Override
    protected void stop() {
        System.out.println("car2 is stop....");
    }

    @Override
    public void run() {
        this.start();
        this.alarm();
        this.stop();
    }
}
