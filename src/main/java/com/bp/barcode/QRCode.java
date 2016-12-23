package com.bp.barcode;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
//
//import com.google.zxing.BarcodeFormat;
//import com.google.zxing.BinaryBitmap;
//import com.google.zxing.EncodeHintType;
//import com.google.zxing.MultiFormatReader;
//import com.google.zxing.MultiFormatWriter;
//import com.google.zxing.Result;
//import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
//import com.google.zxing.client.j2se.MatrixToImageWriter;
//import com.google.zxing.common.BitMatrix;
//import com.google.zxing.common.HybridBinarizer;
//import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**
 * 
 * @author current_bp
 * @createTime 20161026
 *
 */
public class QRCode {

//	/*
//	 * 生成一个二维码
//	 */
//
//	public static void main(String[] args) throws Exception {
//
////		QRCode.createQRCode();
//		QRCode.parseQRCode();
//
//	}
//
//	public static void parseQRCode() throws Exception{
//		MultiFormatReader mfr = new MultiFormatReader();
//
//		BufferedImage img = ImageIO.read(new File("E:\\tmp\\baopan3.png"));
//		//如果清晰度不够，则直接报错//Exception in thread "main" com.google.zxing.NotFoundException
//
//		BinaryBitmap bbm = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(img)));
//
//		Map hints = new HashMap();
//		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
//
//		Result result  = mfr.decode(bbm, hints);
//
//		System.out.println("result:"+result.toString());
//		System.out.println("text:"+result.getText());
//	}
//
//	public static void createQRCode() throws Exception{
//		int height = 300;
//		int width = 300;
//		String content = "I LOVE YOU";
//		String format = "png";
//
//		Map hints = new HashMap();
//		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
//		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
//		hints.put(EncodeHintType.MARGIN, 2);
//
//		BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height,hints);
//
//		MatrixToImageWriter.writeToFile(bitMatrix, format, new File("E:\\tmp\\barcode.png"));
//	}
}
