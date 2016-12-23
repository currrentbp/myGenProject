package com.bp.test;

/**
 * 获取最后"."的位置，并截取最后的字符串
 * @author current_bp
 * @time 20160405
 *
 */
public class GetLastPosition {

	public static void main(String[] args) {
		String url = "http://www.imooc.com/static/lib/jwplayer/1.0.0/jwplayer.flash.swf";
		
		System.out.println(url.substring(url.lastIndexOf(".")+1));
	}
}
