package com.currentbp.util.all;

import com.currentbp.staticValue.StaticValue;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 密码生成器
 *
 * @author current_bp
 * @createTime 20161222
 */
public class PWDGenUtil {

    private long count = 0;
    public String nums = "0123456789";
    public String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static String Num_Letters = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";


    /**
     * 产生密码本：纯粹数字的，
     * 长度超过6位就速度非常的慢，而且经常卡机
     *
     * @param len  长度
     * @param path 生成的路径
     */
    public void genDic(String numsOrLetters, int len, String path) {
        int index = StaticValue.START_INDEX.getValue();
        List<String> pwds = new ArrayList<String>();
        boolean flag = false;
        while (true) {
            //初始化这个列表
            if (StaticValue.START_INDEX.getValue() == index) {
                for (int j = 0; j < numsOrLetters.length(); j++) {
                    pwds.add("" + numsOrLetters.charAt(j));
                }
                index++;
                continue;
            }

            for (int j = 0; j < numsOrLetters.length(); j++) {
                if (null != pwds.get(index) && pwds.get(index).length() == len) {
                    flag = true;
                    break;
                }

                if (pwds.size() < Integer.MAX_VALUE) {
                    StringBuffer sb = new StringBuffer();
                    sb.append(pwds.get(index)).append(numsOrLetters.charAt(j));

                    pwds.add(sb.toString());
                }
            }

            index++;
            if (flag) {
                break;
            }
        }

        System.out.println(pwds);
        StringBuilder sb = new StringBuilder();

        for (String pwd : pwds) {
            sb.append(pwd + "\n");
        }
        try {
            StreamUtil.writeSomethingToFile(sb.toString(), path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 产生密码本：纯粹数字的，
     * 长度超过6位就速度非常的慢
     *
     * @param numsOrLetters 数据源
     * @param len           最大长度
     * @param filePath      文件位置
     */
    public void genDic2(String numsOrLetters, int len, String filePath) {
        StringBuilder sb = new StringBuilder();
        LinkedList<String> linkedList = new LinkedList<String>();
        //初始化列表
        for (int i = 0; i < numsOrLetters.length(); i++) {
            linkedList.addLast("" + numsOrLetters.charAt(i));
        }

        String first;
        while (true) {
            first = linkedList.getFirst();
            sb.append(first + "\n");
            System.out.println(first);
            linkedList.removeFirst();
            if (len == first.length()) {
                break;
            }

            for (char c : numsOrLetters.toCharArray()) {
                linkedList.addLast(first + c);
            }
        }

        //将剩余的继续写入到linkedList中
        for (String next : linkedList) {
            if (linkedList.size() > 0) {
                sb.append(next + "\n");
                System.out.println(next);
            }
        }

        try {
            System.out.println("len:" + sb.length());
            StreamUtil.writeSomethingToFile(sb.toString(), filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成密码本，纯粹是数字的密码本，
     *
     * @param length   开始长度，不能小于0
     * @param filePath 生成文件的路径
     */
    public void genDic3(int length, String filePath) {
        genDic3(length, length, filePath);
    }

    /**
     * 生成密码本，纯粹是数字的密码本，
     *
     * @param startLength 开始长度，不能小于0
     * @param endLength   最长的长度，不能小于开始长度
     * @param filePath    生成文件的路径
     */
    public void genDic3(int startLength, int endLength, String filePath) {
        if (startLength <= 0 || endLength < startLength || CheckUtil.isEmpty(filePath)) {
            return;
        }

        FileWriter fileWriter = StreamUtil.createFileWriter(filePath);
        for (int i = startLength; i <= endLength; i++) {
            createStaticLenNum(i, fileWriter);
            try {
                fileWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 生成密码本，数字和字母混合的密码本，
     * 感觉数据量有点大
     *
     * @param startLength 开始长度，不能小于0
     * @param endLength   最长的长度，不能小于开始长度
     * @param filePath    生成文件的路径
     */
    public void genDic4(int startLength, int endLength, String filePath){
        if (startLength <= 0 || endLength < startLength || CheckUtil.isEmpty(filePath)) {
            return;
        }

        FileWriter fileWriter = StreamUtil.createFileWriter(filePath);
        for (int i = startLength; i <= endLength; i++) {
            createStaticLenNumAndLetters(i, fileWriter);
            try {
                fileWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 产生一个固定长度的数字和字符密码串
     * @param length 长度
     * @param fileWriter 写入文件流
     */
    private void createStaticLenNumAndLetters(int length, FileWriter fileWriter) {
        String numAndLetters = null;
        char[] lastCode = new char[length];
        //初始化
        Arrays.fill(lastCode,'0');

        while(true){
            //先不管进位的问题，
            try {
                fileWriter.write(getNums2(lastCode));
            } catch (IOException e) {
                e.printStackTrace();
            }
            //考虑进位的问题
            boolean isB = numBeyond2(lastCode);
            if (isB) {
                break;
            }
        }
    }



    /**
     * 产生一个固定长度的数字密码串
     *
     * @param length     长度
     * @param fileWriter 写入流
     */
    private void createStaticLenNum(int length, FileWriter fileWriter) {
        int[] nums = new int[length];
        String snums = null;

        while (true) {
            count++;
            if (count / 10000 != 0 && count % 10000 == 0) {
                System.out.println("===>输出数据数量：" + (count / 10000) + " 万条");
            }
            //先不管进位的问题，
            try {
                fileWriter.write(getNums1(nums));
            } catch (IOException e) {
                e.printStackTrace();
            }
            //考虑进位的问题
            boolean isB = numBeyond(nums);
            if (isB) {
                break;
            }

        }

    }


    /**
     * 类似进位问题，从倒数第二位开始，
     *
     * @param lastedCode 原始的数据
     * @return 是否溢出
     */
    public boolean numBeyond2(char[] lastedCode) {
        boolean flag = false;
        if (lastedCode.length == 1) {
            return true;
        }
        for (int i = 1; i < lastedCode.length; i++) {
            char k = lastedCode[i];
            boolean isB = isBeyond2(lastedCode[i], 1);
            if (i == lastedCode.length - 1 && isB) {//如果是最高位，而且溢出了，表示不需要再生成密码了，因为已经溢出了
                flag = true;
                break;
            }

            if (isB) {
                lastedCode[i] = 0;
                continue;
            } else {
                lastedCode[i] = Num_Letters.charAt(Num_Letters.indexOf(k)+1);
                flag = false;
                break;
            }
        }
        return flag;
    }

    /**
     * 类似进位问题，从倒数第二位开始，
     *
     * @param nums 原始的数据
     * @return 是否溢出
     */
    public boolean numBeyond(int[] nums) {
        boolean flag = false;
        if (nums.length == 1) {
            return true;
        }
        for (int i = 1; i < nums.length; i++) {
            int k = nums[i];
            boolean isB = isBeyond(nums[i], 1);
            if (i == nums.length - 1 && isB) {//如果是最高位，而且溢出了，表示不需要再生成密码了，因为已经溢出了
                flag = true;
                break;
            }

            if (isB) {
                nums[i] = 0;
                continue;
            } else {
                nums[i] = k + 1;
                flag = false;
                break;
            }
        }
        return flag;
    }

    /**
     * 每次在最后一位修改10次，获得10组不同的数字串
     *
     * @param lastedCode 最近的一个密码
     * @return 获取10组密码
     */
    private String getNums2(char[] lastedCode) {
        StringBuilder result = new StringBuilder("");
        String prefix = "";
        for (int i = 1; i < lastedCode.length; i++) {
            prefix  = lastedCode[i] + prefix;
        }

        for (int j = 0; j < Num_Letters.length(); j++) {
            count++;
            if (count < 100000000L && count / 10000 != 0 && count % 10000 == 0) {
                System.out.println("===>输出数据数量：" + (count / 10000) + " 万条");
            }else if(count >= 100000000L && count / 100000000 != 0 && count % 100000000 == 0){
                System.out.println("===>输出数据数量：" + (count / 100000000) + " 亿条");
            }
            result.append(prefix + Num_Letters.charAt(j) + "\n");
        }
        return result.toString();
    }

    /**
     * 每次在最后一位修改10次，获得10组不同的数字串
     *
     * @param nums 最近的一个密码
     * @return 获取10组密码
     */
    private String getNums1(int[] nums) {
        StringBuilder result = new StringBuilder("");
        String s = "";
        for (int i = nums.length - 1; i > 0; i--) {
            s = s + nums[i];
        }

        for (int j = 0; j < 10; j++) {
            result.append(s + j + "\n");
        }
        return result.toString();
    }

    /**
     * 是否需要进位
     *
     * @param resource 原数据
     * @param append   加数
     * @return 是否进位
     */
    private boolean isBeyond(int resource, int append) {
        return resource + append >= 10;
    }

    /**
     * 是否需要进位
     *
     * @param resource 原数据
     * @param append   加数
     * @return 是否进位
     */
    private boolean isBeyond2(char resource, int append) {
        int index = Num_Letters.indexOf(resource);
        return index + append >= Num_Letters.length();
    }

    /**
     * 生成一个纯数字的字典
     *
     * @param path 文件路径
     * @param len  长度
     */
    public void genPuleNumDic(String path, int len) {
        genDic2(nums, len, path);
    }

    /**
     * 生成一个纯字符的字典
     *
     * @param path 文件路径
     * @param len  长度
     */
    public void genPuleLetterDic(String path, int len) {
        genDic2(this.letters, len, path);
    }

    /**
     * 生成一个既有数字又有字符的字典
     *
     * @param path 文件路径
     * @param len  长度
     */
    public void genNumAndLetterDic(String path, int len) {
        genDic2(this.nums + this.letters, len, path);
    }

    public static void main(String[] args) {

//        PWDGenUtil pu = new PWDGenUtil();
//        pu.genDic2("0123456789", 6, "E:\\tmp\\currentbp.dic");//7位：85600Kb

        //创建一个既有数字又有字符的字典
//        PWDGenUtil pu = new PWDGenUtil();
//        pu.genNumAndLetterDic("e:/baopan.dic", 2);

//        //test
//        PWDGenUtil pu = new PWDGenUtil();
//        int[] s = new int[3];
//        s[0] = 0;
//        s[1] = 2;
//        s[2] = 3;
//        pu.getNums1(s);

//        //test
//        PWDGenUtil pu = new PWDGenUtil();
//        int[] s = new int[3];
//        s[0] = 0;
//        s[1] = 9;
//        s[2] = 9;
//        System.out.println(pu.numBeyond(s));

        PWDGenUtil pu = new PWDGenUtil();
        pu.genDic4(1, 5, "E:\\tmp\\currentbp.dic");//7位：85600Kb
    }
}
