package com.bp.util.all.downLoadAndUpload;


import com.alibaba.fastjson.JSON;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.*;

/**
 * 我自己写的一个断点下载
 *
 * @author current_bp
 * @createTime 20170116
 */
public class HttpDownloader1 {

    private long fileSize = 0;
    private int threadNum = 0;
    private int threadMaxNum = 5;
    private int cacheMax = 8 * 1024 * 50;//每个文件的大小50Kb
    private static int[] progress;//0:未开始，1：下载完成，2：下载中，3：写入完成，4：写入中
    private boolean isWrite = false;//是否在写入一个文件
    private String fileName = "tomcat";//文件名称
    //    private String requestUrl = "http://mirrors.cnnic.cn/apache/tomcat/tomcat-9/v9.0.0.M17/bin/apache-tomcat-9.0.0.M17.zip";//请求地址
    private String baseTMPFilePath = "E:\\tmp\\20170203\\";//临时文件的路径

    //http://localhost:8080/uploadController/download?id=1
    //http://mirrors.cnnic.cn/apache/tomcat/tomcat-9/v9.0.0.M17/bin/apache-tomcat-9.0.0.M17.zip
    private String requestUrl = "http://mirrors.cnnic.cn/apache/tomcat/tomcat-9/v9.0.0.M17/bin/apache-tomcat-9.0.0.M17.zip";


    /*
    1、下载一个文件，
    2、将一个文件分割成多个请求获取，
    3、生成多个文件，
    4、按照循序组装文件
    5、将写入完成的文件删除
     */
    public static void main(String[] args) {
        HttpDownloader1 httpDownloader1 = new HttpDownloader1();
//        httpDownloader1.initProgress(10);
//        System.out.println("----:" + httpDownloader1.canDownloadWithThread());
//        System.out.println("----:fileSize:" + httpDownloader1.getDownloadFileSize());
        httpDownloader1.useOneThreadDownloadFile();

    }


    /**
     * 初始化分片
     *
     * @param fileAllSize 文件总大小
     * @return 分片
     */
    private int[] initProgress(long fileAllSize) {
        //分片的数量
        long len = fileAllSize / cacheMax;
        if (0 != fileAllSize % cacheMax) {
            len++;
        }

        System.out.println("===>initProgress: len:" + len);

        //线程的数量
        if (len <= this.threadMaxNum) {
            this.threadNum = (int) len;
        } else {
            this.threadNum = this.threadMaxNum;
        }

        return new int[(int) len];
    }

    /**
     * 获取下一个需要下载的文件分片
     *
     * @return 大于0：需要下载，小于0：没有需要下载的了
     */
    private synchronized int getNextRequestProgress() {
        int result = -1;
        for (int i = 0; i < progress.length; i++) {
            if (progress[i] == ProgressStatus.NO_START.getKey()) {
                result = i;
                break;
            }
        }
        return result;
    }


    /**
     * 修改分片的状态
     *
     * @param index     分片位置
     * @param newStatus 新状态
     * @param oldStatus 旧状态
     * @return 是否成功
     */
    private synchronized boolean changeProgress(int index, int newStatus, int oldStatus) {
        int oldStatus1 = progress[index];
        //0:未开始，1：下载完成，2：下载中，3：写入完成
        if (oldStatus == oldStatus1) {
            return false;
        }

        progress[index] = newStatus;

        return true;
    }

    /**
     * 写入一个文件或者释放一个文件的写入锁
     *
     * @return 修改成功与否
     */
    public synchronized boolean writeOrReleaseFile(boolean writeOrRelease) {
        if (writeOrRelease ^ isWrite) {
            return false;
        }

        this.isWrite = writeOrRelease;

        return true;
    }

    /**
     * 判断是否能够使用多线程下载
     *
     * @return 能否使用多线程下载
     */
    public boolean canDownloadWithThread() {
        CloseableHttpClient httpclient = HttpClients.createDefault();

        HttpGet httpget = new HttpGet(requestUrl);
        httpget.addHeader("Range", "bytes=" + 0 + "-" + 99);
        HttpResponse response = null;
        String result = "";
        try {
            response = httpclient.execute(httpget);
            int statusCode = response.getStatusLine().getStatusCode();

            result = EntityUtils.toString(response.getEntity());
            System.out.println("===>statusCode:" + statusCode);
            System.out.println("===>result:" + result);
            System.out.println("===>headers:" + JSON.toJSONString(response.getAllHeaders()));
            if (206 == statusCode) {
                return true;
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * 获取下载文件大小
     *
     * @return 文件大小
     */
    public Long getDownloadFileSize() {
        CloseableHttpClient httpclient = HttpClients.createDefault();

        HttpGet httpget = new HttpGet(requestUrl);
        httpget.addHeader("Range", "bytes=" + 0 + "-" + 99);
        HttpResponse response = null;
        Long contentLength = -1L;
        try {
            response = httpclient.execute(httpget);
            int statusCode = response.getStatusLine().getStatusCode();

//            System.out.println("===>statusCode:" + statusCode);
            System.out.println("===>headers:" + JSON.toJSONString(response.getAllHeaders()));
            Header[] headers = response.getHeaders("Content-Range");
            if (headers.length > 0) {
                contentLength = Long.valueOf(headers[0].getValue().split("/")[1]);
            }

            return contentLength;


        } catch (IOException e) {
            e.printStackTrace();
        }

        return -1L;
    }

    /**
     * 使用一个线程下载
     */
    public void useOneThreadDownloadFile() {
        System.out.println("===>start download .....");
        DownLoadThread downLoadThread = new DownLoadThread(0, getDownloadFileSize(), 0);
        downLoadThread.run();
    }

    /**
     * 用更多的线程下载
     */
    public void useMoreThreadDownloadFile() {
        System.out.println("===>start download .....");
        fileSize = getDownloadFileSize();

        //将一个文件分片，划分线程数
        initProgress(fileSize);

        for (int i = 0; i < this.threadNum; i++) {
            DownLoadThread downLoadThread = new DownLoadThread();
            downLoadThread.run();
        }

    }


    class DownLoadThread implements Runnable {
        private long start = 0;
        private long end = 0;
        private int whichProgress = 0;//需要下载的是哪个分片

        public DownLoadThread() {
        }

        public DownLoadThread(long start, long end, int whichProgress) {
            this.start = start;
            this.end = end;
//            this.end = 37238L;
            this.whichProgress = whichProgress;
        }

        @Override
        public void run() {
            BufferedInputStream inputStream = null;
            FileOutputStream fileOutputStream = null;
            //.jpg
            File tmpFile = new File(baseTMPFilePath + fileName + "_" + whichProgress + ".zip");
            CloseableHttpClient httpclient = HttpClients.createDefault();

            System.out.println("===>下载的分片：开始：" + start + "结束：" + end + " 分片：" + whichProgress);
            HttpGet httpget = new HttpGet(requestUrl);
            httpget.addHeader("Range", "bytes=" + start + "-" + end);

            try {
                HttpResponse response = httpclient.execute(httpget);


                inputStream = new BufferedInputStream(response.getEntity().getContent());
                fileOutputStream = new FileOutputStream(tmpFile);

//                response.getEntity().writeTo(fileOutputStream);

                byte[] cache = new byte[1024];
                int size = 0;
                while (-1 != (size = inputStream.read(cache))) {
                    fileOutputStream.write(cache, 0, size);
                }


                System.out.println("===>download 分片：" + whichProgress + " is over!!!");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
//                    fileOutputStream.flush();
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }
    }


    /**
     * 关于下载过程中的进程状态
     */
    enum ProgressStatus {
        //0:未开始，1：下载完成，2：下载中，3：写入完成，4：写入中，5：
        NO_START(0, "未开始"),
        DOWNLOAD_OK(1, "下载完成"),
        DOWNLOAD_ING(2, "下载中"),
        WRITE_OK(3, "写入完成"),
        WRITE_ING(4, "写入中");


        private String value;
        private int key;

        private ProgressStatus(int key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }
    }
}
