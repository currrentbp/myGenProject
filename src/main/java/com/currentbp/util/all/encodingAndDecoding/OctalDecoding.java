package com.currentbp.util.all.encodingAndDecoding;

import com.currentbp.common.model.Student;
import com.currentbp.util.all.StringUtil;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class OctalDecoding {

    @Test
    public void t2(){
        List<Student> students = Lists.newArrayList(new Student(1,"1"),new Student(2,"2"),new Student(3,"3"));
        StringUtil.printObject(students);
        students = doFilter(students);
        StringUtil.printObject(students);
    }
    private List<Student> doFilter(List<Student> students){
        students = students.stream().filter(x -> !x.getId().equals(2)).collect(Collectors.toList());
        return students;
    }

    @Test
    public void t1() {
        String source1 = "\\344\\270\\273\\346\\222\\255\\345\\267\\262\\345\\274\\200\\345\\205\\266\\344\\273\\226\\346\\210\\277\\351\\227\\264";
        String s1 = doDecoding4Octal(source1);
        System.out.println(s1);
    }

    /**
     * 8进制的转译：将8进制的字符串转译成正常utf-8的
     */
    public String doDecoding4Octal(String source) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(source.getBytes());
        int read = -1;
        byte[] byte3 = new byte[3];
        while ((read = inputStream.read()) > -1) {
            if (read == '\\') {
                try {
                    inputStream.read(byte3);
                } catch (IOException e) {
                    e.printStackTrace();
                }
//                System.out.println("===>"+new String(byte3)+", parse:"+Integer.parseInt(new String(byte3), 8));
                outputStream.write(Integer.parseInt(new String(byte3), 8));
            } else {
                outputStream.write(read);
            }
        }
        String decodeMessage = null;
        try {
            decodeMessage = new String(outputStream.toByteArray(), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decodeMessage;
    }

    @Test
    public void t4(){
        String s = doEncoding4Octal("你加入的什么是快乐星球聊天室涉及敏感话题，已被管理员强制关闭。");
        System.out.println(s);
    }

    public String doEncoding4Octal(String source){
        //todo not work
        char[] chars = source.toCharArray();
        StringBuffer stringBuffer = new StringBuffer("");
        for (char aChar : chars) {
            stringBuffer.append(Integer.toOctalString(aChar));
        }
        return stringBuffer.toString();
    }
}
