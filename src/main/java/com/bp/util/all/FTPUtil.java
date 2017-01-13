package com.bp.util.all;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPListParseEngine;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 关于ftp的上传下载
 *
 * @author current_bp
 * @createTime 20170112
 */
public class FTPUtil {

    public static void main(String[] args) {
//        upload();
        download();
    }

    /**
     * FTP上传单个文件测试
     */
    public static void upload() {

    }

    /**
     * FTP下载单个文件测试
     */
    public static void download() {
        //ftp://ygdy8:ygdy8@y219.dydytt.net:9063/[阳光电影www.ygdy8.com].大空头.BD.720p.中英双字幕.rmvb
        //http://lenews.los-cn-north-1.lecloudapis.com/123/material/123/2017/01/10/3779763260924787964f86cdc9444e07/我的素材.png
        //ftp://dygod1:dygod1@d131.dygod.cn:3049/非诚勿扰DVDscr/[电影天堂[url]www.dygod.cn[/url]]非诚勿扰cd1.rmvb
        String server = "202.120.223.50";
        String username = "download";
        String password = "usstdown";

        FTPClient f = new FTPClient();
        try {
            f.connect(server);
            f.login(username, password);

            FTPFile[] files = f.listFiles("/");
            for (int i = 0; i < files.length; i++) {
                System.out.println(files[i].getName());
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
