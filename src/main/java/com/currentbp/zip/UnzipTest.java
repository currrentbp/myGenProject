package com.currentbp.zip;

import net.lingala.zip4j.exception.ZipException;
import org.junit.Test;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author baopan
 * @createTime 20181119
 */
public class UnzipTest {

    @Test
    public void unzip() {

    }

    class PasswordStorage {
        String nums = "0123456789";
        Queue<String> queue = new LinkedList();
        int max = 10;
        Object lock = new Object();
        int currentLen = 1;
        int maxLen = 5;
        int index = 0;
        String pwd = "";


        public void product() {
            synchronized (lock) {
                while (true) {
                    if (queue.size() <= max) {
                        pwd = genPWD(currentLen, maxLen, pwd, index);
                        if (null == pwd) {
                            break;
                        }
                        index = (index + 1) / 10;
                        lock.notifyAll();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                        }
                    }
                }
            }
        }

        public void consume() {
            synchronized (lock) {
                while (true) {
                    if (queue.size() > 0) {
                        try {
                            String password = queue.poll();
                            File[] unzip = CompressUtil.unzip("C:\\Users\\Administrator\\Desktop\\annotationForTest\\MallDiyMessage.zip", password);
                            System.out.println("密码：" + password);
                        } catch (ZipException e) {
                            e.printStackTrace();
                        }
                        lock.notifyAll();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                        }
                    }
                }
            }
        }

        private String genPWD(int len, int maxLen, String pwd, int index) {
            if (pwd.length() > maxLen) {
                return null;
            }
            //todo not work
            return pwd;
        }
    }
}
