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
        String source1 = "\\344\\275\\240\\345\\267\\262\\346\\210\\220\\344\\270\\272\\346\\214\\272\\346\\234\\211\\346\\204\\217\\344\\271\\211\\350\\201\\212\\345\\244\\251\\345\\256\\244\\347\\232\\204\\344\\270\\273\\346\\214\\201\\344\\272\\272\\357\\274\\201\\347\\216\\260\\345\\234\\250\\344\\275\\240\\345\\217\\257\\344\\273\\245\\351\\202\\200\\350\\257\\267\\345\\205\\266\\344\\273\\226\\347\\224\\250\\346\\210\\267\\345\\212\\240\\345\\205\\245\\343\\200\\202";
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
}
