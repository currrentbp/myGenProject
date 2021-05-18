package com.currentbp.designPattern.templateMethodPattern;

public abstract class CarModel {
    protected abstract void start();
    protected abstract void alarm();
    protected abstract void stop();
    abstract void run();
}
