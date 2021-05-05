package com.currentbp.designPattern.proxyPattern;

/**
 * @author baopan
 * @createTime 20210505
 */
public class ProxyPatternMain {
    public static void main(String[] args) {
        ProxyBoss proxyBoss = new ProxyBoss();
        proxyBoss.doJobOne();
        proxyBoss.doJobTwo();
    }
}
