package com.currentbp.test;

import com.currentbp.entry.HttpResultData;
import com.currentbp.util.all.HTTPUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author baopan
 * @createTime 20180530
 */
public class AsynTest {
    private static volatile int index = 0;

    public static int getNext() {
        int result = 0;
        synchronized (AsynTest.class) {
            result = index + 1;
            index++;
        }
        return result;
    }

    public static void main(String[] args) {
        String sf = "====================================++++++++++++++++++++++++++++++++++++++===================================="
                +"sssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss"
                +"ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff"
                +"ssssssssdfffffffffffffffffffffffffffggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg"
                +"11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111"
                +"3333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333";
        for(int i=1;i<=1000;i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    HttpResultData httpResultData = HTTPUtil.postRequest("http://localhost:8080/myWebProject/bp/c1", sf+AsynTest.getNext());
                    System.out.println(httpResultData);
                    if ("error".equals(httpResultData.getBody())) {
                        System.out.println("has error");
                    }
                }
            });
            thread.start();
        }
    }
}
