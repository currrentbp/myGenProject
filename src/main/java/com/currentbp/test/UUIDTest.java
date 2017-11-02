package com.currentbp.test;

import java.util.UUID;

import com.currentbp.util.all.StringUtil;

/***
 * 测试UUID
 * @author current_bp
 * @createTime 20160621
 *
 */
public class UUIDTest {

	public static void main(String[] args) {
		String uuid = UUID.randomUUID().toString();
//		for(int i=0;i<1000;i++){
//			System.out.println("uuid:"+UUID.randomUUID());
//		}
		System.out.println("uuid:"+uuid);
		String ll = StringUtil.getStringWithOutSome(uuid, "-");
		System.out.println("ll:"+ll);
		System.out.println("length:"+ll.length());
	}
}
