package com.bp.util.all;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 关于http的
 *
 * @author current_bp
 * @createTime 20170112
 */
public class HTTPUtil {

    public static void main(String[] args) {
        HTTPUtil httpUtil = new HTTPUtil();
        try {
            httpUtil.downLoad();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void downLoad() throws IOException {
        String url = "http://lenews.los-cn-north-1.lecloudapis.com/123/material/123/2017/01/10/3779763260924787964f86cdc9444e07/我的素材.png";
        String filepath = "E:\\tmp\\我的素材.png";

        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpGet httpget = new HttpGet(url);
            HttpResponse response = httpclient.execute(httpget);

            HttpEntity entity = response.getEntity();
            InputStream is = entity.getContent();
            File file = new File(filepath);
            file.getParentFile().mkdirs();
            FileOutputStream fileout = new FileOutputStream(file);
            /**
             * 根据实际运行效果 设置缓冲区大小
             */
            byte[] buffer=new byte[1024];
            int ch = 0;
            while ((ch = is.read(buffer)) != -1) {
                fileout.write(buffer,0,ch);
            }
            is.close();
            fileout.flush();
            fileout.close();

            System.out.println("----------------------------------------");
        } finally {
            httpclient.close();
        }
    }
}
