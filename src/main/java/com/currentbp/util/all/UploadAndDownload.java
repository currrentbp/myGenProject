package com.currentbp.util.all;

import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * 上传和下载
 *
 * @author current_bp
 * @createTime 20170113
 */
public class UploadAndDownload {

    /**
     * 通过httpclient 上传一个文件
     * @param url 上传文件的路径
     * @param file 文件路径
     * @return 结果
     */
    public static String fileUpload(String url, File file) {
        System.out.println("===>fileUpload: url:" + url + " file:" + file.getName());
        String result = null;
        HttpClient httpclient = HttpClients.createDefault();

        try {
            HttpPost httppost = new HttpPost(url);

            FileBody bin = new FileBody(file);

            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
            builder.addPart("file", bin);//文件名称
//            builder.addPart("text1", stringBody1);
            HttpEntity entity = builder.build();

            httppost.setEntity(entity);
            HttpResponse response = httpclient.execute(httppost);

            result = EntityUtils.toString(response.getEntity());
            System.out.println("===>fileUpload: result:" + result);


        } catch (Exception e) {

        }

        return result;
    }

    /**
     * 下载一个文件
     * @param url 下载的文件路径
     * @param filePath 保存文件路径
     * @return 结果
     */
    public static String download(String url, String filePath) {
        System.out.println("===>download: url:" + url + " filePath:" + filePath);
        try {
            HttpClient client = HttpClients.createDefault();
            HttpGet httpget = new HttpGet(url);
            HttpResponse response = client.execute(httpget);

            HttpEntity entity = response.getEntity();
            InputStream is = entity.getContent();
            File file = new File(filePath);
            file.getParentFile().mkdirs();
            FileOutputStream fileout = new FileOutputStream(file);
            /**
             * 根据实际运行效果 设置缓冲区大小
             */
            byte[] buffer = new byte[1024];
            int ch = 0;
            while ((ch = is.read(buffer)) != -1) {
                fileout.write(buffer, 0, ch);
            }
            is.close();
            fileout.flush();
            fileout.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) {
        //上传文件
//        UploadAndDownload uploadAndDownload = new UploadAndDownload();
//        uploadAndDownload.fileUpload("http://localhost:8080/uploadController/upload/", new File("E:\\mine\\temp_picture\\201684171424360.jpg"));

        //通用下载文件
        UploadAndDownload uploadAndDownload = new UploadAndDownload();
        uploadAndDownload.download(
                "http://lenews.los-cn-north-1.lecloudapis.com/123/material/123/2017/01/13/6d5f826cb0824658ac5ad81957aed449/test_2.png",
                "E:\\tmp\\baopan.jpg");
    }
}
