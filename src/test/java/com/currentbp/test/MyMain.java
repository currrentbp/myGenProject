package com.currentbp.test;

import com.alibaba.fastjson2.JSON;

/**
 * @author baopan
 * @createTime 20200515
 */
public class MyMain {

    public static void main(String[] args) {
        System.out.println("=============");
        try {
            synchronized (MyMain.class) {
                MyMain.class.wait();
                System.out.println("++++++++111111111111++++++");
            }
        } catch (Exception e) {
            System.out.println("===>" + e.getMessage()+" other:"+ JSON.toJSONString(e));
        }
        System.out.println("++++++++++++++");
    }
}
