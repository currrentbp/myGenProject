package com.currentbp.test;

import java.io.File;
import java.io.RandomAccessFile;

/**
 * 
 * @author current_bp
 * @createTime 20161017
 *
 */
public class FileRandomAccessRW {

	public static void main(String[] args) throws Exception {

		RandomAccessFile localRandomAccessFile = new RandomAccessFile(new File("e:\\bp1.txt"), "r");
		localRandomAccessFile.getChannel();
		byte[] arrayOfByte = new byte[1024];
		int readSize = 0;
		while ((readSize = localRandomAccessFile.read(arrayOfByte)) == -1) {
			System.out.println("====" + readSize);
		}
		
		while(true){
			readSize = localRandomAccessFile.read(arrayOfByte);
			if(readSize == -1){
				new Thread().yield();;
			}else{
				System.out.println("readSize:"+readSize);
			}
		}
	}


}
