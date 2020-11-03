package com.currentbp.test.other;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * 
 * @author current_bp
 * @createTime 20160819
 *
 */
public class CharsetError {

	public static void main(String[] args) {
		System.out.println("default charset : " + Charset.defaultCharset());
		String str = "abc你好";// string with UTF-8 charset

		byte[] bytes = str.getBytes(Charset.forName("UTF-8"));// convert to byte
																// array with
																// UTF-8 encode
		for (byte b : bytes) {
			System.out.print(b + " ");
		}
		System.out.println();
		try {
			String str1 = new String(bytes, "UTF-8");// to UTF-8 string
			String str2 = new String(bytes, "ISO-8859-1");// to ISO-8859-1
															// string
			String str3 = new String(bytes, "GBK");// to GBK string

			System.out.println(str1);// abc你好
			System.out.println(str2);// abc??????
			System.out.println(str3);// abc浣犲ソ

			System.out.println();
			byte[] bytes2 = str2.getBytes(Charset.forName("ISO-8859-1"));
			for (byte b : bytes2) {
				System.out.print(b + " ");
			}
			System.out.println();
			String str22 = new String(bytes2, "UTF-8");
			System.out.println(str22);// abc你好

			System.out.println();
			byte[] bytes3 = str3.getBytes(Charset.forName("GBK"));
			for (byte b : bytes3) {
				System.out.print(b + " ");
			}
			System.out.println();
			String str33 = new String(bytes3, "UTF-8");
			System.out.println(str33);// abc你好
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

	}

	public static boolean isValidUtf8(byte[] b, int aMaxCount) {

		int lLen = b.length, lCharCount = 0;

		for (int i = 0; i < lLen && lCharCount < aMaxCount; ++lCharCount) {

			byte lByte = b[i++];// to fast operation, ++ now, ready for the
								// following for(;;)

			if (lByte >= 0)
				continue;// >=0 is normal ascii

			if (lByte < (byte) 0xc0 || lByte > (byte) 0xfd)
				return false;

			int lCount = lByte > (byte) 0xfc ? 5 : lByte > (byte) 0xf8 ? 4
					: lByte > (byte) 0xf0 ? 3 : lByte > (byte) 0xe0 ? 2 : 1;

			if (i + lCount > lLen)
				return false;

			for (int j = 0; j < lCount; ++j, ++i)
				if (b[i] >= (byte) 0xc0)
					return false;

		}

		return true;

	}

	public static String getUrlParam(String aStr, String aDefaultCharset)

			throws UnsupportedEncodingException {

		if (aStr == null)
			return null;

		byte[] lBytes = aStr.getBytes("ISO-8859-1");

		return null;// new String(lBytes, CharsetError.isValidUtf8(lBytes) ? "utf8" : aDefaultCharset);

	}
}
