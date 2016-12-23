package com.bp.test;
import java.net.*;



import java.io.*;

/**
 * 
 * @author current_bp
 * @time 20160405
 *
 */
public class DownLoadHtmlSomeThine {

	
	public static void main(String[] args) {
	   String s = GetPageContent("http://online.bankcomm.com:8080/images/wxtg/555555.jpg");
	   System.out.println(s);
	}

	public static String GetPageContent(String pageURL) 
	{
		String pageContent="";
		BufferedReader in = null;
		InputStreamReader isr = null;
		InputStream is = null;
		PrintWriter pw=null;
		HttpURLConnection huc = null;
		try
		{
		 URL url = new URL(pageURL);
		 huc = (HttpURLConnection)url.openConnection();
		 is = huc.getInputStream();
		 isr = new InputStreamReader(is);
		 in = new BufferedReader(isr);
		 String line = null;
		 while(((line = in.readLine()) != null)) 
		 {
			if(line.length()==0)
				continue;
			pageContent+=line;
		  }    
		}
		catch (Exception e) 
		{
			  System.err.println(e);
		}
		finally 
		{ 
			  try 
			  {
				  is.close(); isr.close();in.close();huc.disconnect();pw.close();    
			  } 
			  catch (Exception e) {}
		}
	    return pageContent;
	}
}
