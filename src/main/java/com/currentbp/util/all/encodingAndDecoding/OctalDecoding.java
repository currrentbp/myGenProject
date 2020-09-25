package com.currentbp.util.all.encodingAndDecoding;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class OctalDecoding {

    @Test
    public void t1() {
        String source1 = "\\347\\263\\273\\347\\273\\237\\351\\224\\231\\350\\257\\257";
        String s1 = doDecoding4Octal(source1);
        System.out.println(s1);
    }

    /**
     * 8进制的转译：将8进制的字符串转译成正常utf-8的
     */
    public String doDecoding4Octal(String source) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(source.getBytes());
        int read = -1;
        byte[] byte3 = new byte[3];
        while ((read = inputStream.read()) > -1) {
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
