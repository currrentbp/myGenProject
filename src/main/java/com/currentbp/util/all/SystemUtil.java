package com.currentbp.util.all;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 系统命令集合
 * 
 * @author current_bp
 * @time 20160405
 *
 */
public class SystemUtil {

	public static void main(String[] args) throws IOException {
		// SystemUtil su = new SystemUtil();
		// System.out.println(su.getAllTaskList());

		System.out.println(SystemUtil.getSystemFileSeparator());
	}

	/**
	 * 获得系统的路径分隔符
	 * 
	 * @return
	 */
	public static String getSystemFileSeparator() {
		return System.getProperty("file.separator");
	}

	/**
	 * 获取win的所有的cpu的任务
	 * 
	 * @return
	 */
	public List<String> getAllTaskList() {
		List<String> result = new ArrayList<String>();

		try {
			Process proc = Runtime.getRuntime().exec("tasklist ");
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			String line = null;
			int i = 0;

			while ((line = bufferedReader.readLine()) != null) {
				// if (line.contains("QQ.exe")) {
				// System.out.println("找到了");
				// }

				result.add(i, line);
				i++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}

}
