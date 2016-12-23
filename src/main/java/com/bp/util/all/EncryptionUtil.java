package com.bp.util.all;

import java.security.MessageDigest;

/**
 * 加密工具
 * 
 * @author current_bp
 * @createTime 20161109
 *
 */
public class EncryptionUtil {

	public static void main(String[] args) throws Exception{

		System.out.println(EncryptionUtil.md5_32("baopan"));
	}

	
	/**
	 * 获取md5加密数据
	 * @param resource
	 * @return
	 * @throws Exception
	 */
	public static String md5_32(String resource) throws Exception {
		CheckUtil.isEmpty("md5_resource", resource);

		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
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
			return new String(str);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
}
