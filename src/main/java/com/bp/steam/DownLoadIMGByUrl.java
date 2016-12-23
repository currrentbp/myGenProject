package com.bp.steam;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;


/**
 * 下载图片
 * @author current_bp
 * @time 20160405
 *
 */
public class DownLoadIMGByUrl {

	//"http://www.imooc.com/static/lib/jwplayer/1.0.0/jwplayer.flash.swf"
	public static void main(String[] args) throws IOException {
		System.out.println(downLoadImgByUrl("http://zuyunfei.com/images/public_key_cryptography.png"));
	}
	
	/**
	 * 根据URL获取图片,文件保存路径System.getProperty("user.home") + "/upload/"下
	 * @param urlStr：图片的URL
	 * @throws IOException
	 */
	public static String downLoadImgByUrl(String urlStr) throws IOException{
		return downLoadImgByUrl(urlStr,System.getProperty("user.home") + "/upload/");
	}
	/**
	 * 根据URL获取图片
	 * @param urlStr：图片的URL
	 * @param savePath：保存路径
	 * @throws IOException
	 */
	public static String downLoadImgByUrl(String urlStr,String savePath) throws IOException{
		long num = new Date().getTime();
		double random = Math.random();
		//文件后缀
		String tail = urlStr.substring(urlStr.lastIndexOf("."));
		String fileName = ""+num+""+random+tail;
		//文件下载路径
		//System.getProperty("user.home") + "/upload/"
		File file = new File(savePath, fileName);
		InputStream is = null;
		HttpURLConnection huc = null;
		
		URL url = new URL(urlStr);
		huc = (HttpURLConnection)url.openConnection();
		//通过指定的URL 获得字节流。
		is = huc.getInputStream();
		
		if(!file.exists()){
			file.createNewFile();
		}
		OutputStream os=new FileOutputStream(file);
		byte[] buffer=new byte[1024];
		System.out.println("It's start .....");
		while(true){
			int len=is.read(buffer);
			if(len==-1){
				System.out.println("It's end!");
				break;
			}
			os.write(buffer, 0, len);
		}
		
		return fileName;
	}
}
