package com.currentbp.test.other;

import org.junit.Test;

public class T1 {

    @Test
    public void t1(){
        int dynamicMaxPushUserLimit = getDynamicMaxPushUserLimit(1301, 100);
        System.out.println(dynamicMaxPushUserLimit);
    }

    private int getDynamicMaxPushUserLimit(int targetCount, int basePushUser) {
        if(targetCount <= basePushUser){
            return basePushUser;
        }
        int times = targetCount / basePushUser;
        int ret = basePushUser * (1 + (int) Math.floor(Math.log10(times)));
        if (ret < 0 || ret > 1000) {
            ret = 1000;
        }
        return ret;
    }
}
