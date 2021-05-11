package com.currentbp.designPattern.adapterPattern;

import org.junit.Test;

public class UseAdapterPattern {
    @Test
    public void t1(){
//        IUserInfo userInfo = new UserInfoImpl();
        IUserInfo userInfo = new UseOutUserInfo();

        System.out.println(userInfo.getName());
        System.out.println(userInfo.getPhone());
        System.out.println(userInfo.getFamily());
        System.out.println(userInfo.getAddress());
        System.out.println(userInfo.getLevel());
        System.out.println(userInfo.getLevelName());
    }
}
