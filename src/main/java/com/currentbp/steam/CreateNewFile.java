package com.currentbp.steam;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 
  * @author current_bp
 * @time 20160405
 *
 */
public class CreateNewFile {
	
	public static void main(String[] args) throws IOException {
//		File file = new File("F:\\5555.jpg");
//		
//		
//		if(file.exists())
//		{
//			System.out.println("this file is null");
//		}else 
//		{
//			file.createNewFile();
//			System.out.println("this file is not null");
//		}
		CreateNewFile test = new CreateNewFile();
		test.createMyNewFile("F:\\\\123\\344\\ss.s");
	}
	
	/**
	 * 生成新文件。
	 * @param path 包括文件路径。格式，如：F:\\123\\344\\ss.s
	 */
	public void createMyNewFile(String path){
		File file = new File(path);
		//如果文件不存在。
		if(!file.exists())
		{
			System.out.println("file is not exist!");
			
			ArrayList list = new ArrayList();
			if(System.getProperty("file.separator").equals("\\"))
			{
				for(int i = 0;i< path.split(System.getProperty("file.separator")+
						System.getProperty("file.separator")).length; i++)
				{
					
					list.add(path.split(System.getProperty("file.separator")+System.getProperty("file.separator"))[i]);
				}
				
			}else
			{
				for(int i = 0;i< path.split(System.getProperty("file.separator")).length; i++)
				{
					
					list.add(path.split(System.getProperty("file.separator"))[i]);
				}
			}
			
			String path1 = "";
			for(int i = 0; i< list.size(); i++)
			{
				
				if(!list.get(i).toString().contains(".") && (null != list.get(i) && list.get(i)!= "")){
					path1 = path1 + list.get(i);
					path1 = path1 +System.getProperty("file.separator");
					
				}else{
					break;
				}
			}
			File file2 = new File(path1);
			
			file2.mkdirs();
			
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}

}
