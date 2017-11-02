package com.currentbp.util.all.encryption;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @FileName:MD5Util.java
 * @Description:MD5算法
 * @Author: wzp
 * @Date: 2016年10月12日 下午6:06:34
 * @since: JDK 1.7
 */
public class MD5Util {

    private MD5Util() {
    }

    /**
     * 转换成十六进制
     *
     * @param b 二进制数组
     * @return
     */
    public static String byte2hex(byte[] b) { // 二行制转十六进制字符串
        if (b == null) {
            return "";
        }
        StringBuffer hs = new StringBuffer();
        String stmp = null;
        for (int n = 0; n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0XFF);
            if (stmp.length() == 1) {
                hs.append("0");
            }
            hs.append(stmp);
        }
        return hs.toString();
    }

    /**
     * 计算MD5值
     *
     * @param src 字符串
     * @return
     */
    public static String MD5(String src) {
        if (src == null) {
            return "";
        }
        byte[] result = null;
        try {
            MessageDigest alg = MessageDigest.getInstance("MD5");
            result = alg.digest(src.getBytes("utf-8"));
        } catch (Exception e) {
        }
        return byte2hex(result);
    }

    /**
     * 计算MD5值
     *
     * @param src 二进制数组
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static String MD5(byte[] src) throws NoSuchAlgorithmException {
        if (src == null) {
            return "";
        }
        byte[] result = null;
        MessageDigest alg = MessageDigest.getInstance("MD5");
        result = alg.digest(src);
        return byte2hex(result);
    }

    /**
     * @param src 二进制数组
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static byte[] MD5Bytes(byte[] src) throws NoSuchAlgorithmException {
        byte[] result = null;
        if (src != null) {
            MessageDigest alg = MessageDigest.getInstance("MD5");
            result = alg.digest(src);
        }
        return result;
    }

}
