package com.currentbp.jvm.fullGc;

import com.currentbp.common.model.Student;

import java.util.HashMap;
import java.util.Map;

/**
 * @author baopan
 * @createTime 2023/7/2 16:52
 */
public class FullGcTest {
    public static void main(String[] args) {
        FullGcTest fullGcTest = new FullGcTest();
        fullGcTest.doCreateBean(90000);
        fullGcTest.doSleep(10000);
        System.out.println("=====>第一次gc=====");
        System.gc();
        fullGcTest.doCreateBean(91111);
        System.out.println("=====>第二次gc++++++");
        fullGcTest.doSleep(10000);
        System.gc();
        fullGcTest.doSleep(10000);

        fullGcTest.doCreateBean(91111);
        System.out.println("=====>第三次gc++++++");
        fullGcTest.doSleep(10000);
    }

    private void doSleep(int sleepTimes) {
        try {
            Thread.sleep(sleepTimes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void doCreateBean(int count) {
        Map<String, Student> id2StudentMap = new HashMap<>();
        for (int i = 0; i < count; i++) {
            id2StudentMap.put("" + i, new Student(i, "" + i));
        }

    }
}
