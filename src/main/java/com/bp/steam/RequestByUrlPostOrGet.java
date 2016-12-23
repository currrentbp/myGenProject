package com.bp.steam;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;



/**
 * 
  * @author current_bp
 * @time 20160405
 *
 */
public class RequestByUrlPostOrGet {
	
	public static void main(String[] args) {
		try {
			getURLContent("http://www.sf-express.com/sf-service-web/service/rate?origin=A110105000&dest=A310115000&weight=11&volume=0&lang=sc&region=cn&translate=");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 程序中访问http数据接口
	 */
	public static String getURLContent(String urlStr) {
		/** 网络的url地址 */
		URL url = null;
		/** http连接 */
		HttpURLConnection httpConn = null;
		/** 输入流 */
		BufferedReader in = null;
		StringBuffer sb = new StringBuffer();
		try {
			url = new URL(urlStr);
			in = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
			String str = null;
			while ((str = in.readLine()) != null) {
				sb.append(str);
			}
		} catch (Exception ex) {

		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
			}
		}
		String result = sb.toString();
		System.out.println(result);
		return result;
	}

	/**
	 * post方式请求http服务
	 * 
	 * @param urlStr
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public static String getURLByPost(String urlStr, String params) throws Exception {
		URL url = new URL(urlStr);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setDoOutput(true);
		conn.setDoInput(true);
		PrintWriter printWriter = new PrintWriter(conn.getOutputStream());
		printWriter.write(params);
		printWriter.flush();
		BufferedReader in = null;
		StringBuilder sb = new StringBuilder();
		try {
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			String str = null;
			while ((str = in.readLine()) != null) {
				sb.append(str);
			}
		} catch (Exception ex) {
			throw ex;
		} finally {
			try {
				conn.disconnect();
				if (in != null) {
					in.close();
				}
				if (printWriter != null) {
					printWriter.close();
				}
			} catch (IOException ex) {
				throw ex;
			}
		}
		return sb.toString();
	}
}
