package com.currentbp.util.all;

import com.alibaba.fastjson.JSON;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 关于请求的util
 *
 * @author current_bp
 * @createTime 20161230
 */
public class RequestUtil {

    private static String executeRequest(HttpRequestType httpRequestType, String url, Map<String, Object> param) {
//        Preconditions.checkNotNull(url, "url不能为空");
//        Preconditions.checkNotNull(param, "传参不能为空");

        StringBuilder queryParams = new StringBuilder(url);
        int length = queryParams.length();

        for (Map.Entry<String, Object> entry : param.entrySet()) {
            if (queryParams.length() == length && queryParams.indexOf("?") == -1) {
                queryParams.append("?");
            } else {
                queryParams.append("&");
            }
            queryParams.append(entry.getKey()).append("=").append(entry.getValue());
        }

        HttpRequestBase request;
        switch (httpRequestType) {
            case PUT:
                request = new HttpPut(queryParams.toString());
                break;
            case DELETE:
                request = new HttpDelete(queryParams.toString());
                break;
            case POST:
                request = new HttpPost(queryParams.toString());
                break;
            case GET:
                request = new HttpGet(queryParams.toString());
                Header header = new BasicHeader("Authorization", "Basic "+getCDNString(param));
                request.setHeader(header);
                break;

            default:
                request = new HttpGet(queryParams.toString());
        }

        long start = System.currentTimeMillis();
        long end = 0;
        String result = "";
        final CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            CloseableHttpResponse response = httpClient.execute(request);
            System.out.println("===>" + JSON.toJSONString(response.getEntity()));
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                result = EntityUtils.toString(entity);
                System.out.println("===>result:" + JSON.toJSONString(result));
                end = System.currentTimeMillis();
            }

        } catch (Exception e) {
            System.out.println("===>e:" + JSON.toJSONString(e));
        } finally {
            try {
                httpClient.close();
                System.out.println("===>used time:" + (end - start));
            } catch (IOException e) {
            }
        }

        return result;
    }


    public static void main(String[] args) {
        RequestUtil requestUtil = new RequestUtil();
        requestUtil.createCDN();

    }

    public void createCDN() {
        String url = "http://api.open.lecloud.com/cdn/domain";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userid", "777777");
        map.put("secretkey", "djek5iv83jrn59ckdnem68xh3k8fbw91");
        RequestUtil.executeRequest(HttpRequestType.GET, url, map);
    }

    public static String getCDNString(Map<String, Object> map) {
        String result = "" + map.get("userid") + "GET" + "/cdn/domain" + map.get("secretkey");
        System.out.println("result:" + result);

        String md5_result = null;
        try {
            md5_result = EncryptionUtil.md5_32(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String base64 = EncryptionUtil.base_64_Encoder("" + map.get("userid") + ":" + md5_result);
        System.out.println("base64:" + base64);
        return base64;
    }


}

/**
 * 请求类型
 */
enum HttpRequestType {
    PUT, DELETE, POST, GET;
}