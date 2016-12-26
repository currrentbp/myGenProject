package com.bp.util.all;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bp.util.all.*;

/**
 * 我的流处理类
 *
 * @author current_bp
 * @createTime 20160613
 */
public class StreamUtil {

    public static void main(String[] args) throws IOException {
        // //生成一个路径下打文件
        // StreamUtil.createMyNewFile("E:\\test\\test1\\1.txt");

        // // 将一段话写入一个文件中
        // StreamUtil.writeSomethingToFile("sssssssssss\nsssf",
        // "E:\\test\\test1\\1.txt");

        // // 寻找一个文件中是否存在相同的值
        // StreamUtil.findContainsThesame("E:\\bp1.txt");

        // 删除一些重复的文件
        // StreamUtil.deleteTheSameFile("E:\\tmp\\bp");

        // 从网上下载一个文件
        // StreamUtil.getResourceFromUrl("http://repo1.maven.org/maven2/archetype-catalog.xml",
        // "E:\\tmp\\archetype-catalog.xml");

        // 获取一个目录下的所有文件
        System.out.println(StreamUtil.getAllFilesFromDirDeep("E:\\letv"));

    }

    /**
     * 根据文件夹下的文件名判断是否同名，并删除类似文件 , 例如：“bp”雷同于“bp(1)”、“bp (2)”
     * 例如：“bp1.txt”雷同于“bp1(1).txt”
     *
     * @param dirPath 目录
     */
    public static void deleteTheSameFile(String dirPath) {
        List<File> allFileInDir = getAllFileFromDir(dirPath);
        List<String> allFilenames = getFilenamesFromFiles(allFileInDir);

        List<File> deleteFiles = new ArrayList<File>();

        for (String filename : allFilenames) {
            System.out.println(filename);
        }

        for (int index = 0; index < allFilenames.size(); index++) {// 指针

            String thisFileName = allFilenames.get(index).trim();
            // 判断是否存在文件类型，即最后一个“.”后面的字符串
            String tail = thisFileName.lastIndexOf(".") == -1 ? null
                    : thisFileName.substring(thisFileName.lastIndexOf(".") + 1);
            String head = thisFileName.lastIndexOf(".") == -1 ? thisFileName
                    : thisFileName.substring(0, thisFileName.lastIndexOf("."));

            System.out.println("name:" + thisFileName + " head:" + head + " tail:" + tail);

            String pattern = "^" + head + " {0,}\\([0-9]{0,}\\)" + (null == tail ? "" : "\\." + tail);

            // 1.需要判断当前指针的文件名称和nextIndex指针所对应的文件的名称是否类似
            // 2.如果类似，放到要删除的文件集合中
            for (int nextIndex = 0; nextIndex < allFilenames.size(); nextIndex++) {
                if (index == nextIndex) {
                    continue;
                }
                boolean flag = false;
                try {
                    flag = CheckUtil.patternString(pattern, allFilenames.get(nextIndex));
                    System.out.println("flag:" + flag + " pattern:" + pattern + " file:" + allFilenames.get(nextIndex));
                } catch (Exception e) {
                    e.printStackTrace();
                }

                if (flag) {
                    deleteFiles.add(allFileInDir.get(nextIndex));
                }
            }
        }

        System.out.println("============deleteFiles:");
        // 打印需要删除的文件名称
        for (File file : deleteFiles) {
            System.out.println(file.getName());
            file.delete();
        }

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

        if (null == names || 0 == names.length) {// 该文件夹下没有文件或文件夹
            return null;
        }

        for (int i = 0; i < names.length; i++) {
            result.add(new File(dirPath + fgf + names[i]));
        }

        return result;
    }

    /**
     * 寻找一个文件中是否存在相同的key
     *
     * @param filePath 文件路径
     * @return 是否存在相同key
     */
    public static boolean findContainsThesame(String filePath) {

        File sourceFile = new File(filePath);

        InputStream is;
        InputStreamReader isr;
        BufferedReader br;

        String temp;
        Map<String, Integer> allKeysAndCount = new HashMap<String, Integer>();
        List<String> keys = new ArrayList<String>();

        System.out.println("seacher start ...");

        int count;
        try {
            is = new FileInputStream(sourceFile);
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);

            while ((temp = br.readLine()) != null) {
                if (null == allKeysAndCount.get(temp)) {
                    allKeysAndCount.put(temp, 1);
                } else {
                    count = allKeysAndCount.get(temp);
                    allKeysAndCount.put(temp, ++count);
                    keys.add(temp);
                }
            }

        } catch (Exception e) {
            System.out.println("message:" + e.getMessage());
        }
        if (0 != keys.size()) {
            for (int i = 0; i < keys.size(); i++) {
                System.out.println("key:" + keys.get(i) + " count:" + allKeysAndCount.get(keys.get(i)));
            }
        } else {
            System.out.println("there is no same key...");
        }
        System.out.println("seacher end.");
        return false;
    }

    /**
     * 将一些内容写入一个文件中
     * @param something 添加内容
     * @param filePath 文件路径
     * @throws IOException 异常
     */
    public static void writeSomethingToFile(String something, String filePath) throws IOException {
        writeSomethingToFile(something, filePath, true);
    }

    /**
     * 将一些内容写入一个文件中
     *
     * @param something 添加内容
     * @param filePath  文件路径
     * @param isAppend  是否追加
     * @throws IOException 异常
     */
    public static void writeSomethingToFile(String something, String filePath, boolean isAppend) throws IOException {
        // 1、判断是否存在该文件，如果不存在，则生成
        try {
            StreamUtil.createMyNewFile(filePath);
        } catch (Exception e) {
            System.out.println("===>the file is exits!");
        }

        // 2、将内容写入文件
        FileWriter fileWriter = new FileWriter(new File(filePath), isAppend);
        fileWriter.write(something);
        fileWriter.close();

    }

    /**
     * 根据keys中的多个关键字查询，例如：2|3|4，其中多个关键字之间是用"|"分割的。
     * 从一个文件（sourcePath）中查询这个关键字的上下文（行数num）， 并将查询的结果放入一个文件（descPath）中。
     * 这种查询是多次访问一个文件，虽然浪费时间，但是查询出的结果是有顺序有连贯性的。
     *
     * @param keys
     * @param descPath
     * @param sourcePath
     * @param num
     */
    public static void findSomeKey(String descPath, String sourcePath, String keys, int num) {
        if (null == keys || "".equals(keys)) {
            System.out.println("there is no keys ! please check the keys! ");
            return;
        }
        String[] keyArray = keys.split("\\|");
        for (int i = 0; i < keyArray.length; i++) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date startTime = new Date();
            System.out.println("this key is :" + keyArray[i]);
            System.out.println("start time is :" + sdf.format(startTime));

            findKeyWordFromFile(sourcePath, descPath, keyArray[i], num);

            Date endTime = new Date();
            System.out.println("end time is :" + sdf.format(endTime));

        }
    }

    /**
     * 生成新文件。
     *
     * @param path 包括文件路径。格式，如：F:\\123\\344\\ss.s
     */
    public static void createMyNewFile(String path) {
        File file = new File(path);
        // 如果文件不存在。
        if (!file.exists()) {
            System.out.println("file is not exist!we will try create it!");
            ArrayList list = new ArrayList();
            if (System.getProperty("file.separator").equals("\\")) {
                for (int i = 0; i < path.split(
                        System.getProperty("file.separator") + System.getProperty("file.separator")).length; i++) {

                    list.add(
                            path.split(System.getProperty("file.separator") + System.getProperty("file.separator"))[i]);
                }

            } else {
                for (int i = 0; i < path.split(System.getProperty("file.separator")).length; i++) {

                    list.add(path.split(System.getProperty("file.separator"))[i]);
                }
            }

            String path1 = "";
            for (int i = 0; i < list.size(); i++) {

                if (!list.get(i).toString().contains(".")) {
                    path1 = path1 + list.get(i);
                    path1 = path1 + System.getProperty("file.separator");

                } else {
                    break;
                }
            }
            File file2 = new File(path1);

            file2.mkdirs();

            try {
                file.createNewFile();
                System.out.println("create file is ok!");
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {// 如果文件存在
            throw new RuntimeException("该文件已存在！！！！");
        }
    }

    /**
     * 只能对一个关键字（key）查询。 从一个文件（sourcePath）中查询这个关键字的上下文（行数num），
     * 并将查询的结果放入一个文件（descPath）中。
     *
     * @param sourcePath 需要查询文件路径
     * @param descPath   需要将查询的结果放入的文件
     * @param key        查找关键字
     * @param num        上下文行数
     * @throws IOException
     */
    public static void findKeyWordFromFile(String sourcePath, String descPath, String key, int num) {

        ArrayList list = new ArrayList();

        File sourceFile = new File(sourcePath);
        File desFile = new File(descPath);

        if (!desFile.exists()) {
            try {
                desFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        OutputStream os = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;

        String temp;
        Pattern pattern = Pattern.compile("(" + key + ")");
        Matcher matcher;
        boolean flag = false;
        int count = num;

        System.out.println("seacher start ...");

        Date start = new Date();
        SimpleDateFormat s1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("start time :" + s1.format(start));

        try {
            is = new FileInputStream(sourceFile);
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);

            os = new FileOutputStream(desFile);
            osw = new OutputStreamWriter(os);
            bw = new BufferedWriter(osw);

            while ((temp = br.readLine()) != null) {
                list.add(temp);
                matcher = pattern.matcher(temp);
                boolean f1 = false;
                // 判断是否存在该关键字段。
                if (f1 = matcher.find()) {
                    flag = f1;

                    // 如果找到该关键字，打印之前的几行。并清空。
                    for (int i = 0; i < list.size(); i++) {
                        bw.write(list.get(i) + System.getProperty("line.separator"));
                    }
                    for (int i = 0; i < list.size(); ) {
                        list.remove(0);
                    }
                } else {
                    // 如果记录结果的栈超过数量，去除。
                    if (list.size() > num) {
                        list.remove(0);
                    }
                    // 之前找到了相关的信息。
                    if (flag) {
                        if (count != 0) {
                            bw.write(temp + System.getProperty("line.separator"));
                            list.remove(0);
                            count--;
                            if (count == 0) {
                                flag = false;
                                count = num;
                            }
                        } else {
                        }
                    }
                }

            }

            bw.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                isr.close();
                is.close();

                bw.close();
                osw.close();
                os.close();
            } catch (Exception e) {
            }
        }

        Date end = new Date();
        System.out.println("start time :" + s1.format(end));
        System.out.println("seacher end !");

    }

    /**
     * @param Url      资源路径
     * @param fileName 文件路径，包括文件名全称。
     */
    public static void getResourceFromUrl(String Url, String fileName) {
        Long time1 = System.currentTimeMillis();
        File file = new File(fileName);
        InputStream is = null;
        HttpURLConnection huc;
        OutputStream os = null;

        try {
            URL url = new URL(Url);
            huc = (HttpURLConnection) url.openConnection();
            // 通过指定的URL 获得字节流。
            is = huc.getInputStream();

            if (!file.exists()) {
                file.createNewFile();
            }
            os = new FileOutputStream(file);
            byte[] buffer = new byte[1024];
            System.out.println("It's start .....");
            while (true) {
                int len = is.read(buffer);
                if (len == -1) {
                    System.out.println("It's end!");
                    break;
                }
                os.write(buffer, 0, len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                os.close();
            } catch (Exception e) {
            }
        }
        Long time2 = System.currentTimeMillis();
        System.out.println("===>cost time:" + (time2 - time1));

    }

    /**
     * 从文件列表中获取文件名称列表
     *
     * @param files
     * @return
     */
    public static List<String> getFilenamesFromFiles(List<File> files) {
        if (null == files || 0 == files.size()) {
            return null;
        }

        List<String> result = new ArrayList<String>();

        for (File file : files) {
            result.add(file.getName());
        }

        return result;
    }

    /**
     * 获取文件夹下的所有的文件（深层次）
     *
     * @param dirFile
     * @return
     */
    public static List<File> getAllFilesFromDirDeep(String dirFile) {
        return getAllFilesFromDirDeep(new File(dirFile));
    }

    /**
     * 获取文件夹下的所有的文件（深层次）
     *
     * @param dirFile
     * @return
     */
    public static List<File> getAllFilesFromDirDeep(File dirFile) {
        if (null == dirFile) {
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


}
