package com.currentbp.util.all.encryption;

import com.currentbp.common.model.Student;
import com.currentbp.util.all.StringUtil;
import org.junit.Test;

/**
 * Created by Administrator on 2017/7/20.
 */
public class AESTest {
    private static AES aes = new AES();

    @Test
    public void encrypt() throws Exception {

        String key = aes.encrypt("[{\"n\":\"中国\",\"timeStamp\":10},{\"n\":\"中国\",\"timeStamp\":10},{\"n\":\"中国\",\"timeStamp\":10}]");
        System.out.println("key:" + key);
        String value = aes.decrypt(key);
        System.out.println("value:" + value);

        String key1 = aes.encrypt("100111112223");
        System.out.println("key1:" + key1);
        String value1 = aes.decrypt(key1);
        System.out.println("value1:" + value1);

        String key2 = aes.encrypt4Default("100111112223");
        System.out.println("key2:" + key2);
        String value2 = aes.decrypt4Default(key2);
        System.out.println("value2:" + value2);
    }

    @Test
    public void encrypt1() throws Exception {
    }

    @Test
    public void encrypt2() throws Exception {
    }

    @Test
    public void decrypt() throws Exception {
    }

    @Test
    public void decrypt1() throws Exception {
    }

    @Test
    public void decrypt2() throws Exception {
    }

    @Test
    public void parseHexStr2Byte() throws Exception {
    }

}