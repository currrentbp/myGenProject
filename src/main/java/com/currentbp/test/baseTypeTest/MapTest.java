package com.currentbp.test.baseTypeTest;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author baopan
 * @createTime 20220112
 */
public class MapTest {

    @Test
    public void t4(){
        String par = "^[0-9]{2}:[0-9]{2}$";
        Pattern pattern = Pattern.compile(par);
        Matcher matcher = pattern.matcher("10:10");
        Matcher matcher2 = pattern.matcher("110:10");
        Matcher matcher3 = pattern.matcher("0:10");
        Matcher matcher4 = pattern.matcher("1010");
        Matcher matcher5 = pattern.matcher("10::10");
//        Matcher matcher6 = pattern.matcher(null);
        Matcher matcher7 = pattern.matcher("");
        System.out.println(matcher7.matches());
    }

    @Test
    public void t3(){
        long increment = 1L;
        int bannerFrequency = 3;
        long x = (increment - 1L) % bannerFrequency;
        boolean result = x != 0L;
        System.out.println(result+",x:"+x);
    }

    @Test
    public void t2() {
        String s1 = "dev_100002";
        try {
            System.out.println(Long.parseLong(s1.split("_")[1]));
        } catch (Exception e1) {

        }
    }

    @Test
    public void t1() {
        Map<String, Object> temp = new HashMap<>();
        temp.put("s1", 1L);
        temp.put("s2", "s2");
        temp.put("s3", null);
        Long s1 = (Long) temp.get("s1");
        System.out.println("s1:" + s1);
        String s2 = (String) temp.get("s2");
        System.out.println("s2:" + s2);

        Long s3 = (Long) temp.get("s3");
        System.out.println("s3:" + s3);

    }
}
