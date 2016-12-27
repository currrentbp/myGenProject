package com.bp.util.all;

import com.bp.staticValue.StaticValue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 密码生成器
 *
 * @author current_bp
 * @createTime 20161222
 */
public class PWDGenUtil {

    public String nums = "0123456789";
    public String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private List<String> pwds = new ArrayList<String>();
    private LinkedList<String> linkedList = new LinkedList<String>();


    /**
     * 产生密码本：纯粹数字的，
     * 长度超过6位就速度非常的慢，而且经常卡机
     *
     * @param len  长度
     * @param path 生成的路径
     */
    public void genPuleNumDic(String numsOrLetters,int len, String path) {
        int index = StaticValue.START_INDEX.getValue();
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
     * @param numsOrLetters 数据源
     * @param len 最大长度
     * @param filePath 文件位置
     */
    public void genPuleNumDic2(String numsOrLetters,int len, String filePath) {
        StringBuilder sb = new StringBuilder();
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
        for(String next : linkedList){
            if (linkedList.size() > 0){
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

    public static void main(String[] args) {

        PWDGenUtil pu = new PWDGenUtil();
        pu.genPuleNumDic2("0123456789", 6, "E:\\tmp\\bp.dic");//7位：85600Kb
    }
}
