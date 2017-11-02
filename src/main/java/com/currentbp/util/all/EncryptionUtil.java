package com.currentbp.util.all;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.security.MessageDigest;

/**
 * 加密工具
 *
 * @author current_bp
 * @createTime 20161109
 */
public class EncryptionUtil {

    public static void main(String[] args) throws Exception {

        System.out.println(EncryptionUtil.md5_32("baopan"));
    }


    /**
     * 获取md5加密数据
     *
     * @param resource
     * @return
     * @throws Exception
     */
    public static String md5_32(String resource) throws Exception {
        CheckUtil.isEmpty("md5_resource", resource);

//        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {

            byte[] btInput = resource.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            System.out.println("加密前：" + resource + " 加密后：" + new String(str));
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }


    /**
     * 将字符串加密成base64
     *
     * @param resource
     * @return
     */
    public static String base_64_Encoder(String resource) {
        String ret = null;
        ret = new BASE64Encoder().encode(resource.getBytes());
        System.out.println("加密前:" + resource + " 加密后:" + ret);
        return ret;
    }

    /**
     * 将base64的密码解密
     *
     * @param resource
     * @return
     */
    public static String base_64_Decoder(String resource) {
        String ret = null;
        try {
            ret = new String(new BASE64Decoder().decodeBuffer(resource));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ret;
    }

}
