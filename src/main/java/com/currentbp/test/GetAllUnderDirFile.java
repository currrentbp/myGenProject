package com.currentbp.test;

import java.io.File;

/**
 * 
 * @author current_bp
 * @createTime 20160816
 *
 */
public class GetAllUnderDirFile {

	public static void main(String[] args) {
		File file = new File("E:\\ws\\eclipse_ws\\BaiTing_Src\\lib");
		String[] fileNames = file.list();
		
		for(int i=0;i<fileNames.length;i++){
			System.out.print("lib/"+fileNames[i]);
			if(i%5 == 0){
				System.out.println();
				System.out.print("  ");
			}else{
				System.out.print(" ");
			}
		}
	}
}
