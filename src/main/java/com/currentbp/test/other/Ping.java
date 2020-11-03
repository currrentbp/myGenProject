package com.currentbp.test.other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;

/**
 * 测试ping的功能
 * 
 * @author current_bp
 * @createTime 20160516
 */
public class Ping {

	
	
	/**
	 * ping 通网络
	 * @return
	 */
	public static boolean pingLocalHost(){
		return ping("127.0.0.1");
	}
	public static boolean ping(String ipOrAddress){
		boolean result = false;
		
		Runtime runtime = Runtime.getRuntime(); // 获取当前程序的运行进对象
		Process process = null; // 声明处理类对象
		String line = null; // 返回行信息
		InputStream is = null; // 输入流
		InputStreamReader isr = null; // 字节流
		BufferedReader br = null;
		String ip = ipOrAddress;//"www.baidu.com";
		try {
			process = runtime.exec("ping " + ip); // PING
			is = process.getInputStream(); // 实例化输入流
			isr = new InputStreamReader(is);// 把输入流转换成字节流
			br = new BufferedReader(isr);// 从字节中读取文本
			while ((line = br.readLine()) != null) {
				if (line.contains("TTL") || line.contains("ttl")) {
					result = true;
					break;
				}
			}
			is.close();
			isr.close();
			br.close();
			if (result) {
				System.out.println("ping 通  ...");
			} else {
				System.out.println("ping 不通...");
			}
		} catch (IOException e) {
			System.out.println(e);
			runtime.exit(1);
		}
		
		return result;
	}
	public static void main(String[] args) {
		
		// 方法二 下面代码为 JDK1.5 PING的新方法但不能用，因为 该PING请求端口为7 而大型网站会关闭不需要的端口防止入侵
		InetAddress address;
		try {
			address = InetAddress.getByName("www.weibo.com");
			System.out.println("Name: " + address.getHostName());
			System.out.println("Addr: " + address.getHostAddress());
			System.out.println("Reach: " + address.isReachable(3000)); // 是否能通信
																		// 返回true或false
			System.out.println(address.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
