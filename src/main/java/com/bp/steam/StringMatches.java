package com.bp.steam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
  * @author current_bp
 * @time 20160405s
 * 
 */
public class StringMatches {

	private static String ONE = "49785790f0aba048e55a0289f377edb4";
	private static String PATTERN = "(com/7655/zh-cn/preview/)(\\w{"
			+ ONE.length() + "})(/preview)";

	public static void main(String[] args) {
		String dist = null;
		Pattern p = Pattern.compile(StringMatches.PATTERN);
		String input = "com/7655/zh-cn/preview/11111111111/preview"
				+ "com/7655/zh-cn/preview/22222222222222222222222222222222222222/preview"
				+ "com/7655/zh-cn/preview/49785790f0aba048e55a0289f377edb4/preview";
		Matcher m = p.matcher(input);
		while (m.find()) {
			String g = m.group();
			// System.out.println(g);
			dist = g;
		}
		System.out.println(dist);
	}
}
