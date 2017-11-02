package com.currentbp.steam;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;


/**
 * 获取properties文件的信息
  * @author current_bp
 * @time 20160405
 *
 */
public class GetPropertiesFileInfo {
	
	public static Properties propertis = null;
	public static void main(String[] args) {
		try {
			// getURLContent("http://www.sf-express.com/sf-service-web/service/rate?origin=A110105000&dest=A310115000&weight=11&volume=0&lang=sc&region=cn&translate=");
		} catch (Exception e) {
			e.printStackTrace();
		}
//		System.out.println(getProperties().getProperty("queryShunfengMoney"));
//		System.out.println(getProperties().getProperty("K2"));
//
//		System.out.println("path:" + getProjectPath());
		
		GetPropertiesFileInfo.setPropertis("currentbp", "bp1","xiugaile");

	}
	
	/**
	 * 修改propertis文件的值
	 * @param key
	 * @param value
	 */
	public static void setPropertis(String key,String value){
		setPropertis("config.properties",key,value,null);
	}
	/**
	 * 修改propertis文件的值
	 * @param key
	 * @param value
	 * @param comments 属性文件的前端增加描述，不是该属性前加
	 */
	public static void setPropertis(String key,String value,String comments){
		setPropertis("config.properties",key,value,comments);
	}
	/**
	 * 修改propertis文件的值
	 * @param proName 文件名称
	 * @param key
	 * @param value
	 * @param comments 属性文件的前端增加描述，不是该属性前加
	 */
	public static void setPropertis(String proName,String key,String value,String comments){
		String fullName = getProjectPath() + "/" + proName;
		FileOutputStream fos = null ;
		if(null == propertis){
			propertis = getProperties();
		}
		propertis.setProperty(key, value);
		
		try {
			fos = new FileOutputStream(fullName);
			propertis.store(fos,comments);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(null !=fos){
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	/**
	 * 获取项目路径
	 * 
	 * @return
	 */
	public static String getProjectPath() {
		return System.getProperty("user.dir");
	}

	/**
	 * 获取配置文件的信息
	 * 
	 * @return
	 */
	public static Properties getProperties() {
		return getProperties("config.properties");
	}

	/**
	 * 获取配置文件中的信息 "config.properties"
	 * 
	 * @param proName
	 * @return
	 */
	public static Properties getProperties(String proName) {
		String fullName = getProjectPath() + "/" + proName;
		FileInputStream fis = null;
		Properties pro = new Properties();
		try {
			fis = new FileInputStream(fullName);
			pro.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(null != fis){
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		propertis = pro;

		return pro;
	}
}
