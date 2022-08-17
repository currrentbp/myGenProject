package com.currentbp.util.all.downLoadAndUpload;


import com.alibaba.fastjson2.JSON;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.util.Date;

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
    private int cacheMax = 500 * 1024;//每个文件的大小500Kb
    private volatile static int[] progress;//0:未开始，1：下载完成，2：下载中，3：写入完成，4：写入中
    private String fileName = "despair";//文件名称
    //    private String requestUrl = "http://mirrors.cnnic.cn/apache/tomcat/tomcat-9/v9.0.0.M17/bin/apache-tomcat-9.0.0.M17.zip";//请求地址
    private String baseTMPFilePath = "E:\\tmp\\20200710\\";//临时文件的路径

    //http://localhost:8080/uploadController/download?id=1
    //http://mirrors.cnnic.cn/apache/tomcat/tomcat-9/v9.0.0.M17/bin/apache-tomcat-9.0.0.M17.zip
    //http://txt.bxwxtxt.com/packdown/fulltxt/126/126004.txt
    private String requestUrl = "https://cnbj3-fusion.fds.api.xiaomi.com/aphrodite/MjYzNDVBRTQ4NUI2OUIyQUVFNUQyQTU1MzUzNzY1NkE..wav";
    private String oldFileName = "";
    private String tail = "";
    private String tmpTail = ".tmp";


    /*
    1、下载一个文件，
    2、将一个文件分割成多个请求获取，
    3、生成多个文件，
    4、按照循序组装文件
    5、将写入完成的文件删除
     */
    public static void main(String[] args) {
        HttpDownloader1 httpDownloader1 = new HttpDownloader1();
        httpDownloader1.initProgress(10);
        System.out.println("----:" + httpDownloader1.canDownloadWithThread());
        System.out.println("----:fileSize:" + httpDownloader1.getDownloadFileSize());
        httpDownloader1.useOneThreadDownloadFile();
        long time1 = new Date().getTime();
        httpDownloader1.useMoreThreadDownloadFile();
        long time2 = new Date().getTime();
        System.out.println("===>used time:" + (time2 - time1));


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

        //初始化名称等其他属性
        this.oldFileName = getOldFileName();
        this.tail = getTail();


        return new int[(int) len];
    }

    /**
     * 获取下载的文件的后缀
     *
     * @return 后缀
     */
    private String getTail() {
        String name = this.oldFileName;
        String t = name.substring(name.lastIndexOf("."));
        System.out.println("tail:" + t);
        return t;
    }

    /**
     * 根据URL获取文件名称
     *
     * @return 文件名称
     */
    private String getOldFileName() {
        String url = this.requestUrl;
        String name = url.substring(url.lastIndexOf("/") + 1);
        System.out.println("name:" + name);
        return name;
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
                progress[i] = ProgressStatus.DOWNLOAD_ING.getKey();
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
        System.out.println("===>changeProgress: index:" + index + " newStatus:" + newStatus + " oldStatus:" + oldStatus + " oldStatus1:" + oldStatus1);
        //0:未开始，1：下载完成，2：下载中，3：写入完成
        //原状态不能吻合，错误
        if (oldStatus != oldStatus1) {
            return false;
        }

        progress[index] = newStatus;

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
        HttpResponse response;
        String result;
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
     * @param requestUrl 请求地址
     * @return
     */
    public Long getDownloadFileSize(String requestUrl) {
        this.requestUrl = requestUrl;
        return getDownloadFileSize();
    }

    /**
     * 获取下载文件大小
     *
     * @return 文件大小
     */
    public Long getDownloadFileSize() {
        CloseableHttpClient httpclient = HttpClients.createDefault();

        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(5000).setConnectTimeout(5000).build();
        HttpHead httpHead = new HttpHead(requestUrl);
        HttpGet httpget = new HttpGet(requestUrl);
        httpget.addHeader("Range", "bytes=" + 0 + "-" + 99);
        HttpResponse response;
        Long contentLength = -1L;
        try {
            httpHead.setConfig(requestConfig);
            response = httpclient.execute(httpHead);//使用head的方式获取文件长度
//            response = httpclient.execute(httpget);//使用get请求获取文件长度，这种方式有点笨。。
            int statusCode = response.getStatusLine().getStatusCode();

            System.out.println("===>statusCode:" + statusCode);
            System.out.println("===>headers:" + JSON.toJSONString(response.getAllHeaders()));
            Header[] headers = response.getHeaders("Content-Range");
            Header[] headers2 = response.getHeaders("Content-Length");
            if (statusCode == 206) {//使用get请求方式获取文件长度
                if (headers.length > 0) {
                    contentLength = Long.valueOf(headers[0].getValue().split("/")[1]);
                }
            } else if (statusCode == 200) {//使用head的请求方式获取文件长度
                if (headers2.length > 0) {
                    contentLength = Long.valueOf(headers2[0].getValue());
                }
            }

            return contentLength;


        } catch (IOException e) {
            e.printStackTrace();
        }

        return -1L;
    }


    /**
     * 将临时文件拼接起来
     *
     * @return 是否完成拼接
     */
    private boolean pickUpFile() {

        for (int i = 0; i < progress.length; i++) {
            while (true) {
                System.out.println("===>progress status:" + JSON.toJSONString(progress));
                //如果需要拼接的分片的状态不对，就睡眠2秒
                if (progress[i] != ProgressStatus.DOWNLOAD_OK.getKey()) {
                    System.out.println("===>progress :" + i + " progress status:" + ProgressStatus.getValueByKey(progress[i]) +
                            " ,and will sleep 2 seconds!!");
                    try {
                        Thread.sleep(2 * 1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                //需要拼接的状态
                if (progress[i] == ProgressStatus.DOWNLOAD_OK.getKey()) {
                    System.out.println("===>progress :" + i + " progress status:" + ProgressStatus.getValueByKey(progress[i]));
                    boolean changeResult1 = changeProgress(i, ProgressStatus.WRITE_ING.getKey(), ProgressStatus.DOWNLOAD_OK.getKey());
                    if (!changeResult1) {
                        continue;
                    }

                    InputStream inputStream = null;
                    OutputStream outputStream = null;
                    try {
                        File outputFile = new File(this.baseTMPFilePath + this.fileName + tail);
                        if (!outputFile.exists()) {
                            outputFile.createNewFile();
                        }

                        inputStream = new FileInputStream(new File(this.baseTMPFilePath + this.fileName + "_" + i + tmpTail));
                        outputStream = new FileOutputStream(outputFile, true);

                        byte[] cache = new byte[1024];
                        while (-1 != (inputStream.read(cache))) {
                            outputStream.write(cache);
                        }
                    } catch (Exception e) {
                        System.out.println("===>pickUpFile: error:" + e.getMessage());
                    } finally {
                        //关闭资源
                        if (null != outputStream) {
                            try {
                                outputStream.flush();
                                outputStream.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        if (null != inputStream) {
                            try {
                                inputStream.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                }

                //修改分片的状态，并删除已经追加成功的临时文件
                boolean changeResult2 = changeProgress(i, ProgressStatus.WRITE_OK.getKey(), ProgressStatus.WRITE_ING.getKey());
                if (!changeResult2) {
                    continue;
                }
                File rmFile = new File(this.baseTMPFilePath + this.fileName + "_" + i + ".tmp");
                rmFile.delete();
                //完成本次的输入
                break;
            }
        }


        return false;
    }

    /**
     * 使用一个线程下载
     */
    public void useOneThreadDownloadFile() {
        System.out.println("===>start download .....");
        DownLoadThread downLoadThread = new DownLoadThread(0, getDownloadFileSize(), 0);
        downLoadThread.run();
    }

    public void useMoreThreadDownloadFile(String requestUrl) {
        this.requestUrl = requestUrl;
        useMoreThreadDownloadFile();
    }

    /**
     * 用更多的线程下载
     */
    public void useMoreThreadDownloadFile() {
        System.out.println("===>start download .....");
        fileSize = getDownloadFileSize();

        //将一个文件分片，划分线程数
        progress = initProgress(fileSize);

        for (int i = 0; i < this.threadNum; i++) {
            System.out.println("===>启动线程：threadNum:" + (i + 1) + " .....");
            DownLoadThread downLoadThread = new DownLoadThread();
            downLoadThread.start();
        }

        pickUpFile();


    }


    /**
     * 专门用于下载的线程
     */
    class DownLoadThread extends Thread {
        private long start = 0;
        private long end = 0;
        private int whichProgress = 0;//需要下载的是哪个分片

        public DownLoadThread() {
        }

        public DownLoadThread(long start, long end, int whichProgress) {
            this.start = start;
            this.end = end;
            this.whichProgress = whichProgress;
        }

        @Override
        public void run() {
            //循环下载===>开始
            while (true) {
                //获取需要下载的分片
                this.whichProgress = getNextRequestProgress();
                if (this.whichProgress == -1) {
                    System.out.println("===>thread: id:" + Thread.currentThread().getId() +
                            " this progress is end!!! progress:" + this.whichProgress);
                    return;
                }

                this.start = this.whichProgress * cacheMax;
                this.end = (this.whichProgress + 1) * cacheMax - 1;

                //下载每一个分片的内容
                System.out.println("===>thread: id:" + Thread.currentThread().getId() +
                        "下载的分片：开始：" + start + "结束：" + end + " 分片：" + whichProgress);
                BufferedInputStream inputStream;
                FileOutputStream fileOutputStream = null;
                //.jpg
                File tmpFile = new File(baseTMPFilePath + fileName + "_" + whichProgress + tmpTail);
                CloseableHttpClient httpclient = HttpClients.createDefault();


                HttpGet httpget = new HttpGet(requestUrl);
                httpget.addHeader("Range", "bytes=" + start + "-" + end);

                try {
                    HttpResponse response = httpclient.execute(httpget);

                    inputStream = new BufferedInputStream(response.getEntity().getContent());
                    fileOutputStream = new FileOutputStream(tmpFile);

                    byte[] cache = new byte[1024];
                    int size = 0;
                    while (-1 != (size = inputStream.read(cache))) {
                        fileOutputStream.write(cache, 0, size);
                    }

                    System.out.println("===>thread: id: " + Thread.currentThread().getId() +
                            " download 分片：" + whichProgress + " is over!!!");
                    changeProgress(whichProgress, ProgressStatus.DOWNLOAD_OK.getKey(), ProgressStatus.DOWNLOAD_ING.getKey());
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
            //循环下载===>结束

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

        ProgressStatus(int key, String value) {
            this.key = key;
            this.value = value;
        }

        public static String getValueByKey(int key) {
            for (ProgressStatus progressStatus : ProgressStatus.values()) {
                if (progressStatus.key == key) {
                    return progressStatus.getValue();
                }
            }
            return null;
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
