package com.bp.util.all.downLoadAndUpload;


import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 * 我自己写的一个断点下载
 *
 * @author current_bp
 * @createTime 20170116
 */
public class HttpDownloader1 {

    private int threadNum = 0;
    private int threadMaxNum = 5;
    private int cacheMax = 8 * 1024 * 50;//每个文件的大小50Kb
    private static int[] progress;//0:未开始，1：下载完成，2：下载中，3：写入完成，4：写入中
    private boolean isWrite = false;//是否在写入一个文件
    private String fileName = "";//文件名称

    public static void main(String[] args) {
        HttpDownloader1 httpDownloader1 = new HttpDownloader1();
//        httpDownloader1.initProgress(10);
        System.out.println("----:"+httpDownloader1.writeOrReleaseFile(false));
    }


    /**
     * 初始化分片
     *
     * @param fileAllSize 文件总大小
     * @return 分片
     */
    private int[] initProgress(long fileAllSize) {
        long len = fileAllSize / cacheMax;
        if (0 != fileAllSize % cacheMax) {
            len++;
        }

        System.out.println("===>initProgress: len:" + len);

        return new int[(int) len];
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


    class DownLoadThread implements Runnable {
        private int start = 0;
        private int end = 0;
        private int whichProgress = 0;//需要下载的是哪个分片

        public DownLoadThread(int start, int end, int whichProgress) {
            this.start = start;
            this.start = end;
            this.whichProgress = whichProgress;
        }

        @Override
        public void run() {
            CloseableHttpClient httpclient = HttpClients.createDefault();

        }
    }


    /**
     * 关于下载过程中的进程状态
     */
    enum ProgressStatus{
        //0:未开始，1：下载完成，2：下载中，3：写入完成，4：写入中
        NO_START(0,"未开始"),
        DOWNLOAD_OK(1,"下载完成"),
        DOWNLOAD_ING(2, "下载中"),
        WRITE_OK(4, "写入完成"),
        WRITTING(5,"写入中")

        ;


        private String value ;
        private int key ;

        private ProgressStatus( int key , String value ){
            this.key = key ;
            this.value = value ;
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
