package com.currentbp.steam;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

/**
 * 
  * @author current_bp
 * @time 20160405
 * 
 */
public class ImageTypeCheck {

	public static String bytesToHexString(byte[] src) {
		StringBuilder stringBuilder = new StringBuilder();
		if (src == null || src.length <= 0) {
			return null;
		}
		// 将图片的开头的两个字翻译。
		for (int i = 0; i < src.length; i++) {
			System.out.println("src[" + i + "]:" + src[i]);
			int v = src[i] & 0xFF;
			String hv = Integer.toHexString(v);
			if (hv.length() < 2) {
				stringBuilder.append(0);
			}
			stringBuilder.append(hv);
		}
		return stringBuilder.toString();
	}

	public static void main(String[] args) throws IOException {
		String imagePath = "F:/lijinjin.jpg";
		File image = new File(imagePath);
		InputStream is = new FileInputStream(image);
		byte[] bt = new byte[2];
		is.read(bt);
		System.out.println("bt:" + bt);
		System.out.println(bytesToHexString(bt));

		System.out.println("flag:" + isImage(image));
	}

	/**
	 * 通过读取文件并获取其width及height的方式，来判断判断当前文件是否图片，这是一种非常简单的方式。
	 * 
	 * @param imageFile
	 * @return
	 */
	public static boolean isImage(File imageFile) {
		if (!imageFile.exists()) {
			return false;
		}
		Image img = null;
		try {
			img = ImageIO.read(imageFile);
			System.out.println("width:" + img.getWidth(null) + " height:"
					+ img.getHeight(null));
			if (img == null || img.getWidth(null) <= 0
					|| img.getHeight(null) <= 0) {
				return false;
			}
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			img = null;
		}
	}
}