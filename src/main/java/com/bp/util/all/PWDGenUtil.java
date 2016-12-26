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
    private List<String> pwds = new ArrayList<String>();
    private LinkedList<String> linkedList = new LinkedList<String>();


    /**
     * 产生密码本：纯粹数字的，
     * 长度超过6位就速度非常的慢，而且经常卡机
     * @param len 长度
     * @param path 生成的路径
     */
    public void genPuleNumDic(int len, String path) {
        int index = StaticValue.START_INDEX.getValue();
        boolean flag = false;
        while (true) {
            //初始化这个列表
            if (StaticValue.START_INDEX.getValue() == index) {
                for(int j=0;j<nums.length();j++){
                    pwds.add(""+nums.charAt(j));
                }
                index++;
                continue;
            }

            for (int j = 0; j < nums.length(); j++) {
                if (null != pwds.get(index) && pwds.get(index).length() == len) {
                    flag = true;
                    break;
                }

                if (pwds.size() < Integer.MAX_VALUE) {
                    StringBuffer sb = new StringBuffer();
                    sb.append(pwds.get(index)).append(nums.charAt(j));

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

        for (String pwd:pwds) {
            sb.append(pwd+"\n");
        }
        try {
            StreamUtil.writeSomethingToFile(sb.toString(),path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void test1(int len){

    }

    public static void main(String[] args) {

        PWDGenUtil pu = new PWDGenUtil();
        pu.genPuleNumDic(5, "E:\\tmp\\bp.dic");
    }
}
