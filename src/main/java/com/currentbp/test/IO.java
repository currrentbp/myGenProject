package com.currentbp.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 从一个文件中读入内容追加输入到另一个文件中，
 * @author current_bp
 * @time 20160405
 *
 */
public class IO {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		
		InputStream is=new FileInputStream("E:\\report20140730.log");
		File file=new File("E:\\report1.log");
		if(!file.exists()){
			file.createNewFile();
		}
		OutputStream os=new FileOutputStream(file,true);
		byte[] buffer=new byte[1024];
		System.out.println("start...");
		while(true){
			int len=is.read(buffer);
			if(len==-1){
				break;
			}
			os.write(buffer, 0, len);
		}
		System.out.println("end !");

	}

}
