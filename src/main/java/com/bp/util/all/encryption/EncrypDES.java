package com.bp.util.all.encryption;


//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

import javax.crypto.*;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

/**
 * cookie 加密解密
 * User: LeviathansX
 * Date: 16/4/3
 * Time: 22:30
 */
public class EncrypDES {
    private static final String DES = "DES";
    //KeyGenerator 提供对称密钥生成器的功能，支持各种算法
    private KeyGenerator keygen;
    //SecretKey 负责保存对称密钥
    private SecretKey deskey;
    //Cipher负责完成加密或解密工作
    private Cipher c;
    //该字节数组负责保存加密的结果
    private byte[] cipherByte;

    public EncrypDES() throws NoSuchAlgorithmException, NoSuchPaddingException {
        Security.addProvider(new com.sun.crypto.provider.SunJCE());
        //实例化支持DES算法的密钥生成器(算法名称命名需按规定，否则抛出异常)
        keygen = KeyGenerator.getInstance(DES);
        //生成密钥
        deskey = keygen.generateKey();
        //生成Cipher对象,指定其支持的DES算法
        c = Cipher.getInstance(DES);
    }

    /**
     * @param args
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     * @throws InvalidKeyException
     */
    public static void main(String[] args) throws Exception {
        EncrypDES encrypDES = new EncrypDES();
        String msg = "xiaye";
        byte[] encontent = encrypDES.Encrytor(msg);
        byte[] decontent = encrypDES.Decryptor(encontent);
//        logger.info("明文是:" + msg);
////        logger.info("加密后:" + new String(encontent));
////        logger.info("解密后:" + new String(decontent));
//        logger.info("加密后:" + URLEncoder.encode(new String(encontent), "utf-8"));
//        logger.info("解密后:" + URLEncoder.encode(new String(decontent), "utf-8"));
    }

    /**
     * 对字符串加密
     *
     * @param str
     * @return
     * @throws InvalidKeyException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     */
    public byte[] Encrytor(String str) throws InvalidKeyException,
            IllegalBlockSizeException, BadPaddingException {
        // 根据密钥，对Cipher对象进行初始化，ENCRYPT_MODE表示加密模式
        c.init(Cipher.ENCRYPT_MODE, deskey);
        byte[] src = str.getBytes();
        // 加密，结果保存进cipherByte
        cipherByte = c.doFinal(src);
        return cipherByte;
    }

    /**
     * 对字符串解密
     *
     * @param buff
     * @return
     * @throws InvalidKeyException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     */
    public byte[] Decryptor(byte[] buff) throws InvalidKeyException,
            IllegalBlockSizeException, BadPaddingException {
        // 根据密钥，对Cipher对象进行初始化，DECRYPT_MODE表示加密模式
        c.init(Cipher.DECRYPT_MODE, deskey);
        cipherByte = c.doFinal(buff);
        return cipherByte;
    }

}
