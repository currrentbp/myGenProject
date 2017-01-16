package com.bp.util.all;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * 关于http的
 *
 * @author current_bp
 * @createTime 20170112
 */
public class HTTPUtil {


    /**
     * http get请求
     * @param url 请求url
     * @param params 参数
     * @return 返回结果
     */
    public static String getRequest(String url, Map<String, Object> params) {
        System.out.println("===>getRequest: url:" + url + " params:" + JSON.toJSONString(params));
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String paramLink = getParamsLink(params);
        String result = null;
        try {
            String url2 = url + (null == paramLink ? "" : "?" + paramLink);
            System.out.println("===>getRequest: url2:" + url2);
            HttpGet httpget = new HttpGet(url2);
            httpget.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

            HttpResponse response = httpclient.execute(httpget);

            result = EntityUtils.toString(response.getEntity());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return result;
    }


    /**
     * http post 请求
     * @param url 请求URL
     * @param params 参数
     * @return 请求结果
     */
    public static String postRequest(String url, Map<String, Object> params) {
        System.out.println("===>postRequest: url:" + url + " params:" + JSON.toJSONString(params));
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String result = null;
        try {
            HttpPost httpPost = new HttpPost(url);
            httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");


            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            for (String key:params.keySet()){
                nvps.add(new BasicNameValuePair(key,""+params.get(key)));
            }
            httpPost.setEntity(new UrlEncodedFormEntity(nvps));


            HttpResponse response = httpclient.execute(httpPost);

            result = EntityUtils.toString(response.getEntity());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    private static String getParamsLink(Map<String, Object> params) {
        if (null == params || 0 == params.size()) {
            return null;
        }
        Set<String> keys = params.keySet();
        StringBuilder result = new StringBuilder();
        for (String param : keys) {
            result.append(param)
                    .append("=")
                    .append(params.get(param))
                    .append("&");
        }

        return result.substring(0, result.length() - 1);
    }

    public static void main(String[] args) {
        HTTPUtil httpUtil = new HTTPUtil();
        Map<String, Object> params = new HashMap<String,Object>();
        params.put("id", "cd7d5e6922b64b748d4fd564b650a78b");
        System.out.println(httpUtil.getRequest("http://localhost:8080/asset/getAsset",params));

        params.put("name","+++++++++++++++");
        params.put("city",Integer.parseInt("88"));
        System.out.println(httpUtil.postRequest("http://localhost:8080/asset/update",params));
    }
}
