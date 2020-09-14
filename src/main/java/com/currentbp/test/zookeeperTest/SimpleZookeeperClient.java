package com.currentbp.test.zookeeperTest;

import com.currentbp.util.all.StringUtil;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.data.Stat;

import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author baopan
 * @createTime 2020/9/5 11:39
 */
public class SimpleZookeeperClient {


    public static void main(String[] args) {
        try {
            ZooKeeper zookeeper = new ZooKeeper("0.0.0.0:2181", 5000, new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                    System.out.println("============+++++++++++++++++++++++");
                }
            });


            Map<Integer,Integer> map = new Hashtable<>();
            Map<Integer,Integer> map2 = new TreeMap<>();

            //注册监听,每次都要重新注册，否则监听不到
            StringUtil.printObject("===========");
            String result = zookeeper.create("/myDir2", "一生一世".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
            System.out.println(result);
            Thread.sleep(110000);
        }catch (Exception e){
            System.out.println("+++++++++++++");
            e.printStackTrace();
        }
    }


}

