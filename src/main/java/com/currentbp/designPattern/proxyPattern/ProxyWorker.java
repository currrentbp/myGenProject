package com.currentbp.designPattern.proxyPattern;

public class ProxyWorker implements ProxyJob{
    @Override
    public void doJobOne() {
        System.out.println("doJobOne");
    }

    @Override
    public void doJobTwo() {
        System.out.println("doJobTwo");
    }
}
