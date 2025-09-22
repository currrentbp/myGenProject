package com.currentbp.steam;

import com.alibaba.fastjson2.JSON;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class GetResponseUsedTime {
    private static final int MAX_USED_TIME = 1000;
    public static void main(String[] args) {
        GetResponseUsedTime getResponseUsedTime = new GetResponseUsedTime();
        getResponseUsedTime.findOneKey("C:\\Users\\itw_baopan\\Desktop\\查询时间的日志\\日志1.txt");
    }

    /**
     * 现在需要读取一个文件，然后每次读取一行，写一个方法
     */
    public void findOneKey(String path) {
        try {
            Map<String, String> traceId2UsedTimeMap = new HashMap<>();
            File sourceFile = new File(path);

            InputStream is = new FileInputStream(sourceFile);
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            String temp = null;
            System.out.println("seacher start ...");
            while ((temp = br.readLine()) != null) {
                getTraceIdUseTimeFromStr(temp, traceId2UsedTimeMap);
            }
            System.out.println("json:"+ JSON.toJSONString(traceId2UsedTimeMap));
            System.out.println("seacher end !");
        } catch (Exception e) {
            System.out.println("there is error,msg:" + e.getMessage());
        }
    }

    private void getTraceIdUseTimeFromStr(String str, Map<String, String> traceId2UsedTimeMap) {
        /*
        现在需要根据上面的日志，查询出traceId，条件是timeCostMills大于1000ms的响应。
         */
        if (str == null || str.length() <= 0) {
            return;
        }
        try {
            String[] line = str.split("\"timeCostMills\":");
            String[] split = line[0].split("traceId:");
            String[] split1 = split[1].split("]");
            String traceId = split1[0];
            String[] split2 = line[1].split(",");
            String usedTime = split2[0];
            if (Integer.parseInt(usedTime) >= MAX_USED_TIME) {
                traceId2UsedTimeMap.put(traceId, usedTime);
            }
        } catch (Exception e) {
            System.out.println("======> is error,msg:" + e.getMessage());
        }
    }
}
