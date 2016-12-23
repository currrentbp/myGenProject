package com.bp.util.all;

import java.util.ArrayList;
import java.util.List;

/**
 * 密码生成器
 * 
 * @author current_bp
 * @createTime 20161222
 *
 */
public class PWDGenUtil {

	public String nums = "0123456789";
	public List<String> pwds = new ArrayList<String>();

	public void genPuleNumDic(int len, String path) {
		int index = 0;
		boolean flag = false;
		while (true) {

			for (int j = 0; j < nums.length(); j++) {
				//TODO MEIWC
				if (index != pwds.size() && null != pwds.get(index) && pwds.get(index).length() == len) {
					flag = true;
					break;
				}
				
				if (pwds.size() < Integer.MAX_VALUE) {
					StringBuffer sb = new StringBuffer();
					sb.append(pwds.get(index)).append(nums.charAt(j));

					pwds.add(sb.toString());
				}
			}

			index++;
			if (flag) {
				break;
			}
		}

	}

	public static void main(String[] args) {

		PWDGenUtil pu = new PWDGenUtil();
		pu.genPuleNumDic(3, "");
	}
}
