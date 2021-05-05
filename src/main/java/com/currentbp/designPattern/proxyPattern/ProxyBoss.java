package com.currentbp.designPattern.proxyPattern;

/**
 * @author baopan
 * @createTime 20210505
 */
public class ProxyBoss {

    private ProxyJob proxyJob;
    public ProxyBoss (){
        this.proxyJob = new ProxyWorker();
    }
    public void doJobOne(){
        proxyJob.doJobOne();
    }
    public void doJobTwo(){
        proxyJob.doJobTwo();
    }

}
