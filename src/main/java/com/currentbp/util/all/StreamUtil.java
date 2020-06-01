package com.currentbp.util.all;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.currentbp.entry.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 我的流处理类
 *
 * @author current_bp
 * @createTime 20160613
 */
public abstract class StreamUtil {
    private final static Logger logger = LoggerFactory.getLogger(StreamUtil.class);

    /**
     * 相对与本项目下的路径
     *
     * @param path 路进
     * @return 是否是文件
     */
    public static boolean isFile(String path) {
        return isFile(path, true);
    }

    /**
     * 判断是否是一个文件
     *
     * @param path       文件路径
     * @param isRelative 是否是相对路径
     * @return 是否是文件
     */
    public static boolean isFile(String path, boolean isRelative) {
        if (isRelative) {//相对与本项目的路径下
            InputStream is = Class.class.getResourceAsStream(path);
            return null != is;
        } else {
            File file = new File(path);
            return file.isFile();
        }
    }

    /**
     * 创建一个文件
     *
     * @param path 绝对路径
     * @return 文件
     */
    public static File createMyFile(String path) {
        return createMyFile(path, false);
    }

    /**
     * 创建一个文件
     *
     * @param path       路径
     * @param isRelative 是否是相对路径
     * @return 文件
     */
    public static File createMyFile(String path, boolean isRelative) {
        if (isRelative) {
            path = System.getProperty("user.dir") + "/" + path;
            System.out.println("path:"+path);
        }
        if (isFile(path)) {
            return new File(path);
        }
        File file = new File(path);
        try {
            file.createNewFile();
        } catch (Exception e) {
            logger.error("createMyFile is error! path:" + path, e);
            throw new BusinessException(e.getMessage());
        }
        return file;
    }

    /**
     * 获取path下的文件内容
     *
     * @param path 文件路径
     * @return 文件内容列表
     */
    public static List<String> getListByFileSource(String path) {
        Assert.isTrue(isFile(path), "the file :" + path + " is not exist!");
        InputStream is = Class.class.getResourceAsStream(path);
        List<String> result = new ArrayList<String>();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String temp = null;
        while (true) {
            try {
                if (null != (temp = br.readLine())) {
                    result.add(temp);
                } else {
                    break;
                }
            } catch (Exception e) {
                throw new BusinessException(e.getMessage());
            }
        }
        return result;
    }

    /**
     * 获取path下的文件内容
     *
     * @param path 文件绝对路径
     * @return 文件内容列表
     */
    public static List<String> getListByAbstrackPath(String path) {
//        Assert.isTrue(isFile(path), "the file :" + path + " is not exist!");
        InputStream is = null;
        try {
            is = new FileInputStream(new File(path));
        }catch (Exception e){
            System.out.println("===>read file error,eMsg:"+e.getMessage());
        }
        List<String> result = new ArrayList<String>();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String temp = null;
        while (true) {
            try {
                if (null != (temp = br.readLine())) {
                    result.add(temp);
                } else {
                    break;
                }
            } catch (Exception e) {
                throw new BusinessException(e.getMessage());
            }
        }
        return result;
    }

    /**
     * 根据路径获取该文件夹下的所有的文件或者文件夹，但是不获取子文件夹下的文件
     *
     * @param dir 目录
     * @return 目录下所有文件
     */
    public static List<File> getAllFileFromDir(String dir) {
        return getAllFileFromDir(new File(dir));
    }

    /**
     * 根据路径获取该文件夹下的所有的文件或者文件夹，但是不获取子文件夹下的文件
     *
     * @param dirFile 目录
     * @return 目录下所有文件
     */
    public static List<File> getAllFileFromDir(File dirFile) {
        if (!dirFile.isDirectory()) {// 非文件夹
            return null;
        }

        String[] names = dirFile.list();
        String dirPath = dirFile.getAbsolutePath();// 文件夹的绝对路径

        String fgf = System.getProperty("file.separator");// 分隔符

        List<File> result = new ArrayList<File>();

        if (CheckUtil.isEmpty(names)) {// 该文件夹下没有文件或文件夹
            return null;
        }

        for (String name : names) {
            result.add(new File(dirPath + fgf + name));
        }

        return result;
    }

    /**
     * 产生一个字符流的写入流
     *
     * @param filePath 写入的文件路径：绝对路径
     * @return 文件写入流
     */
    public static FileWriter createFileWriter(String filePath) {
        return createFileWriter(filePath, false, true);
    }

    /**
     * 获取文件写入流
     *
     * @param filePath   文件路进
     * @param isAbsolute 是否是绝对路径
     * @param isAppend   是否追加到文件尾部
     * @return 文件写入流
     */
    public static FileWriter createFileWriter(String filePath, boolean isAbsolute, boolean isAppend) {
        FileWriter fileWriter = null;
        String path = null;
        try {
            if (isAbsolute) {
                path = filePath;
            } else {
                path = Class.class.getResource(filePath).getPath();
            }
            fileWriter = new FileWriter(new File(path), isAppend);
        } catch (IOException e) {
            throw new BusinessException(e.getMessage());
        }
        return fileWriter;
    }

    /**
     * @param url      资源路径
     * @param fileName 文件路径，包括文件名全称。
     */
    public static void getResourceFromUrl(String url, String fileName) {
        Long time1 = System.currentTimeMillis();
        File file = new File(fileName);
        InputStream is = null;
        HttpURLConnection huc;
        OutputStream os = null;

        try {
            URL resource = new URL(url);
            huc = (HttpURLConnection) resource.openConnection();
            // 通过指定的URL 获得字节流。
            is = huc.getInputStream();

            if (!file.exists()) {
                file.createNewFile();
            }
            os = new FileOutputStream(file);
            byte[] buffer = new byte[1024];
            logger.info("It's start .....");
            while (true) {
                int len = is.read(buffer);
                if (len == -1) {
                    logger.info("It's end!");
                    break;
                }
                os.write(buffer, 0, len);
            }
        } catch (Exception e) {
            logger.error("getResourceFromUrl is error! url:" + url + " fileName:" + fileName, e);
            throw new BusinessException(e.getMessage());
        } finally {
            closeResource(is, null, null, os, null, null);
        }
        Long time2 = System.currentTimeMillis();
        logger.info("===>cost time:" + (time2 - time1));

    }

    /**
     * 从文件列表中获取文件名称列表
     *
     * @param files 文件列表
     * @return 文件名称列表
     */
    public static List<String> getFileNamesFromFiles(List<File> files) {
        if (CheckUtil.isEmpty(files)) {
            return new ArrayList<String>();
        }
        List<String> result = CollectionCommonUtil.getFieldListByMethodName(files, "getName", String.class);
        return result;
    }

    /**
     * 获取文件夹下的所有的文件（深层次）
     *
     * @param dirFile 目录文件
     * @return 所有文件
     */
    public static List<File> getAllFilesFromDirDeep(String dirFile) {
        //TODO not review
        return getAllFilesFromDirDeep(new File(dirFile));
    }

    /**
     * 获取文件夹下的所有的文件（深层次）
     *
     * @param dirFile 目录文件
     * @return 所有文件
     */
    public static List<File> getAllFilesFromDirDeep(File dirFile) {
        //TODO NOT review
        if (CheckUtil.isEmpty(dirFile)) {
            return null;
        }

        List<File> result = new ArrayList<File>();
        result.add(dirFile);

        if (!dirFile.isDirectory()) {// 不是目录
            return result;
        }

        File upDir;
        List<File> downFiles;
        for (int i = 0; i < result.size(); i++) {
            upDir = result.get(i);
            if (upDir.isDirectory()) {// 是目录
                downFiles = Arrays.asList(upDir.listFiles());

                if (null == downFiles || 0 == downFiles.size()) {// 表示该目录下没有文件或目录
                    continue;
                }

                result.addAll(downFiles);
            }
        }

        return result;
    }


    /**
     * 写入文件（默认：追加到文件尾部）
     *
     * @param content 内容
     * @param path    文件路径
     */
    public static void writeSomethingToFile(String content, String path) {
        writeSomethingToFile(content, path, true);
    }

    /**
     * 写入文件，支持非追加
     *
     * @param content  内容
     * @param path     路径
     * @param isAppend 是否追加文件尾行
     */
    public static void writeSomethingToFile(String content, String path, boolean isAppend) {
        writeSomethingToFile(content, path, isAppend, true);
    }

    /**
     * 写入文件，支持非追加，支持相对路径
     *
     * @param content    内容
     * @param path       路径
     * @param isAppend   是否追加到文件尾行
     * @param isRelative 是否是相对路径
     */
    public static void writeSomethingToFile(String content, String path, boolean isAppend, boolean isRelative) {
        File file = createMyFile(path, isRelative);

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file, isAppend);
            fileWriter.write(content);
            fileWriter.close();
        } catch (Exception e) {
            logger.error("writeSomethingToFile is error!", e);
            throw new BusinessException(e.getMessage());
        } finally {
            closeFileWriter(fileWriter);
        }
        logger.info("file wirte over!");
    }

    //==========================私有文件=============================================//

    /**
     * 关闭流
     *
     * @param is  InputStream
     * @param isr InputStreamReader
     * @param br  BufferedReader
     * @param os  OutputStream
     * @param osw OutputStreamWriter
     * @param bw  BufferedWriter
     */
    private static void closeResource(InputStream is,
                                      InputStreamReader isr,
                                      BufferedReader br,
                                      OutputStream os,
                                      OutputStreamWriter osw,
                                      BufferedWriter bw) {
        try {
            if (null != bw) {
                bw.close();
            }
            if (null != osw) {
                osw.close();
            }
            if (null != os) {
                os.close();
            }
            if (null != br) {
                br.close();
            }
            if (null != isr) {
                isr.close();
            }
            if (null != is) {
                is.close();
            }
        } catch (Exception e) {
            logger.info("===>close resource error!! msg:" + e.getMessage());
        }
    }

    /**
     * 关闭流资源：fileWriter
     *
     * @param fileWriter fileWriter
     */
    private static void closeFileWriter(FileWriter fileWriter) {
        if (null != fileWriter) {
            try {
                fileWriter.close();
            } catch (Exception e2) {
                throw new BusinessException(e2.getMessage());
            }
        }
    }


}
