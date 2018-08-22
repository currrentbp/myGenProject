package com.currentbp.util.all;

import com.alibaba.fastjson.JSON;
import com.currentbp.entry.HttpResultData;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
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
     *
     * @param url    请求url
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
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(5000).setConnectTimeout(5000).build();
            System.out.println("===>getRequest: url2:" + url2);
            HttpGet httpget = new HttpGet(url2);
            httpget.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
            httpget.setConfig(requestConfig);
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

    public static HttpResultData postRequest(String url, String source){
        return postRequest(url,source,"","",5000,5000);
    }
    public static HttpResultData postRequest(String url, String source, String contentType, String charset, int socketTimeOut, int connectTimeout) {
        PrintWriter out = null;
        BufferedReader in = null;
        HttpResultData result = new HttpResultData(HttpResultData.ERROR,HttpResultData.IS_OTHER_ERROR,"");
        String temp = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(source);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                temp += line;
            }
            result.setBody(temp).setCode(200);
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
            result.setBody(e.getMessage());
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
                result.setBody(ex.getMessage());
            }
        }
        return result;
    }


    /**
     * http post 请求
     *
     * @param url    请求URL
     * @param params 参数
     * @return 请求结果
     */
    public static HttpResultData postRequest(String url, Map<String, Object> params) {
        return postRequest(url, params, "application/json;", "utf-8", 5000, 5000);
    }

    /**
     * http post 请求
     *
     * @param url            请求URL
     * @param params         参数
     * @param contentType    内容类型
     * @param charset        字符集
     * @param socketTimeOut  超时时间
     * @param connectTimeout 连接超时时间
     * @return 请求结果
     */
    public static HttpResultData postRequest(String url, Map<String, Object> params, String contentType, String charset, int socketTimeOut, int connectTimeout) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpResultData result = new HttpResultData(HttpResultData.ERROR,HttpResultData.IS_OTHER_ERROR,"");
        try {
            HttpPost httpPost = new HttpPost(url);
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(socketTimeOut).setConnectTimeout(connectTimeout).build();
            httpPost.addHeader("Content-Type", contentType);
            httpPost.addHeader("charset", charset);
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            for (String key : params.keySet()) {
                nvps.add(new BasicNameValuePair(key, params.get(key).toString()));
            }
            httpPost.setEntity(new UrlEncodedFormEntity(nvps));
            httpPost.setConfig(requestConfig);
            HttpResponse response = httpclient.execute(httpPost);
            StatusLine statusLine = response.getStatusLine();
            int statusCode = statusLine.getStatusCode();
            result.setCode(statusCode)
                    .setBody(EntityUtils.toString(response.getEntity()));

        } catch (IOException e) {
            e.printStackTrace();
            result.setBody(e.getMessage());
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
                result.setBody(e.getMessage());
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

    public static HttpResultData postRequest2(String url, Map<String, Object> params) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpResultData result = new HttpResultData(HttpResultData.ERROR,HttpResultData.IS_OTHER_ERROR,"");
        try {
            HttpPost httpPost = new HttpPost(url);
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(5000).setConnectTimeout(5000).build();
            httpPost.addHeader("Content-Type", "application/json;");
            httpPost.addHeader("charset", "utf-8");
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            for (String key : params.keySet()) {
                nvps.add(new BasicNameValuePair(key, params.get(key).toString()));
            }
            httpPost.setEntity(new UrlEncodedFormEntity(nvps));
            httpPost.setConfig(requestConfig);

            HttpResponse response = httpclient.execute(httpPost);
            StatusLine statusLine = response.getStatusLine();
            int statusCode = statusLine.getStatusCode();
            result.setCode(statusCode)
                    .setBody(EntityUtils.toString(response.getEntity()));

        } catch (IOException e) {
            e.printStackTrace();
            result.setBody(e.getMessage());
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
                result.setBody(e.getMessage());
            }
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
