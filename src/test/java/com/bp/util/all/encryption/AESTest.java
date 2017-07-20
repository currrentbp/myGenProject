package com.bp.util.all.encryption;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/7/20.
 */
public class AESTest {
    private static AES aes = new AES();
    @Test
    public void encrypt() throws Exception {

        String key = aes.encrypt("[{\"n\":\"中国\",\"timeStamp\":10},{\"n\":\"中国\",\"timeStamp\":10},{\"n\":\"中国\",\"timeStamp\":10}]");
        System.out.println(key);
        String value =  aes.decrypt(key);
        System.out.println(value);

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