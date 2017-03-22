package com.bp.util.all.downLoadAndUpload;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by issuser on 2017/3/20.
 */
public class HttpDownloader1Test {


    private HttpDownloader1 httpDownloader1 = new HttpDownloader1();

    @Before
    public void init(){

    }

    @Test
    public void canDownloadWithThread() throws Exception {

    }

    @Test
    public void useOneThreadDownloadFile() throws Exception {

    }

    @Test
    public void useMoreThreadDownloadFile() throws Exception {
        httpDownloader1.useMoreThreadDownloadFile("http://downloads.mongodb.org/linux/mongodb-linux-x86_64-3.0.6.tgz");
    }

    @Test
    public void getDownloadFileSize() throws Exception {
        Long size = httpDownloader1.getDownloadFileSize("http://downloads.mongodb.org/linux/mongodb-linux-x86_64-3.0.6.tgz");
        System.out.println("size:" + size);
    }

}