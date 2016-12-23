package com.bp.steam;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


/**
 * 
 * @author current_bp
 * @time 20160405
 *
 */
public class PutFileToSomeSpace {

	public static void main(String[] args) {
		PutFileToSomeSpace test = new PutFileToSomeSpace();
		test.putFileToSomeSpace("F:\\ssss112233.jpg", "112.65.46.59:871/images/2014-08/ssss112233.jpg");
	}
	
	public void putFileToSomeSpace(String sourcePath,String descPath)
	{
		System.out.println("is start");
		File file = new File(descPath);
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try {
			InputStream input = new FileInputStream(sourcePath);
			FileOutputStream output = new FileOutputStream(file);
			byte[] b = new byte[1024];
			while (input.read(b) != -1) {
				output.write(b);
				b = new byte[1024];
			}
			output.flush();
			output.close();
			input.close();
			} catch (FileNotFoundException e) {
					e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		System.out.println("is end!");
		
	}
	
//	//保存图片
//    private void saveImg(HttpServletRequest request,FormFile imgFile,FileForm fileForm){
//        if (imgFile != null && imgFile.getFileSize() > 0) {
//            String fileName = imgFile.getFileName();
//            String sqlPath = "img/" + fileName;
//            //图片所在路径
//            String savePath = request.getSession().getServletContext().getRealPath("/")+ "img\\" + fileName;
//            System.out.println(fileName);
//            System.out.println(sqlPath);
//            System.out.println(savePath);
//            HttpSession session=request.getSession();
//            session.setAttribute("savePath", savePath);
//            session.setMaxInactiveInterval(60*60);
//            //String savePath1=(String)session.getAttribute("savePath");
//            // 数据库
//            fileForm.getFile().setFileEmpPhoto(sqlPath);
//            // 文件
//            try {
//                InputStream input = imgFile.getInputStream();
//                FileOutputStream output = new FileOutputStream(savePath);
//                byte[] b = new byte[1024];
//                while (input.read(b) != -1) {
//                    output.write(b);
//                    b = new byte[1024];
//                }
//                output.close();
//                input.close();
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
