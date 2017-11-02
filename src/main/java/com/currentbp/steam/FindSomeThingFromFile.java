package com.currentbp.steam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.currentbp.util.all.StreamUtil;

/**
 * 根据路径,关键字,行数查询需要的内容。
  * @author current_bp
 * @time 20160405
 *
 */
public class FindSomeThingFromFile {
	public StreamUtil myStream = new StreamUtil();

	public static void main(String[] args) throws IOException {
		
		FindSomeThingFromFile test = new FindSomeThingFromFile();
		
		Date start = new Date();
		SimpleDateFormat s1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		System.out.println("start time :"+s1.format(start));
//		test.findOneKey("E:\\descFile.txt","E:\\report3.log", "TO_DAYS(now())-TO_DAYS(initTime)=1", 10);
//		test.findSomeKey("", "", "1|2|3|4", 0);
		
		test.myStream.findKeyWordFromFile("E:\\report3.log", "E:\\descFile.txt", "TO_DAYS(now())-TO_DAYS(initTime)=1", 10);
		Date end = new Date();
		System.out.println("start time :"+s1.format(end));
		
		
	}
	
	/**
	 * 根据keys中的多个关键字查询，例如：2|3|4，其中多个关键字之间是用"|"分割的。
	 * @param keys
	 * @param descPath
	 * @param sourcePath
	 * @param num
	 * @throws IOException 
	 */
	public void findSomeKey(String descPath ,String sourcePath,String keys,int num) throws IOException
	{
		if(null == keys || "".equals(keys)){
			System.out.println("there is no keys ! please check the keys! ");
			return ;
		}
//		System.out.println("|");
		String [] keyArray = keys.split("\\|");
		for(int i = 0;i<keyArray.length; i++)
		{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date startTime = new Date();
			System.out.println("this key is :"+keyArray[i]);
			System.out.println("start time is :"+sdf.format(startTime));
			
			findOneKey(descPath, sourcePath, keyArray[i], num);
			
			Date endTime = new Date();
			System.out.println("end time is :"+sdf.format(endTime));
			
		}
	}
	
	
	/**
	 * 只能对一个关键字查询。
	 * 
	 * @param descPath 生成文件路径
	 * @param path 源文件路径
	 * @param key 查找关键字
	 * @param num 上下文行数
	 * @throws IOException 
	 */
	public void findOneKey(String descPath ,String path,String key,int num) throws IOException{
		
		ArrayList list = new ArrayList();
		
		File sourceFile = new File(path);
		File desFile = new File(descPath);
		
		if(!desFile.exists()){
			desFile.createNewFile();
		}
		
		InputStream is= new FileInputStream(sourceFile);
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStream os = new FileOutputStream(desFile);
		OutputStreamWriter osw = new OutputStreamWriter(os);
		BufferedWriter bw = new BufferedWriter(osw);
		
		String temp = null;
		Pattern pattern = Pattern.compile("("+key+")");
		Matcher matcher = null;
		boolean flag = false;
		int count = num;
		
		
		System.out.println("seacher start ...");
		
		while((temp = br.readLine()) != null)
		{
			list.add(temp);
			matcher = pattern.matcher(temp);
			boolean f1 = false;
			//判断是否存在该关键字段。
			if(f1 = matcher.find() ){
				flag = f1 ;
				
				//如果找到该关键字，打印之前的几行。并清空。
				for(int i =0 ;i< list.size(); i++)
				{
					bw.write(list.get(i)+System.getProperty("line.separator"));
				}
				for(int i= 0;i<list.size();)
				{
					list.remove(0);
				}
			}else
			{
				//如果记录结果的栈超过数量，去除。
				if(list.size() > num )
				{
					list.remove(0);
				}
				//之前找到了相关的信息。
				if(flag)
				{
					if(count != 0)
					{
						bw.write(temp+System.getProperty("line.separator"));
						list.remove(0);
						count --;
						if(count == 0)
						{
							flag = false;
							count = num;
						}
					}else
					{
						
					}
				}
//				System.out.println("is false");
			}
			
		}
		
		bw.flush();
		bw.close();
		
		System.out.println("seacher end !");
		
	}
	
}
