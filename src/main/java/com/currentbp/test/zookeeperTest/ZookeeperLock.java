package com.currentbp.test.zookeeperTest;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.junit.Test;

import javax.annotation.PostConstruct;

/**
 * @author baopan
 * @createTime 2020/9/10 23:13
 */
public class ZookeeperLock {

    private ZooKeeper zookeeper;
    @PostConstruct
    public void init(){
        try {
            zookeeper = new ZooKeeper("0.0.0.0:2181", 5000, new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                    System.out.println("============+++++++++++++++++++++++");
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
