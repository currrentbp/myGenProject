package com.currentbp.util.all.encodingAndDecoding;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class HexDecoding {


    @Test
    public void t2() {
        String source = "\u76fc\u76fc";
        String s = doDecoding4HexString(source);
        System.out.println(s);
    }


    /**
     * 将16进制的字符串转译成常见的utf-8格式的字符串
     */
    public String doDecoding4HexString(String source) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(source.getBytes());

        int read = -1;
        byte[] byte3 = new byte[4];
        while ((read = inputStream.read()) > -1) {
            System.out.println("read:"+read);
            if (read == '\\') {
                try {
                    inputStream.read(byte3);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                outputStream.write(Integer.parseInt(new String(byte3), 8));
            } else {
                outputStream.write(read);
            }
        }
        String decodeMessage = null;
        try {
            decodeMessage = new String(outputStream.toByteArray(), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decodeMessage;
    }
}
